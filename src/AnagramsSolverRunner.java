import java.util.LinkedHashSet;
import java.util.Set;
import java.util.TreeSet;
import java.util.Scanner;

public class AnagramsSolverRunner {
	static MateusAnagramDictionaryFilter temp= new MateusAnagramDictionaryFilter();
	Set<String> everyPossibleWordInDictionary= temp.setOfWords;
	Set<String> possibleWordsFromUserLetters= new LinkedHashSet<>();
	Set<String> realSet= new TreeSet<>();
	
	public AnagramsSolverRunner(String userLetters) {
		PossibleInputedWords test= new PossibleInputedWords(userLetters);
		possibleWordsFromUserLetters = test.setOfPossibleABCOrderWords;
		for(String s: everyPossibleWordInDictionary) {
			String sABC = arrangeInAlphebeticalOrder(s);
			for(String ss: possibleWordsFromUserLetters) {
				if(sABC.equals(ss)) {
					realSet.add(s);
					break;
				}
			}
		}
		
	}
	
 	public static String arrangeInAlphebeticalOrder(String str) {
		String returnString="";
		for(int i=0;i<str.length();i++) {
			String currentLetter = str.substring(i,i+1);
			if(returnString.length()==0) {//this puts the first letter automatically in the returnString
				returnString= currentLetter;
			} else {//this compares letters from
				boolean processed=false;
				for(int j=0;j<returnString.length();j++) {
					String temp= returnString.substring(j,j+1);
					if(currentLetter.compareTo(temp)<=0) {
						returnString= returnString.substring(0,j)+currentLetter+returnString.substring(j,returnString.length());
						processed=true;
						break;
					}
				}
				if(!processed) {
					returnString= returnString + currentLetter;
				}
			}
		}
		return returnString;
	}
	
	
	
	
	public static void main(String[] args) {
		System.out.println("hello world");
		Scanner scanner= new Scanner(System.in);
		System.out.print("Please enter a string of letters containing 1 through 9 letters: ");
		String temp= scanner.next();
		AnagramsSolverRunner test= new AnagramsSolverRunner(temp);
		int i=0;
		for(String s: test.realSet ) {
			System.out.println(s);
			i++;
		}
		System.out.println(i);
		scanner.close();
	}

}
