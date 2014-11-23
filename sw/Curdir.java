
import java.io.File;
import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.InputStreamReader;
import java.io.Reader;
import java.io.StreamTokenizer;
import java.util.Vector;
import si.Stateinfo;

public class Curdir extends CommandBase
implements CommandLine.ICommand {

	

	
	public void takeAction(){

		String curdir = sone.getCurdir();
		System.out.println( curdir );
		
	}
	

}
