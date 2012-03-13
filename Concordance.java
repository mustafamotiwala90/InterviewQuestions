package textProcessor;

import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.HashMap;
import java.util.Hashtable;
import java.util.LinkedList;
import java.util.Map;
import java.util.Queue;
import java.util.Scanner;
import java.util.TreeMap;

/*
 * Given an arbitrary text document written in English, write a program that will generate a concordance, 
 * i.e. an alphabetical list of all word occurrences, labeled with word frequencies. Bonus: label each 
 * word with the sentence numbers in which each occurrence appeared. 
 */

/**
 * This class gives and object that takes in fileName, processes the file instantly and creates a counter.
 * These counts can then be displayed on console or on String as per requirement of the class user. 
 * 
 * @author Rishi Baldawa
 * 
 * 
 */
public class Concordance {
	/**
	 * NOTES:
	 * 
	 * 1)sentenceCount can also be implemented as {@link Map} [String,
	 * StringBuilder] however will cause loss of scalability, adaptability and
	 * flexibility.
	 * 
	 * 2)SentenceCounter need not be global but any future implementation
	 * Involving multi-threading requires a synchronized primitive
	 * 
	 * 3)For multi-threaded environments, make sure to use {@link Hashtable}
	 * isntead of {@link HashMap}s and static primitives
	 * 
	 * 4)Mapper can be removed and called explicity by object creator but not
	 * needed over here
	 */
	int SentenceCounter;
	Map<String, Integer> wordCounter;
	Map<String, LinkedList<Integer>> sentenceCount;
	boolean charSensitive;
	boolean removeSplChars;

	/**
	 * default constructor. reads from input file and maps every word into
	 * counters. words are case-insensitive and any special character is removed
	 * from each edge of words
	 * 
	 * @param fileName
	 *            name of the inputFile
	 */
	public Concordance(String fileName) {

		/*
		 * Init
		 */
		this.SentenceCounter = 1;
		wordCounter = new TreeMap<String, Integer>();
		sentenceCount = new HashMap<String, LinkedList<Integer>>();
		this.charSensitive = false;
		this.removeSplChars = true;

		/*
		 * take all inputs first. This will speed up i/o processing but cost
		 * memory space
		 */
		Queue<String> WordList = new LinkedList<String>();

		FileReader f = null;
		try {
			f = new FileReader(fileName);
			Scanner src = new Scanner(f);
			while (src.hasNext()) {
				WordList.add(src.next());
			}
		} catch (FileNotFoundException e) {
			System.err.println(e.toString());
			System.exit(-1);
		} finally {
			try {
				f.close();
			} catch (IOException e) {
				System.err.println(e.toString());
				System.exit(-2);
			}
		}

		/*
		 * Input over. Now starting processing each word
		 */
		while (!WordList.isEmpty()) {
			Mapper(WordList.remove());
		}
	}
	
	/**
	 * FOR SHOW ONLY
	 * 
	 * default constructor for multiple files reads from input file and maps every word into
	 * counters. words are case-insensitive and any special character is removed
	 * from each edge of words.
	 * TODO multi-thread this constructor
	 * 
	 * @param fileName
	 *            name of the inputFile
	 */
	public Concordance(String... files) {

		/*
		 * Init
		 */
		this.SentenceCounter = 1;
		wordCounter = new TreeMap<String, Integer>();
		sentenceCount = new HashMap<String, LinkedList<Integer>>();
		this.charSensitive = false;
		this.removeSplChars = true;
		for(String fileName : files){
			/*
			 * take all inputs first. This will speed up i/o processing but cost
			 * memory space
			 */
			Queue<String> WordList = new LinkedList<String>();
	
			FileReader f = null;
			try {
				f = new FileReader(fileName);
				Scanner src = new Scanner(f);
				while (src.hasNext()) {
					WordList.add(src.next());
				}
			} catch (FileNotFoundException e) {
				System.err.println(e.toString());
				System.exit(-1);
			} finally {
				try {
					f.close();
				} catch (IOException e) {
					System.err.println(e.toString());
					System.exit(-2);
				}
			}
	
			/*
			 * Input over. Now starting processing each word
			 */
			while (!WordList.isEmpty()) {
				Mapper(WordList.remove());
			}
		}
	}
	
	/**
	 * more flexible constructor in which we can define if Concordance needs to
	 * remove special characters or be case-insensitive
	 * 
	 * @param fileName
	 *            name of the file
	 * @param charSensitive
	 *            if we need to be case sensitive
	 * @param removeSplChars
	 *            if we should remove any special characters from word edges
	 */
	public Concordance(String fileName,boolean charSensitive, boolean removeSplChars) {

		/*
		 * Init
		 */
		this.SentenceCounter = 1;
		wordCounter = new TreeMap<String, Integer>();
		sentenceCount = new HashMap<String, LinkedList<Integer>>();
		this.charSensitive = charSensitive;
		this.removeSplChars = removeSplChars;

		/*
		 * take all inputs first. This will speed up i/o processing but cost
		 * memory space
		 */
		Queue<String> WordList = new LinkedList<String>();

		FileReader f = null;
		try {
			f = new FileReader(fileName);
			Scanner src = new Scanner(f);
			while (src.hasNext()) {
				WordList.add(src.next());
			}
		} catch (FileNotFoundException e) {
			System.err.println(e.toString());
			System.exit(-1);
		} finally {
			try {
				f.close();
			} catch (IOException e) {
				System.err.println(e.toString());
				System.exit(-2);
			}
		}

		/*
		 * Input over. Now starting processing each word
		 */
		while (!WordList.isEmpty()) {
			Mapper(WordList.remove());
		}
	}

	/**
	 * Takes in a word, processes it according to object preferences and then
	 * puts the word into concorance maps.
	 * 
	 * @param word
	 *            word to be processed and added
	 */
	private void Mapper(String word) {
		
		if(!charSensitive)			word = word.toLowerCase();
		
		if (removeSplChars) {
			// removing punctuation from beginning and end
			word = word.replaceAll("^[`'\",;:\\(\\{\\)\\}\\[\\]\\- ]+", "");
			word = word.replaceAll("[`'\",;:\\(\\{\\)\\}\\[\\]\\- ]+$", "");
		}

		if (word.matches("[\\w]+[?!.]")) {
			// removing these spl characters if said so
			if (removeSplChars) 	word = word.replaceAll("[?!.]+", "");
			putInWordCounter(word);
			putInSentenceCounter(word, SentenceCounter);
			this.SentenceCounter++;
		} else {
			putInWordCounter(word);
			putInSentenceCounter(word, SentenceCounter);
		}
	}

	/**
	 * Add to word count or iniate if the word wasn't there already.
	 * 
	 * @param word
	 *            word to be added into Map
	 */
	private void putInWordCounter(String word) {
		if (wordCounter.containsKey(word)) {
			int i = wordCounter.remove(word);
			wordCounter.put(word, ++i);
		} else {
			wordCounter.put(word, 1);
		}
	}

	/**
	 * Add the sentence counter to list
	 * 
	 * @param word
	 *            word to be added into Map
	 * @param count
	 *            sentence count so far
	 */
	private void putInSentenceCounter(String word, int count) {
		if (sentenceCount.containsKey(word)) {
			LinkedList<Integer> arr = sentenceCount.remove(word);
			arr.add(count);
			sentenceCount.put(word, arr);
		} else {
			LinkedList<Integer> arr = new LinkedList<Integer>();
			arr.add(count);
			sentenceCount.put(word, arr);
		}
	}

	/**
	 * display's sentence numbers for words
	 */
	public void displayWordCounteronConsole() {
		for (String word : wordCounter.keySet()) {
			System.out.println(word + "\t{" + wordCounter.get(word) + "}");
		}
	}

	/**
	 * display's the concordance with sentence numbers of occurrence on console
	 */
	public void displaySentenceCounteronConsole() {
		for (String word : sentenceCount.keySet()) {
			System.out.println(word + "\t{" + sentenceCount.get(word) + "}");
		}
	}

	/**
	 * display's the concordance with sentence numbers of occurrence on console
	 */
	public void displayWordNSentenceonConsole() {
		final String tab = "\t{", colon = ":", coma = ",", endbrace = "}";
		StringBuilder sB;
		for (String word : wordCounter.keySet()) {
			sB = new StringBuilder(word + tab + wordCounter.get(word) + colon);
			boolean isFirst = true;
			for (Integer i : sentenceCount.get(word)) {
				if (isFirst) {
					sB.append(i);
					isFirst = false;
				} else {
					sB.append(coma + i);
				}
			}
			sB.append(endbrace);
			System.out.println(sB.toString());
		}
	}

	/**
	 * @return sentence numbers for words
	 */
	public String displayWordCounteronString() {
		StringBuilder sB = new StringBuilder();
		for (String word : wordCounter.keySet()) {
			sB.append(word + "\t{" + wordCounter.get(word) + "}\n");
		}
		return sB.toString();
	}

	/**
	 * @return sentence numbers for words
	 */
	public String displaySentenceCounteronString() {
		StringBuilder sB = new StringBuilder();
		for (String word : sentenceCount.keySet()) {
			sB.append(word + "\t" + sentenceCount.get(word) + "\n");
		}
		return sB.toString();
	}

	/**
	 * @return concordance with sentence number
	 */
	public String displayWordNSentenceonString() {
		final String tab = "\t{", colon = ":", coma = ",", endbrace = "}\n";
		StringBuilder sB = new StringBuilder();
		;
		for (String word : wordCounter.keySet()) {
			sB.append(word + tab + wordCounter.get(word) + colon);
			boolean isFirst = true;
			for (Integer i : sentenceCount.get(word)) {
				if (isFirst) {
					isFirst = false;
					sB.append(i);
				} else {
					sB.append(coma + i);
				}
			}
			sB.append(endbrace);
		}
		return sB.toString();
	}
	
	/**
	 * Just for testing and running jar file
	 * 
	 * @param args
	 *            list of input files. for multiple files multi-threading is a
	 *            good option. slightly Hadoop-ish
	 */
	public static void main(String args[]) {
		if (args.length < 1)
			System.err.println( "Invalid Argument Exception.\n"
							  + "Enter atleast one text file with proper directory structure");
		for (String fileName : args) {
			Concordance c = new Concordance(fileName);
			c.displayWordNSentenceonConsole();
		}
	}
}
