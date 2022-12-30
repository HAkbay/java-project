package schoolProject;
import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.LinkedHashSet;
import java.util.Set;

public class identifyConstructs {
	private static Set<String> savedConstructs = new LinkedHashSet<>();
	private static String constructArray[] = {"import java.io.BufferedReader","import java.io.FileReader","package","public","private","try","catch","String","int","boolean","if","else"};
	
	public static String identifyTheConstructs() {
		try {
			FileReader fReader = new FileReader(mainClass.mainFile);
			BufferedReader bReader = new BufferedReader(fReader);
			StringBuffer sBuffer = new StringBuffer();
			String line;
			while((line=bReader.readLine()) != null) {
				sBuffer.append(line);
				sBuffer.append("\n");
				for(int i = 0; i<constructArray.length; i++) {
					if(line.contains(constructArray[i])) {
						savedConstructs.add(constructArray[i]);
					}
				}
			}
			fReader.close();
			System.out.println("\nSaved Construct Array:");
			for(String s : savedConstructs) {
				System.out.println(s);
			}
		}
		catch(IOException e){ e.printStackTrace(); }
		return new String();
	}
}
