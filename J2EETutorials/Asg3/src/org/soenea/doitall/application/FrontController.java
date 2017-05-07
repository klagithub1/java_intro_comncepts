package org.soenea.doitall.application;

import java.io.IOException;
import java.sql.SQLException;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.dsrg.soenea.service.MySQLConnectionFactory;
import org.dsrg.soenea.service.registry.Registry;
import org.dsrg.soenea.service.threadLocal.DbRegistry;
import org.dsrg.soenea.service.threadLocal.ThreadLocalTracker;
import org.dsrg.soenea.uow.MapperFactory;
import org.dsrg.soenea.uow.UoW;
import org.soenea.doitall.application.dispatcher.Dispatcher;
import org.soenea.doitall.domain.model.invite.Invite;
import org.soenea.doitall.domain.model.invite.mapper.InviteOutputMapper;

public class FrontController extends HttpServlet {
	private static final long serialVersionUID = 1L;

	@Override
	public void init() throws ServletException {
		super.init();
		prepareDbRegistry("");
	}

	public static void prepareDbRegistry(String db_id) {
		MySQLConnectionFactory f = new MySQLConnectionFactory(null, null, null,
				null);
		try {
			f.defaultInitialization(db_id);
		} catch (SQLException e2) {
			e2.printStackTrace();
		}
		DbRegistry.setConFactory(db_id, f);
		String tablePrefix;
		try {
			tablePrefix = Registry.getProperty(db_id + "mySqlTablePrefix");
		} catch (Exception e1) {
			e1.printStackTrace();
			tablePrefix = "";
		}
		if (tablePrefix == null) {
			tablePrefix = "";
		}
		DbRegistry.setTablePrefix(db_id, tablePrefix);
	}

	protected void processRequest(HttpServletRequest request,
			HttpServletResponse response) throws ServletException, IOException {
		Dispatcher fc = getFrontCommand(request);
		if (fc == null) {
			String msg = "Invalid or unspecified command";
			if (request.getParameter("command") != null)
				msg += " (" + request.getParameter("command") + ")";
			response.sendError(HttpServletResponse.SC_NOT_FOUND, msg);
		} else {
			fc.init(request, response);
			fc.execute();
		}
	}

	private Dispatcher getFrontCommand(HttpServletRequest request) {
		try {
			String command = getCommandFromPathInfoAndMaybeSetSomeAttributes(request);
			if (command == null)
				command = request.getParameter("command");
			if (command == null || command.isEmpty()) {
				return null;
			}
			String fqCommand = "org.soenea.doitall.application.dispatcher."
					+ command;
			return (Dispatcher) Class.forName(fqCommand).newInstance();
		} catch (Exception e) {
			e.printStackTrace();
			return null;
		}
	}

	protected void doPost(HttpServletRequest request,
			HttpServletResponse response) throws ServletException, IOException {
		doGet(request, response);
	}

	protected void doGet(HttpServletRequest request,
			HttpServletResponse response) throws ServletException, IOException {
		preProcessRequest(request, response);
		try {
			processRequest(request, response);
		} finally {
			postProcessRequest(request, response);
		}
	}

	protected void preProcessRequest(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		setupUoW();
	}

	protected void postProcessRequest(HttpServletRequest request,
			HttpServletResponse response) throws ServletException, IOException {
		Exception e = null;
		try {
			DbRegistry.closeDbConnectionIfNeeded();
		} catch (Exception e1) {
			e = e1;
		}
		ThreadLocalTracker.purgeThreadLocal();
		if (e != null)
			throw new ServletException("postProcessRequest database close", e);
	}

	/**
	 * Attempt to extract the command from the request's pathInfo. Note that
	 * this method might set request attributes.
	 * 
	 * @param request
	 * @return null or the command as a simple class name (i.e. not fully
	 *         qualified with the package).
	 */
	private String getCommandFromPathInfoAndMaybeSetSomeAttributes(HttpServletRequest request) {
		
		String path = request.getPathInfo();
		
		if (path == null)
			return null;

		String command = null;

		Pattern pattern = Pattern.compile("^/([^/]+)/(([^/]+)/(\\d+)?)?$");
		Matcher matcher = pattern.matcher(path);
		
		if (matcher.find()) {
			
			command = capitalize(matcher.group(1));
			
			String subcommand = matcher.group(3);
			if(subcommand != null)
				command += capitalize(subcommand);
			
			String id = matcher.group(5);
			if(id != null)
				request.setAttribute("id", id);
		}
			
		return command;
	}

	private static String capitalize(String input) {
	
		if(input == null)
			return null;
		
		return (input.length() <= 1) ?
			input.toUpperCase() :
			input.substring(0, 1).toUpperCase() + input.substring(1);
	}
	public static void setupUoW() { 
		
		// Flush any previously allocated UoW
		UoW.newCurrent();
		
		MapperFactory mf = new MapperFactory();
		// TODO: add more
		mf.addMapping(Invite.class, InviteOutputMapper.class); 
		UoW.initMapperFactory(mf);
	}
}
