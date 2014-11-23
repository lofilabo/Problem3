
import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.InputStreamReader;
import java.io.Reader;
import java.io.StreamTokenizer;
import java.util.Vector;

import si.Stateinfo;

/**
 * This class shows how the CommandLine class
 * can be used. It initialized a CommandLine object
 * and defines a FOO command. Notice that this class
 * (CommandLineTest) acts as both test harness and
 * command executor. When run, you'll be presented with
 * a command-line prompt. Type 'foo bar baz' and you'll
 * see the output from the doIt() method. Type 'aaa aaa aaa'
 * and you'll see an error message. Command-line parameters
 * with spaces need to be quoted.
 * 
 * @author medined
 * Created on May 20, 2003
 */
public class Cmd 
implements CommandLine.ICommand {

	private Stateinfo sone = null, stwo = null;
	
	/**
	 * Shows how to use the CommandLine class.
	 * @param args The command-line parameters
	 * @throws FileNotFoundException
	 */
	public static void main(String[] args) 
	throws FileNotFoundException {
		
		Cmd commandprocessor = new Cmd();
		commandprocessor.setinit();
		
		// This technique of reading from either 
		// a script file or
		// from the console was 'borrowed' from BeanShell.
		Reader inputSrc = null;
		if ( args.length > 0 ) {
			inputSrc = new BufferedReader(
				new FileReader(args[0])
			);
		} else {
			inputSrc = new InputStreamReader(System.in);
		}

		// initialize the command line object.
		CommandLine jr = new CommandLine();
		jr.setCommandLinePrompt("-> ");
		jr.setCommandLineVersion("CMD 0.1");

		jr.assignClassToCommnd("foo", "Cmd");
		
		jr.assignClassToCommnd("listall", "Listall");
		jr.assignClassToCommnd("chdir", "Chdir");
		jr.assignClassToCommnd("curdir", "Curdir");
		jr.assignClassToCommnd("tree", "Tree");
		
		jr.init();
		
		if ( args.length > 0 ) {
			jr.setIsInteractive(false);
		}

		// parse and execute commands.
		jr.parseStream(new StreamTokenizer(inputSrc));


		
	}

	
	public void setinit(){
		sone = Stateinfo.getInstance();
		sone.setCurdir( System.getProperty("user.dir") );		
		//System.out.println( sone.getCurdir() );
		
	}
	
	
	/**
	 * This method is invoked when the FOO command is
	 * used.
	 */
	public boolean doIt(Vector v) {
		System.out.println(
			"Inside CommandLineTest.doIt(); v=" 
			+ v
		);
		
		sone = Stateinfo.getInstance();
		String curdir = sone.getCurdir();
		System.out.println( curdir );
		return true;
	}
}
