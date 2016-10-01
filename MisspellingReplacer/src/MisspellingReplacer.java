/**
 * @author Zhen Xu
 * 
 * This is a helper class for MisspellingReplacerClient, which reads through
 * each line of your input file and replace the misspelling word you named with
 * the right word you want.
 */
import java.io.*;
import java.util.*;

public class MisspellingReplacer {

	private List<String> misspellingList;	// The lines of input file
	
	/**
	 * Constructor, construct your input file into lines.
	 * @param misspellingList
	 */
	public MisspellingReplacer(List<String> misspellingLines) {
		misspellingList = misspellingLines;
	}

	/**
	 * This method replace the misspelling in each line, and output a file
	 * @param misspelling the misspelling word that needs to be replaced
	 * @param spelling the right spelling that replaces the wrong spelling
	 */
	public void replacing(String misspelling, String spelling) throws IOException {
		PrintWriter writer = new PrintWriter("file.txt", "UTF-8");
		for(int i = 0; i < misspellingList.size(); i++) {			
			String str = replacing(misspelling, misspellingList.get(i), spelling);
			// for debug
			// System.out.println(str);
			writer.println(str);
		}
		writer.close();
	}

	/**
	 * This method replaces misspelling with correct spelling in each line
	 * @param misspelling the misspelling that needs to be replaced
	 * @param spelling the correct the spelling that is to be replaced with
	 */
	private String replacing(String misspelling, String text, String spelling) {
		List<Integer> matchingIndices = stringMatching(misspelling, text); 
		StringBuilder sb = new StringBuilder();
		sb.append(text.substring(0, matchingIndices.get(0)));
		for(int index = 0; index < matchingIndices.size(); index++) {
			sb.append(spelling);
			if(index + 1 == matchingIndices.size()) {
				if(text.substring(matchingIndices.get(index) + misspelling.length(), text.length()).length() == 0) {
					break;
				} else {
					sb.append(text.substring(matchingIndices.get(index) + misspelling.length(), text.length() - 1));					
				}
			} else {
				sb.append(text.substring(matchingIndices.get(index) + misspelling.length(), matchingIndices.get(index + 1)));
			}
		}
		return sb.toString();
	}

	/**
	 * This method use KMP algorithm to find out the starting index of matching
	 * @param misspelling the string that you want to find match for
	 * @param misspellingText a line of text that you want to find match
	 * @return the starting index of matching
	 */
	private List<Integer> stringMatching(String misspelling, String misspellingText) {
		List<Integer> output =  new ArrayList<Integer>();
		int f[] = failFunc(misspelling);
		int i = 0;
		int k = 0;
		while(k < misspellingText.length()) {
			int j = 0;   
			while(i < misspellingText.length() && j < misspelling.length()) {
				if(misspellingText.charAt(i) == misspelling.charAt(j)) {
					i++;
					j++;
				} else {
					if(j != 0) {
						j = f[j - 1];
					} else {
						i++;
					}
				}

			}
			if(j == misspelling.length()) {
				output.add(i - j);				
			}
			k = i;   
		}		
		return output;
	}

	/**
	 * This is a helper function to indicate the most convenient shift for KMP algorithm
	 * @param misspelling the misspelling word that you want to replace
	 * @return an set of number indicating the most convenient shift
	 */
	private int[] failFunc(String misspelling) {
		int fail[] = new int[misspelling.length()];
		int index = 0;
		for(int i = 1; i < misspelling.length();) {
			if(misspelling.charAt(i) == misspelling.charAt(index)) {
				fail[i] = index + 1;
				index++;
				i++; 
			} else {
				if(index != 0) {
					index = fail[index - 1];
				} else {
					fail[i] = 0;
					i++;
				}
			}  
		}
		for(int i = 0; i < fail.length; i++) {
			System.out.print(fail[i]);
		}
		return fail;
	}

}

