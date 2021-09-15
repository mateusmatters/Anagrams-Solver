import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;
import java.util.TreeSet;
import java.util.Set;

//This class filters all the words in the Oxford English Dictionary so that they are all viable words for the game
//Anagrams
public class OxfordDictionaryFilter {
	static File fileName = new File("Oxford English Dictionary");
	Scanner scan = null;
	int wrdCnt =0;
	Set<String> setOfWords;
	public OxfordDictionaryFilter() {
		setOfWords= new TreeSet<>();
		try {
			scan = new Scanner(fileName);
			while(scan.hasNextLine()) {
				String temp= scan.nextLine();
				if(!temp.isBlank() && temp.subSequence(0, 1).equals(" ")==false) {
					int endIndex= temp.indexOf(" ");
					temp= temp.substring(0, endIndex);
					if(temp.contains("-")) {
						int index= temp.indexOf("-");
						temp= temp.substring(0,index) + temp.substring(index+1, temp.length());
					}
					if(temp.contains("/")) {
						int index= temp.indexOf("/");
						temp= temp.substring(0,index) + temp.substring(index+1, temp.length());
					}
					if(temp.contains("'")) {
						int index= temp.indexOf("'");
						temp= temp.substring(0,index) + temp.substring(index+1, temp.length());
					}
					if(temp.contains(".")) {
						int index= temp.indexOf(".");
						temp= temp.substring(0,index) + temp.substring(index+1, temp.length());
					}
					if(temp.contains(".")) {
						int index= temp.indexOf(".");
						temp= temp.substring(0,index) + temp.substring(index+1, temp.length());
					}
					if(temp.contains("1")) {
						temp= temp.substring(0,temp.length()-1);
					}
					if(temp.length()>7 || temp.contains("2") || temp.contains("3") 
					|| temp.contains("4") || temp.contains("5") || temp.length()<3
					|| temp.equals("Usage")) {
						continue;
					}
					if(temp.substring(0, 1).equals("A")||
					temp.substring(0, 1).equals("B")||
					temp.substring(0, 1).equals("C")||
					temp.substring(0, 1).equals("D")||
					temp.substring(0, 1).equals("E")||
					temp.substring(0, 1).equals("É")||
					temp.substring(0, 1).equals("F")||
					temp.substring(0, 1).equals("G")||
					temp.substring(0, 1).equals("H")||
					temp.substring(0, 1).equals("I")||
					temp.substring(0, 1).equals("J")||
					temp.substring(0, 1).equals("K")||
					temp.substring(0, 1).equals("L")||
					temp.substring(0, 1).equals("M")||
					temp.substring(0, 1).equals("N")||
					temp.substring(0, 1).equals("O")||
					temp.substring(0, 1).equals("P")||
					temp.substring(0, 1).equals("Q")||
					temp.substring(0, 1).equals("R")||
					temp.substring(0, 1).equals("S")||
					temp.substring(0, 1).equals("T")||
					temp.substring(0, 1).equals("U")||
					temp.substring(0, 1).equals("V")||
					temp.substring(0, 1).equals("W")||
					temp.substring(0, 1).equals("X")||
					temp.substring(0, 1).equals("Y")||
					temp.substring(0, 1).contentEquals("Z")) {
						temp= OxfordDictionaryFilter.lowerCaseToUpperCase(temp);
					}
					if(setOfWords.add(temp)) {//I have it like this case of duplicates (Ability and -ability)
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
		String firstLetter = str.substring(0, 1);
		switch(firstLetter) {
		case "A":
			return "a" + str.substring(1);
		case "B":
			return "b" + str.substring(1);
		case "C":
			return "c" + str.substring(1);
		case "D":
			return "d" + str.substring(1);
		case "E":
		case "É":
			return "e" + str.substring(1);
		case "F":
			return "f" + str.substring(1);
		case "G":
			return "g" + str.substring(1);
		case "H":
			return "h" + str.substring(1);
		case "I":
			return "i" + str.substring(1);
		case "J":
			return "j" + str.substring(1);
		case "K":
			return "k" + str.substring(1);
		case "L":
			return "l" + str.substring(1);
		case "M":
			return "m" + str.substring(1);
		case "N":
			return "n" + str.substring(1);
		case "O":
			return "o" + str.substring(1);
		case "P":
			return "p" + str.substring(1);
		case "Q":
			return "q" + str.substring(1);
		case "R":
			return "r" + str.substring(1);
		case "S":
			return "s" + str.substring(1);
		case "T":
			return "t" + str.substring(1);
		case "U":
			return "u" + str.substring(1);
		case "V":
			return "v" + str.substring(1);
		case "W":
			return "w" + str.substring(1);
		case "X":
			return "x" + str.substring(1);
		case "Y":
			return "y" + str.substring(1);
		case "Z":
			return "z" + str.substring(1);
		default:
			return null;
		}
		
	}
		
	
	
	public static void main(String[] args) {
		OxfordDictionaryFilter test= new OxfordDictionaryFilter();
		int i=0;
		for(String s: test.setOfWords) {
			System.out.println(s);
			i++;
		}
		System.out.println("Word Count: " + test.wrdCnt);
		System.out.println(i);
	}

}
