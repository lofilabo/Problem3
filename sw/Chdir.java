
import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.InputStreamReader;
import java.io.Reader;
import java.io.StreamTokenizer;
import java.util.Vector;
import si.Stateinfo;

public class Chdir 
implements CommandLine.ICommand {

	private Stateinfo sone = null, stwo = null;
	
	public boolean doIt(Vector v) {
		
		sone = Stateinfo.getInstance();
		String curdir = sone.getCurdir();
		curdir = curdir + "/" + v.elementAt(1);
		
		
		
		sone.setCurdir( curdir );
		System.out.println( curdir );
				
		return true;
	}
}
