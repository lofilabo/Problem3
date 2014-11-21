
import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.InputStreamReader;
import java.io.Reader;
import java.io.StreamTokenizer;
import java.util.Vector;

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
public class Listall 
implements CommandLine.ICommand {

	/**
	 * This method is invoked when the FOO command is
	 * used.
	 */
	public boolean doIt(Vector v) {
		System.out.println(
			"Inside CommandLineTest.doIt(); v=" 
			+ v
		);
		return true;
	}
}
