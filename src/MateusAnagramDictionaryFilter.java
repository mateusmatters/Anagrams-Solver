import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;
import java.util.TreeSet;
import java.util.Set;

public class MateusAnagramDictionaryFilter {
	static File fileName = new File("Mateus' Anagrams Dictionary");
	Scanner scan = null;
	int wrdCnt =0;
	Set<String> setOfWords;
	public MateusAnagramDictionaryFilter() {
		setOfWords= new TreeSet<>();
		try {
			scan = new Scanner(fileName);
			while(scan.hasNextLine()) {
				String temp= scan.nextLine();
				if(setOfWords.add(temp)) {//I have it like this case of duplicates (Ability and -ability)
					wrdCnt++;
				}
		     	
			}
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		}

	}
	
	public static void main(String[] args) {
		MateusAnagramDictionaryFilter test= new MateusAnagramDictionaryFilter();
		int i=0;
		for(String s: test.setOfWords) {
			System.out.println(s);
			i++;
		}
		System.out.println("Word Count: " + test.wrdCnt);
		System.out.println(i);
	}
}
