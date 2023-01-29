package schoolProject;
import java.io.File;

public class mainClass {
	//Path of the main file you will be using to remove comments/ identify loop, methods and constructs
	public static File mainFile = new File("C:\\Users\\Haluk\\eclipse-workspace\\myProject\\myProject\\exampleFile.java");
	//Path of the file which will be the output as the result of our code
	public static File writtenFile = new File("C:\\Users\\Haluk\\eclipse-workspace\\myProject\\myProject\\outputFile.txt");
	
	public static void main(String[] args) {
		//Removing comments and writing onto the file you will be using as output file
		commentRemover.removeComments();
		//Printing the loops and methods to the console
		System.out.println(identifyLoopsMethods.identifyMethods());
		//Printing the constructs to the console
		System.out.println(identifyConstructs.identifyTheConstructs());
	}
}
