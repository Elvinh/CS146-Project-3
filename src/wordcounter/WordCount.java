package wordcounter;

import java.io.IOException;

/**
 * Elton Vinh and Thien Van
 * CS 146 Data Structures and Algorithms
 * Fall 2015
 * Department of Computer Science
 * San Jose State University
 * 
 * An executable that counts the words in a files and prints out the counts in
 * descending order.
 */
public class WordCount {

	private static int totalCount = 0;
	
    protected static DataCount<String>[] countWords(DataCounter<String> dataStruct, String file) {
        DataCounter<String> counter = dataStruct;

        try {
            FileWordReader reader = new FileWordReader(file);
            String word = reader.nextWord();
            while (word != null) {
                counter.incCount(word);
                word = reader.nextWord();
            }
        } catch (IOException e) {
            System.err.println("Error processing " + file + e);
            System.exit(1);
        }

        DataCount<String>[] counts = counter.getCounts();
        sortByDescendingCount(counts);
        
        // sum up the total words
        for (DataCount<String> c : counts)
        {
        	totalCount += c.count;
        }
        
        return counts;
    }
    
    // only print relevant words
    private static void printFrequency(DataCount<String>[] counts) {
    	
    	System.out.println("Only printing words with frequency < 1% or > 0.01%");
        for (DataCount<String> c : counts)
        {
        	if ((double) c.count/totalCount <= 0.01 && (double) c.count/totalCount >= 0.0001)
        	{
        		System.out.println((double) c.count/totalCount + " \t" + c.count + " \t" + c.data);
        	}
        }
    }
    private static void printUniqueWords(DataCount<String>[] counts) {

    	for (DataCount<String> c : counts)
        {
        	if(c.count >= 1) {
        		System.out.println(c.count + " \t" + c.data);
        	}
        }
    	System.out.println("Unique words: " + counts.length);
    }
    /**
     * TODO Replace this comment with your own.
     * 
     * Sort the count array in descending order of count. If two elements have
     * the same count, they should be in alphabetical order (for Strings, that
     * is. In general, use the compareTo method for the DataCount.data field).
     * 
     * This code uses insertion sort. You should modify it to use a different
     * sorting algorithm. NOTE: the current code assumes the array starts in
     * alphabetical order! You'll need to make your code deal with unsorted
     * arrays.
     * 
     * The generic parameter syntax here is new, but it just defines E as a
     * generic parameter for this method, and constrains E to be Comparable. You
     * shouldn't have to change it.
     * 
     * @param counts array to be sorted.
     */
    private static <E extends Comparable<? super E>> void sortByDescendingCount(
            DataCount<E>[] counts) {
        for (int i = 1; i < counts.length; i++) {
            DataCount<E> x = counts[i];
            int j;
            for (j = i - 1; j >= 0; j--) {
                if (counts[j].count >= x.count) {
                    break;
                }
                counts[j + 1] = counts[j];
            }
            counts[j + 1] = x;
        }
    }

    public static void main(String[] args) {
    	
        if (args.length != 3) {
            System.err.println(" Incorrect number of arguments");
            System.err.println(" Usage: ");
            System.err.println("\tjava WordCount  [ -b | -a | -h ] [ -frequency | -num_unique ] <filename>");
            System.exit(1);
        }
       
        DataCounter<String> dataStruct = null;
        DataCount<String>[] wordCounts = null;
    
        if (args[0].compareTo("-b")==0) {
        	dataStruct = new BinarySearchTree<String>();
        	wordCounts = countWords(dataStruct, args[2]);
        }
        else if (args[0].compareTo("-a")==0) {
        	dataStruct = new AvlTree<String>();
        	wordCounts = countWords(dataStruct, args[2]);
        }
        else if (args[0].compareTo("-h")==0) {
        	dataStruct = new HashTable();
        	wordCounts = countWords(dataStruct, args[2]);
        }
        else {
            System.err.println("\tSaw "+args[0]+" instead of [ -b | -a | -h ] as first argument");
            System.exit(1);
        }
        
        if (args[1].compareTo("-frequency")==0) {
        	printFrequency(wordCounts);
        }
        else if (args[1].compareTo("-num_unique")==0) {
        	printUniqueWords(wordCounts);
        }
        else {
            System.err.println("\tSaw "+args[0]+" instead of [ -frequency | -num_unique ] as second argument");
            System.exit(1);
        }
        
        
        System.out.println("Total words are: " + totalCount);
    }
}
