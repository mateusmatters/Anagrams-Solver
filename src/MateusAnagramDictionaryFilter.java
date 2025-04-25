import java.io.BufferedReader;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.TreeSet;
import java.util.Set;

public class MateusAnagramDictionaryFilter {
	static File fileName = new File("Mateus' Anagrams Dictionary");
	int wrdCnt =0;
	Set<String> setOfWords;
	public MateusAnagramDictionaryFilter() throws IOException {
		setOfWords= new TreeSet<>();
		try(BufferedReader reader = new BufferedReader(new FileReader(fileName))) {
			String line;
			while((line = reader.readLine()) != null) {
				String temp= line;
				if(setOfWords.add(temp)) {//I have it like this case of duplicates (Ability and -ability)
					wrdCnt++;
				}
			}
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		}
	}
	
	// public static void main(String[] args) throws IOException {
	// 	MateusAnagramDictionaryFilter test= new MateusAnagramDictionaryFilter();
	// 	for(String s: test.setOfWords) {
	// 		System.out.println(s);
	// 	}
	// 	System.out.println("Word Count: " + test.wrdCnt);
	// }
}
