import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

public class PossibleInputedWords {
	Set<String> setOfPossibleABCOrderWords = new HashSet<>();
	
	String sixWordsFromUser[];
	String numEquivalent[];
	public PossibleInputedWords(String str) {//max can be 10 letters
		int length= str.length();
		sixWordsFromUser= new String[length];
		numEquivalent= new String[length];
		String alphaOrder= AnagramsSolverRunner.arrangeInAlphebeticalOrder(str);
		for(int i=0;i<alphaOrder.length();i++) {//this puts the words in the string in abc order for the arrayList alphaOrder
			sixWordsFromUser[i]= alphaOrder.substring(i,i+1);
			numEquivalent[i]= ""+i;
		}
		for(int i=0;i<numEquivalent.length;i++){//Starts at first letter(0), moves on until reaches last letter (sixWordsFromUserMap.size-1)
			String currNum=numEquivalent[i];//gets the num at index i
			setOfPossibleABCOrderWords.add(changeNumsToString(currNum, sixWordsFromUser));//adds the new one letter word as a possibleWord
			ArrayList<String> holdStringsForNextIteration= new ArrayList<>();
			int wordLetterCount=2;
			while(wordLetterCount<=numEquivalent.length-i) {//2 letter, then 3 letter, then 4, etc
					ArrayList<String> temp2= new ArrayList<>();
					Map<Integer,String>temp2Map= new HashMap<>();
					if(wordLetterCount==2) {
						temp2.add(currNum);
						temp2Map.put(i,currNum);
					} else {
						for(int k=0;k<holdStringsForNextIteration.size();k++) {
							temp2.add(holdStringsForNextIteration.get(k));
						}
						holdStringsForNextIteration= new ArrayList<>();
					}
					for(String s: temp2) {//adds words of length wordLetterCount to the set of possible words and then adds those same words to the list of holdStringsForNextIteration
						String lastLetterCurrentString = s.substring(s.length()-1);//the last letter is a (blank)
						int indexOf= 0;
						for(int ii= indexOf;ii<numEquivalent.length;ii++) {
							if (numEquivalent[ii].equals(lastLetterCurrentString)) {
								break;
							}
							indexOf++;
						}
						for(int j=indexOf+1;j<numEquivalent.length;j++) {
							String wordToAdd= s+ numEquivalent[j];
							setOfPossibleABCOrderWords.add(changeNumsToString(wordToAdd, sixWordsFromUser));
							holdStringsForNextIteration.add(wordToAdd);
						}
					}
				wordLetterCount++;
			}
		}
	}
	
	public static String changeNumsToString(String numString, String[] sixWordsFromUser) {
		String returnValue= "";
		for(int i=0;i<numString.length();i++) {
			String subStringTemp= numString.substring(i,i+1);
			int jj = Integer.parseInt(subStringTemp);
			returnValue=returnValue+ sixWordsFromUser[jj];
		}
		return returnValue;
	}
}
