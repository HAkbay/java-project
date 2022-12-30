package schoolProject;
import java.io.File;

public class mainClass {
	public static File mainFile = new File("C:\\Users\\Haluk\\eclipse-workspace\\schoolProject\\schoolProject\\identifyLoopsMethods.java"); //i used identify loops java file as input
	public static File writtenFile = new File("C:\\Users\\Haluk\\eclipse-workspace\\schoolProject\\schoolProject\\writtenfile.txt"); //writtenfile.txt is included in schoolProject file
	
	public static void main(String[] args) {
		commentRemover.removeComments();
		System.out.println(identifyLoopsMethods.identifyMethods());
		System.out.println(identifyConstructs.identifyTheConstructs());
	}
}
