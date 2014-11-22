
import java.io.File;
import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.InputStreamReader;
import java.io.Reader;
import java.io.StreamTokenizer;
import java.util.Vector;
import si.Stateinfo;

public class Listall 
implements CommandLine.ICommand {

	public static final String ANSI_RESET = "\u001B[0m";
	public static final String ANSI_BLACK = "\u001B[30m";
	public static final String ANSI_RED = "\u001B[31m";
	public static final String ANSI_GREEN = "\u001B[32m";
	public static final String ANSI_YELLOW = "\u001B[33m";
	public static final String ANSI_BLUE = "\u001B[34m";
	public static final String ANSI_PURPLE = "\u001B[35m";
	public static final String ANSI_CYAN = "\u001B[36m";
	public static final String ANSI_WHITE = "\u001B[37m";	
	
	private Stateinfo sone = null, stwo = null;
	
	public boolean doIt(Vector v) {

		sone = Stateinfo.getInstance();
		String curdir = sone.getCurdir();
		System.out.println( curdir );
		
		this.listfiles(curdir);
		
		return true;
	}
	
	public void listfiles(String curdir){

		File folder = new File(curdir);
		File[] listOfFiles = folder.listFiles();

		    for (int i = 0; i < listOfFiles.length; i++) {
		      if (listOfFiles[i].isFile()) {
		        System.out.println(ANSI_BLUE +  listOfFiles[i].getName() + ANSI_RESET);
		      } else if (listOfFiles[i].isDirectory()) {
		        System.out.println(ANSI_YELLOW +   listOfFiles[i].getName() + ANSI_RESET);
		      }
		    }		
		
	}
}
