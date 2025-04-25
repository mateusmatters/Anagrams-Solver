import java.io.BufferedReader;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.Scanner;
import java.util.TreeSet;
import java.util.Set;

//This class filters all the words in the Oxford English Dictionary so that they are all viable words for the game
//Anagrams
public class OxfordDictionaryFilter {
	static File fileName = new File("Oxford English Dictionary");
	int wrdCnt =0;
	Set<String> setOfWords;
	public OxfordDictionaryFilter() throws IOException {
		setOfWords= new TreeSet<>();
		try(BufferedReader reader = new BufferedReader(new FileReader(fileName))) {
			String line;
			while((line = reader.readLine()) != null) {
				if(!line.isBlank() && line.subSequence(0, 1).equals(" ")==false) {
					int endIndex= line.indexOf(" ");
					line= line.substring(0, endIndex);
					if(line.contains("-")) {
						int index= line.indexOf("-");
						line= line.substring(0,index) + line.substring(index+1, line.length());
					}
					if(line.contains("/")) {
						int index= line.indexOf("/");
						line= line.substring(0,index) + line.substring(index+1, line.length());
					}
					if(line.contains("'")) {
						int index= line.indexOf("'");
						line= line.substring(0,index) + line.substring(index+1, line.length());
					}
					if(line.contains(".")) {
						int index= line.indexOf(".");
						line= line.substring(0,index) + line.substring(index+1, line.length());
					}
					if(line.contains(".")) {
						int index= line.indexOf(".");
						line= line.substring(0,index) + line.substring(index+1, line.length());
					}
					if(line.contains("1")) {
						line= line.substring(0,line.length()-1);
					}
					if(line.length()>7 || line.contains("2") || line.contains("3") 
					|| line.contains("4") || line.contains("5") || line.length()<3
					|| line.equals("Usage")) {
						continue;
					}
					char firstChar = line.charAt(0);
					if (firstChar >= 'A' && firstChar <= 'Z') {
						line = OxfordDictionaryFilter.lowerCaseToUpperCase(line);
					}
					if(setOfWords.add(line)) {//Incase of duplicates, add it through a set
						wrdCnt++;
					}
		     	}
			}
			setOfWords.add("usage");
			wrdCnt++;
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		}

	}
	
	public static String lowerCaseToUpperCase(String str) {
		if (str == null || str.isEmpty()) {
			return null;
		}
		char firstChar = str.charAt(0);
		if (firstChar >= 'A' && firstChar <= 'Z') {
			char lowerChar = (char) (firstChar + 32);
			return lowerChar + str.substring(1);
		}
		return null;
	}
	
	public static void main(String[] args) throws IOException {
		OxfordDictionaryFilter test= new OxfordDictionaryFilter();
		int i=0;
		for(String s: test.setOfWords) {
			System.out.println(s);
			i++;
		}
		System.out.println("Word Count: " + test.wrdCnt);
	}

}
