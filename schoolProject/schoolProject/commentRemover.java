package schoolProject;
import java.io.BufferedReader;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;

public class commentRemover {
	public static String removeComments() {
		try {
			FileWriter fWriter = new FileWriter(mainClass.writtenFile);
			FileReader fReader = new FileReader(mainClass.mainFile);
			BufferedReader bReader = new BufferedReader(fReader);
			StringBuffer sBuffer = new StringBuffer();
			String line;
			boolean inMLC = false;
			boolean inComment = false;
			while((line=bReader.readLine()) != null) {
				if(line.contains("/*")) { 
					char[] charArray = new char[line.length()];
					line.getChars(0, line.length(), charArray, 0);
					for (int i = 0; i < charArray.length; i++) {
						char c = charArray[i];
						if(c=='"') inComment = !inComment;
						else if(c=='/' && inComment == false) {
							if(i+1 < charArray.length) {
								char c2 = charArray[i + 1];
								if (c2 == '*') {
									line = line.substring(0, i).trim();
									inMLC = true;
									sBuffer.append(line);
									sBuffer.append("\n");
								}
							}
						}
					}
				}
				if(line.contains("*/")) {
					char[] charArray = new char[line.length()];
					line.getChars(0, line.length(), charArray, 0);
					for (int i = 0; i < charArray.length; i++) {
						char c = charArray[i];
						if(c=='"') inComment = !inComment;
						else if(c=='*' && inComment == false) {
							if(i+1 < charArray.length) {
								char c2 = charArray[i + 1];
								if (c2 == '/') {
									String cutLine = line.substring(0, i + 1).trim();
									if (line.length() != cutLine.length()) {
										line = line.substring(i + 2, line.length()).trim();
										inMLC = false;
							        }
								}
							}
						}
					}
				}
				if(inMLC == false) {
					char[] charArray = new char[line.length()];
					line.getChars(0, line.length(), charArray, 0);
					for (int i = 0; i < charArray.length; i++) {
						char c = charArray[i];
						if(c=='"') inComment = !inComment;
						else if(c=='/' && inComment == false) {
							if(i+1 < charArray.length) {
								char c2 = charArray[i + 1];
								if (c2 == '/') {
									line = line.substring(0, i).trim();
								}
							}
						}
					}
					sBuffer.append(line);
					sBuffer.append("\n");
				}
			}
			fReader.close();
			fWriter.write("File Contains:\n");
			fWriter.write(sBuffer.toString());
			fWriter.close();
		}
		catch(IOException e){ e.printStackTrace(); }
		return new String();
	}
}
