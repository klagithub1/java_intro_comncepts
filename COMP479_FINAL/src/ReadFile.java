import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;

public class ReadFile {

	public static String readFile(String fileName)
	{
								
		String content = null;
		FileInputStream fin = null;
		int length;
		byte buf[] = null;
		
		try 
		{
			
			length = (int)(new File(fileName).length());
			fin = new FileInputStream(fileName);
			buf = new byte[length];
			fin.read(buf);
			fin.close();
			
			// Assign file contents to a string variable
			content = new String(buf);
			
		} 
		catch (IOException e) 
		{
			System.err.println(e);
		}
		
		content = content.replaceAll("<.*?>","");
		content = content.replaceAll("<script>.*</script>","");
		return content;
		
	}
	
	public static int getFileSize(String fileName)
	{
		String fileLocation =fileName;
		int length = (int)(new File(fileLocation).length());
		return length;
	}
}
