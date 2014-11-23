
PREAMBLE

This discussion concerns the problem no. 3  found at the following location:

https://docs.google.com/file/d/0B_voeTppgIM2SFpFaFptRmVKOWc/edit

An approximate transaltion of the question text is as follows:

"Build a simle file system as a console application according to the following specification.

Each display instance should show file name and size.

If the instance is a directory, show the directory name, and all subdirectories and files.

Calculate the total size of the inspected directory structure.

You should be able to issue the (print) command on a certain subdirectory.

The output should resemble (fig. 1)

It is not necessary to create files or directories."

(NOTE.  The question states "file system".  This has been understood to mean File System Manager, since the development of even the simplest (CP/M) type filesystem is somewhat beyond the scope of this assignment, and is not suited to the Java programming language (this would require a JVM for the hypothetical filesystem, which would require 10-20 years of development.)  Therefore, the underlying file system will be used.  The application has been tested on ext2 under Debian GNU/Linux, FAT32 under DR-DOS 7 and NTFS32 under Windows XP.

ii. Discussion of the implmentation.

The implementation of command interpreters is well-understood in C, and usually takes place as follows:

	*an endless loop fo the { for(;;) } variety containing...
	*a switch statement to pick out acceptable commands...
	*one of which must be a break-type statement to end the program.
	*a means of getting keyboard interrups to capture the commands.

The Java PL model disparages hardware access, and discourages monolithic program structures; rather, Java enforces 'one class per task' application archtechture, and provides abstractions for obtaining keyboard inputs.

The overarching concept used here is therefore:

	*a single class to capture commends, and invoke a class
	 to implement each one.
	*a group of classes which may be in ignorance of the mechanism 
         which is invoking them.

This can be found in the classes Cmd.java and Commandline.java.  The latter is implemented by some other concrete class and performs generic functions unconcerned with this actual problem.  The former can clearly be seen to route acceptable commands to certain classes.

Each class must implement a doIt method which in turn calls a takeAction method; the doIt method is abstracted into the CommandBase class, which performs other tasks common to all the implementation classes. 

The OO nature of this design requires the solving of a subtle problem: how to preserve and pass around state data (specifically, the Current Working Directory) between classes which are purposefully encapsulated (in this case meaning 'having nothing to do with one another'.  Java does not have PHP-type constructs such as Superglobals, and in any case, globals are disparaged in modern software engineering practice.

For this problem, we turn to Johnson et al and the Singleton class. This is found in its own package (si), and implements a get() and set() method to store and retrieve the current working directory.  This solves the problem of being able to store persistent but mutable data.  This class is placed in its own package due to a little understood behaviour wherein Java can create multiple instances of a Singleton class if it resides in the same packages as two different classes which invoke it.

iii. Layout and compilation of the program.

This project is laid out as follows:

-------sw------	Chdir.java
	|	Cmd.java		(the 'main' part of the application.)
	|	CommandBase.java
	|	CommandLine.java
	|	Curdir.java
	|	Listall.java
	|	Tree.java
	|
	si-----	Stateinfo.java

-------docs-----readme.txt (this document)

All classes may be compiled by issuing the
	javac *.java 
command.  In the first case, this is not necessary since the class files are distributed with the source files.

The program should be run as follows:

	java Cmd



iv. Operation of the Program

The following commands are implemented:

listall		list all file and directories in the current directory.

tree		lists a directory tree descending from the current
		directory.

curdir		shows the current directory

chdir <dirname>	changes the current directory. If dirname=retreat,
		(command is chdir retreat) 
		changes the current directory to the parent directory.

q		quit the application.

When the program is run, the current directory is set to that in which Cmd.class is located.  The chdir retreat option will 'reverse' back up the directory hierachy, to / if necessary.

v. Critique and Future Improvements.

The implemenations of many principles are highly conservative and chosen for ease of understanding more than optimal performance.  In particular, the implementation of the Singleton class is not thread safe.  Futhermore, modern software engineering practice has become critical of the use of Singletons per se, and some mother-hen debuggers will issue a warning if one is detected.  As one would expect, no adeqaute replacement has been identified, so the method of persisting state data which was apparently good enough for MIT CS 305 in 1990 has been used here.

Java has many types of list and list comprehensions.  The generic LinkedList<> type may be better fit for this problem, but the File type is simple and readily understood, so (whilst understanding its limitations) it has been used here.

Given time, more internal validation is required.  For instance, it is possible to 'change to' a nonexistant directory, which will then cause a NullPointer exception if the listall command is executed on it.

Given time, some use should be made of an ncurses-type library to draw a more descriptive 'tree' diagram of diretory and subdirectory and file structure.





