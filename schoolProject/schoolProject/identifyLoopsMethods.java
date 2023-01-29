package schoolProject;
import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;

public class identifyLoopsMethods {
	private static String savedParanthesis[] = new String[200];
	private static String savedParanthesisOutput[] = new String[200];
	
	private static String loopArray[] = {"for","while"};
	private static String methodListArray[] = {"public void","public int","public String","private void","private String","private int","public static void","public static int","public static String","private static void","private static String","private static int","protected static void","protected static String","protected static int","protected void","protected int","protected String"};
	
	public static String identifyMethods() {
		try {
			FileReader fReader = new FileReader(mainClass.mainFile);
			BufferedReader bReader = new BufferedReader(fReader);
			String line;
			int whichLine = 0;
			int paranthesisCount = 100;
			int arrIndex = 0;
			boolean inComment = false;
			while((line = bReader.readLine()) != null) {
				whichLine++;
				for(int i = 0; i<loopArray.length; i++) {
					if(line.contains(loopArray[i])) {
						savedParanthesis[paranthesisCount] = "Found " + loopArray[i] + " loop on line " + whichLine;
					}
				}
				for(int i=0;i<methodListArray.length;i++) {
					if(line.contains(methodListArray[i])) {
						savedParanthesis[paranthesisCount] = "Found " + methodListArray[i] + " method on line " + whichLine;
					}
				}
				if(line.contains("{")) {
					char[] charArray = new char[line.length()];
					line.getChars(0, line.length(), charArray, 0);
					for (int i = 0; i < charArray.length; i++) {
						char c = charArray[i];
						if(c=='"') inComment = !inComment;
						else if(c=='{' && inComment == false) {
							paranthesisCount++;
							savedParanthesis[paranthesisCount] = "";
						}
					}
				}
				if(line.contains("}") && savedParanthesis[paranthesisCount - 1] != "" && savedParanthesis[paranthesisCount -1] != null) {
					char[] charArray = new char[line.length()];
					line.getChars(0, line.length(), charArray, 0);
					for (int i = 0; i < charArray.length; i++) {
						char c = charArray[i];
						if(c=='"') inComment = !inComment;
						else if(c=='}' && inComment == false) {
							savedParanthesisOutput[arrIndex] = savedParanthesis[paranthesisCount - 1] + ", ends at " + whichLine;
							paranthesisCount--;
							savedParanthesis[paranthesisCount] = "";
							arrIndex++;
						}
					}
				}else if(line.contains("}") && savedParanthesis[paranthesisCount - 1] == "") paranthesisCount--;
			}
			fReader.close();
			
			System.out.println("\nSaved Loop Array:");
			for(int i = 0; i<savedParanthesisOutput.length; i++) {
				if(savedParanthesisOutput[i]!=null) System.out.println(savedParanthesisOutput[i]);
			}
		}
		catch(IOException e){ e.printStackTrace(); }
		return new String();
	}
}
