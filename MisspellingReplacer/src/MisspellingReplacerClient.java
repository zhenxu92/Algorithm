/**
 * @author Zhen Xu
 * 
 * This program is for client to run in order to replace all the misspelling word, for example
 * "seperate" with an 'e' as a wrong character, with the right spelling, such as "separate" in
 * this case. Client needs to enter the misspelling, correct spelling and name of the file that
 * needs correction. Assume all the words in the input file is consecutive, meaning there is no
 * word that is separated in two lines by '/n'.
 */


import java.util.*;
import java.io.*;


public class MisspellingReplacerClient {
	/**
	 * This is the main program which reads your input file line by line then,
	 * start to replace your misspelling words.
	 */
	public static void main(String args[]) throws FileNotFoundException, IOException {
		Scanner console = new Scanner(System.in);
		System.out.println("Welcome to the misspelling corrector");
		System.out.println();
		
		// open the input file to be corrected
		System.out.println("What is the name of the file to be corrected?");
		String fileName = console.nextLine();
		Scanner input = new Scanner(new File(fileName));
		
		// read the misspelling file and construct a misspelling replacer
		List<String> misspellingList = new ArrayList<String>();
		while (input.hasNextLine()) {
			String next = input.nextLine();
			if (next.length() > 0) {
				misspellingList.add(next);
			}
		}
		MisspellingReplacer replacer = 
				new MisspellingReplacer(Collections.unmodifiableList(misspellingList));
		
		replacing(console, replacer);
	}
	
	/**
	 * This method asks you for the misspelling word you want to replace, and the right word.
	 * Then it initiate the process of replacing. The output, corrected file, will be saved in
	 * the directory. This program will quit if you press 'enter'.This program always assume
	 * that your misspelling occurs at least once in your file.
	 * @param console read in your input: misspelling and correct spelling, if it is 
	 * @param replacer take you misspelling word and check if it is in the file, if it is, it will
	 * start replacing.
	 */
	public static void replacing(Scanner console, MisspellingReplacer replacer) throws IOException {
		boolean done = false;
		while (!done) {
			System.out.println();
			System.out.println("What is your misspelling word (return to quit)?");
			String misspelling = console.nextLine();
			if (misspelling.length() == 0) {
				done = true;
			} else {
				System.out.println("What is the correct spelling (return to quit)?");
				String spelling = console.nextLine();
				if (spelling.length() == 0) {
					done = true;
				} else {
					replacer.replacing(misspelling, spelling);
				}
				console.nextLine();
			}
		}
	}
}
