
import java.io.File;
import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.InputStreamReader;
import java.io.Reader;
import java.io.StreamTokenizer;
import java.util.Vector;
import si.Stateinfo;

public class Listall extends CommandBase
implements CommandLine.ICommand {

	

	
	public void takeAction(){

		String curdir = sone.getCurdir();
		System.out.println( curdir );
		
		this.listfiles(curdir);
		
	}
	
	public void listfiles(String curdir){

		File folder = new File(curdir);
		File[] listOfFiles = folder.listFiles();

		    for (int i = 0; i < listOfFiles.length; i++) {
		      if (listOfFiles[i].isFile()) {
		        System.out.println(ANSI_BLUE +  listOfFiles[i].getName() + ANSI_RESET   + "    " + listOfFiles[i].length());
		      } else if (listOfFiles[i].isDirectory()) {
		        System.out.println(ANSI_YELLOW +   listOfFiles[i].getName() + ANSI_RESET);
		      }
		    }		
		
	}
}
