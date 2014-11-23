
import java.io.File;
import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.InputStreamReader;
import java.io.Reader;
import java.io.StreamTokenizer;
import java.util.Vector;
import si.Stateinfo;

public class Tree extends CommandBase
implements CommandLine.ICommand {

	protected String dirpath, dots;
	protected char slash = '/';

	
	public void takeAction(){

		String curdir = sone.getCurdir();
		System.out.println( curdir );
		this.dots = "";
		this.dirpath = curdir;
		this.listfiles( this.dirpath );
		
	}
	
	public void listfiles(String curdir){
		
		String curFile;
		int slashcount;
        
	    File f = new File(curdir);
	    File[] listfiles = f.listFiles();
	    for (int i = 0; i < listfiles.length; i++) {
	        if (listfiles[i].isDirectory()) {
	            File[] internalFile = listfiles[i].listFiles();
	            for (int j = 0; j < internalFile.length; j++) {
	            	curFile = String.valueOf( internalFile[j] );
	            	curFile = curFile.replace(curdir, "");
	            	slashcount = this.countOccurrences( curFile , slash );
	            	System.out.println( "--" + ANSI_BLUE + curFile + ANSI_RESET + "    "  + listfiles[i].length() );
	                
	            	if (internalFile[j].isDirectory()) {
	            		String name = internalFile[j].getAbsolutePath();
	                    listfiles(name);
	                }
	            }
	        }else{
            	curFile = String.valueOf( listfiles[i] );
            	curFile = curFile.replace(curdir, "");
            	slashcount = this.countOccurrences( curFile , slash );
	            System.out.println( ANSI_PURPLE + curFile  + ANSI_RESET  + "    " + listfiles[i].length()  );
	        }
	    }
	}
	
	
	
	
    
    public int countOccurrences(String haystack, char needle){
        return countOccurrences(haystack, needle, 0);
    }

    private int countOccurrences(String haystack, char needle, int index){
        if (index >= haystack.length()){
            return 0;
        }

        int contribution = haystack.charAt(index) == needle ? 1 : 0;
        return contribution + countOccurrences(haystack, needle, index+1);
    }	
	
	
}
