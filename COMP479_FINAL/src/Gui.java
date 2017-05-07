import java.awt.Color;
import java.awt.Dimension;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.ItemEvent;
import java.awt.event.ItemListener;
import java.awt.event.KeyEvent;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;
import java.util.Map.Entry;
import java.util.Properties;
import java.util.StringTokenizer;
import java.util.TreeMap;

import javax.swing.JButton;
import javax.swing.JCheckBox;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTextArea;
import javax.swing.JTextField;
import javax.swing.SwingUtilities;
import javax.swing.text.DefaultHighlighter;

import javax.swing.text.Highlighter;
import java.io.StringWriter;
import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.parsers.ParserConfigurationException;
import javax.xml.transform.Transformer;
import javax.xml.transform.TransformerException;
import javax.xml.transform.TransformerFactory;
import javax.xml.transform.dom.DOMSource;
import javax.xml.transform.stream.StreamResult;
import org.w3c.dom.Document;
import org.w3c.dom.Element;

import net.sf.javaml.core.Instance;


public class Gui extends JFrame implements ActionListener,ItemListener 
{

	private static final long serialVersionUID = 1L;

	JPanel panel = new JPanel();
    JPanel leftPanel = new JPanel();
    JPanel middlePanel = new JPanel();
    JPanel rightPanel = new JPanel();
    
    JCheckBox caseFolding;
    JCheckBox withNoNumbers;
    JCheckBox noStopWords;
    
    JButton indexing;
    JButton search;
    JButton getDoc;
    JButton back;
    JButton vectorize;
    JButton cluster;
    JButton clusterDisplay;
    JButton bm25;
    
    JTextArea area;
    JTextField searchArea;
    JTextField docIdText;
    
    JScrollPane scrolltxt;
    JScrollPane scrolltxt2;
    
    String oldAreaText ;
	boolean isCaseFolding = true;
	boolean isNoNumbers = true;
	boolean isStopWords = true;
	 
	List<CustomInstance> returned;
	Dictionary finalTree = new Dictionary();
	HashMap<String,String> docContents = new HashMap<String,String>();
	String searchAreaValue;
	ClusteredCollection finalClustering;
	ClusterSet bestCluster;
	
	final Highlighter hilit;
	final Highlighter.HighlightPainter painter;

	public Gui() 
	{

		leftPanel.setLayout(new GridLayout(6,1));
        rightPanel.setLayout(new GridLayout(4,1));
        
        //***************************************************************************************************************
        //Creating the check boxes
        caseFolding = new JCheckBox("With Case Folding");
        caseFolding.setMnemonic(KeyEvent.VK_C); 
        caseFolding.setSelected(true);
        
        withNoNumbers = new JCheckBox("With no numbers");
        withNoNumbers.setMnemonic(KeyEvent.VK_N); 
        withNoNumbers.setSelected(true);
        
        noStopWords = new JCheckBox("With no Stop Words");
        noStopWords.setMnemonic(KeyEvent.VK_S);
        noStopWords.setSelected(true);
        
        //***************************************************************************************************************
        //Adding checkboxes to the left panel
        leftPanel.add(caseFolding);
        leftPanel.add(withNoNumbers);
        leftPanel.add(noStopWords);
        //***************************************************************************************************************
        
        //***************************************************************************************************************
        //Creating a text area placeholder 
        area = new JTextArea("");
        
        hilit = new DefaultHighlighter();
        painter = new DefaultHighlighter.DefaultHighlightPainter(Color.yellow);
        area.setHighlighter(hilit);
        
        scrolltxt = new JScrollPane(area); 
        scrolltxt.setVerticalScrollBarPolicy(JScrollPane.VERTICAL_SCROLLBAR_AS_NEEDED);
        scrolltxt.setPreferredSize(new Dimension(500, 500));

        area.setEditable(false);
        area.setLineWrap(true);
        area.setWrapStyleWord(true);
        middlePanel.add(scrolltxt);
        
        searchArea = new JTextField("search area");
        searchArea.setEditable(true);
        
        docIdText = new JTextField("Doc Id");
        docIdText.setEditable(true);
        
        rightPanel.add(docIdText);
        //***************************************************************************************************************
        //Creating the buttons
        indexing = new JButton("Index Document");
        leftPanel.add(indexing);
        indexing.addActionListener(this);
        
        leftPanel.add(searchArea);
        search = new JButton("Search");
        search.addActionListener(this);
        leftPanel.add(search);
        
        getDoc = new JButton("Get URL");
        getDoc.addActionListener(this);
        rightPanel.add(getDoc);
        
        back = new JButton("back");
        back.addActionListener(this);
        rightPanel.add(back);

        vectorize = new JButton("Vectorize");
        vectorize.addActionListener(this);
        rightPanel.add(vectorize);
        
        cluster = new JButton("Cluster");
        cluster.addActionListener(this);
        rightPanel.add(cluster);
        
        clusterDisplay = new JButton("Display Clusters");
        clusterDisplay.addActionListener(this);
        rightPanel.add(clusterDisplay);
        
        bm25 = new JButton("Bm25");
        bm25.addActionListener(this);
        rightPanel.add(bm25);
        //***************************************************************************************************************
        //Adding everything to the main panel
        panel.add(leftPanel);
        panel.add(middlePanel);
        panel.add(rightPanel);
        //***************************************************************************************************************

        add(panel);
        pack();

        setTitle("Spimi Assignment 2");
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setLocationRelativeTo(null);
	        
    }

    public static void main(String[] args) 
    {

        SwingUtilities.invokeLater(new Runnable() 
        {

            public void run() 
            {

            	Gui ex = new Gui();
                ex.setVisible(true);
            }
        });
        
    }
    public void itemStateChanged(ItemEvent e)
    {
    	
	   	 Object source = e.getItemSelectable();
		 
	     if (source == caseFolding) 
	     {
	    	 
	    	 if(isCaseFolding)
	    		 isCaseFolding = false;
	    	 else
	    		 isCaseFolding = true;
	    	 
	     } 
	     else if (source == withNoNumbers) 
	     {
	    	 
	    	 if(isNoNumbers)
	    		 isNoNumbers = false;
	    	 else
	    		 isNoNumbers = true;
	    	 
	     } 
	     else if (source == noStopWords) 
	     {
	    	 
	    	 if(isStopWords)
	    		 isStopWords = false;
	    	 else
	    		 isStopWords = true;
	    	 
	     }	        
    	
    }
    
	@Override
	public void actionPerformed(ActionEvent e) 
	{
		

		
		String buttonPressed = e.getActionCommand();
		if(buttonPressed.equals("Search"))
		{
			
			long startTime = System.currentTimeMillis();
			
			String query = searchArea.getText();
			
			ArrayList<ClusterSet> returnedClusters = finalClustering.getClusteredCollection();
			bestCluster = QueryVector.clusterForQuery(returnedClusters, query, finalTree);
			
			System.out.println("Searched contained in" + bestCluster.getName());
			long endTime = System.currentTimeMillis();
			area.append("Searched contained in" + bestCluster.getName() +"\n");
			area.append("Time taken for searching is " + (endTime - startTime)/1000d + "seconds\n");
			
		}
		if(buttonPressed.equals("Index Document"))
		{
			
			long startTime = 0L;
				
			startTime = System.currentTimeMillis();
			
			String fileResourcePath = "B:\\dev\\COMP479_FINAL\\src\\MyResources.properties";
			
			String actualPath = null;
			
			Properties props = new Properties();
			try {
				props.load(new FileInputStream(fileResourcePath));
			} catch (FileNotFoundException e1) {
				e1.printStackTrace();
			} catch (IOException e1) {
				e1.printStackTrace();
			}
			
			actualPath = props.getProperty("path");
			//Getting all the files from the folders
			LinkedList<String> container = new LinkedList<String>();
			LinkedList<String> fileNames = CustomTokenizer.getAllFiles(container, actualPath);
			
			Iterator<String> fileNamesIt = fileNames.iterator();
			String fileName = null;
			
			while(fileNamesIt.hasNext())
			{
				
				fileName = fileNamesIt.next();
				
				String content = ReadFile.readFile(fileName);
				
				fileName = fileName.replace("B:\\dev\\COMP479_FINAL\\pages", "");
				fileName = fileName.replaceAll("\\\\", "/");
				docContents.put(fileName, content);
				
				finalTree = CustomTokenizer.newTokenize(content, fileName, isCaseFolding, isStopWords,  isNoNumbers, finalTree);
				area.append("On file "+fileName + "\n");
				
			}
			
			//Getting total document size
			finalTree.setTotalSize(finalTree.fullDocLenght());
			
			area.append("Size of dictionary is " +finalTree.getContent().size()+"\n");
			long endTime = System.currentTimeMillis();
			area.append("Total elapsed time in execution is :"+ (endTime-startTime)/1000d + "seconds\n");
			area.append("Size of file list is " +docContents.size()+"\n");
			
		} 
		else if(buttonPressed.equals("Vectorize"))
		{
			
			long startTime = System.currentTimeMillis();
		
			returned = VectorSpace.vectorize(finalTree, docContents);
			Iterator<CustomInstance> it = returned.iterator();
			while(it.hasNext())
			{   
				
				CustomInstance currentCInstance = (CustomInstance)it.next();
				Instance current = currentCInstance.getInst();
			
				for (Integer key : current.keySet()) 
				{
					System.out.print(current.get(key)+" ");
					
				}
				System.out.println("");
				
			}
			
			long endTime = System.currentTimeMillis();
			System.out.println("Total elapsed time for vectorizing is :"+ (endTime-startTime)/1000d + "seconds");
			area.append("Total elapsed time for vectorizing is :"+ (endTime-startTime)/1000d + "seconds\n");
			
		}
		else if(buttonPressed.equals("Cluster"))
		{
			
			long startTime = System.currentTimeMillis();
		
			//---------------------------------------------------------------------------
			//CLUSTERING
			KMeansClustering clustering = new KMeansClustering(10,returned);
			area.append("Clustering the Vector Space");
			finalClustering = clustering.clusterVectorSpace();
			area.append("Clustering ...(please wait) ... ...\n ... ... ... ");
			area.append("Clustering ENDED");
			//---------------------------------------------------------------------------
			
			long endTime = System.currentTimeMillis();
			
			System.out.println("Total elapsed time for clustering is :"+ (endTime-startTime)/1000d + "seconds");
			area.append("Total elapsed time for clustering is :"+ (endTime-startTime)/1000d + "seconds\n");
			
		}
		else if(buttonPressed.equals("Display Clusters"))
		{
			ArrayList<String> xmlcontainer = new ArrayList<String>();
			
			
			
			ArrayList<ClusterSet> returnedClusters = finalClustering.getClusteredCollection();
			
				DocumentBuilderFactory dFact = DocumentBuilderFactory.newInstance();
	            DocumentBuilder build;
	           // Document doc = null;
				try {
					build = dFact.newDocumentBuilder();
					Document doc = build.newDocument();
			 
				
				
				
				 Element root = doc.createElement("root");
			     doc.appendChild(root);
			     Element clusterSetNode = doc.createElement("clusterSet");
	          

			     for(int i = 0; i<returnedClusters.size();i++)
			     {

			    	 System.out.println("******************************************"+returnedClusters.get(i).getName()+"******************************************");
			    	 area.append("******************************************"+returnedClusters.get(i).getName()+"******************************************\n");

			    	 Element cluster = doc.createElement("cluster");
			    	 clusterSetNode.appendChild(cluster);
			    	 ClusterSet current  = returnedClusters.get(i);
			    	 xmlcontainer.add(current.getCentroid().getInst() + "\n");
			    	 

			    	 System.out.println("XMLCONTAINER " + xmlcontainer.get(i));

			    	 


			    	 ArrayList<CustomInstance> returnedInstances = current.getClusterSet();


			    	 for(int j = 0 ; j<returnedInstances.size();j++)
			    	 {

			    		 //for loop for the xml files
			    		 for(Entry<Integer, Double> doubleValue : returnedInstances.get(j).getInst().entrySet()){

			    			 System.out.println(doubleValue.getValue());
			    			 Element clusterValue = doc.createElement("ClusterValue");
			    			 clusterValue.appendChild(doc.createTextNode(doubleValue.getValue().toString()));
			    			 cluster.appendChild(clusterValue);

			    		 }
			    		 
			    		 

			    		 String original = returnedInstances.get(j).getName();
			    		 String url = original.substring(original.lastIndexOf("\\")+1,original.length());

			    		 System.out.println(url);
			    		 area.append(url+"\n");

			    	 }
			    	 
			    	 clusterSetNode.appendChild(cluster);
			    	 root.appendChild(clusterSetNode);

			     }


			   
			    	 TransformerFactory tFact = TransformerFactory.newInstance();
			    	 Transformer trans = tFact.newTransformer();

			    	 StringWriter writer = new StringWriter();
			    	 
			    	 File outputFile = new File("B:\\dev\\COMP479_FINAL\\output.xml");
			    	 StreamResult result = new StreamResult(outputFile);
			    	 DOMSource source = new DOMSource(doc);
			    	 trans.transform(source, result);
			    	 
			    	 
			    	 System.out.println("XML PARSER " + writer.toString());
			    	 //area.append(writer.toString());

            

        } catch (TransformerException ex) {
            System.out.println("Error outputting document");
        } catch (ParserConfigurationException e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
        
        }
			
		}
		else if(buttonPressed.equals("Bm25"))
		{
			
			long startTime = System.currentTimeMillis();
	
			searchAreaValue = searchArea.getText();
			
			HashMap<String,Double> returnFromCalc = BMCalc.calculate(searchAreaValue, finalTree,bestCluster);
			
			ValueComparator newSort = new ValueComparator(returnFromCalc) ;

			TreeMap<String,Double> sorted_map = new TreeMap<String,Double>(newSort);

			sorted_map.putAll(returnFromCalc);
			
			area.setText("");
	        for (String key : sorted_map.keySet()) 
	        {
	        	if(sorted_map.get(key)!= null)
	        		area.append((key + "\t"+sorted_map.get(key))+"\n");
	        }
			long endTime = System.currentTimeMillis();
			
			area.append("Time taken for searching is " + (endTime - startTime)/1000d + "seconds\n");
			
		}
		else if(buttonPressed.equals("Get URL"))
		{
			
			OpenURI.showURL("http://www.concordia.ca/"+docIdText.getText());
			
		}
	}
}