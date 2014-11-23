
import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.InputStreamReader;
import java.io.Reader;
import java.io.StreamTokenizer;
import java.util.Vector;

import si.Stateinfo;

public class Chdir  extends CommandBase
implements CommandLine.ICommand {

	private Stateinfo sone = null, stwo = null;
	
	public boolean doIt(Vector v) {
		
		boolean r;
		r = new String("retreat").equals(v.get(1));

		sone = Stateinfo.getInstance();
		String curdir = sone.getCurdir();
		
		if ( r == true ){
			int lastslash = curdir.lastIndexOf("/");
			curdir = curdir.substring(0, lastslash);
			sone.setCurdir( curdir );
		}else{	
			curdir = curdir + "/" + v.elementAt(1);
			sone.setCurdir( curdir );
			System.out.println( curdir );
		}		
		return true;
	}
}
