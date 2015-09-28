package wordcounter;

import java.io.IOException;

/**
 * An executable that counts the words in a files and prints out the counts in
 * descending order. You will need to modify this file.
 */
public class Correlator {

	private static int totalCount1 = 0, totalCount2 = 0;
	private static double errorSum = 0;
	
    private static void correlator(String file1, String file2) {
        //DataCounter<String> counter1 = new tBST<String>();
        //DataCounter<String> counter2 = new tBST<String>();
    	DataCounter<String> counter1 = new HashTable();
        DataCounter<String> counter2 = new HashTable();
        
        // 1st document
        
        try {
            FileWordReader reader = new FileWordReader(file1);
            String word = reader.nextWord();
            while (word != null) {
                counter1.incCount(word);
                word = reader.nextWord();
            }
        } catch (IOException e) {
            System.err.println("Error processing " + file1 + e);
            System.exit(1);
        }

        DataCount<String>[] counts1 = counter1.getCounts();
        sortByDescendingCount(counts1);
        
        // sum up the total words
        for (DataCount<String> c : counts1)
        {
        	totalCount1 += c.count;
        }
        
        // only print relevant words
        System.out.println("File1 printing words with frequency < 1% or > 0.01%");
        for (DataCount<String> c : counts1)
        {
	        if ( (double) c.count/totalCount1 <= 0.01 && (double) c.count/totalCount1 >= 0.0001 )
	        {
	        	System.out.println(((double) c.count/totalCount1)  * 100 + " \t" + c.count + " \t" + c.data);
	        }
        }
        
        // 2nd document
        
        try {
            FileWordReader reader = new FileWordReader(file2);
            String word = reader.nextWord();
            while (word != null) {
                counter2.incCount(word);
                word = reader.nextWord();
            }
        } catch (IOException e) {
            System.err.println("Error processing " + file2 + e);
            System.exit(1);
        }

        DataCount<String>[] counts2 = counter2.getCounts();
        sortByDescendingCount(counts2);
        
        // sum up the total words
        for (DataCount<String> c : counts2)
        {
        	totalCount2 += c.count;
        }
        
        // only print relevant words
        System.out.println("File2 printing words with frequency < 1% or > 0.01%");
        for (DataCount<String> c : counts2)
        {
        	if ((double) c.count/totalCount2 <= 0.01 && (double) c.count/totalCount2 >= 0.0001)
        	{
        		System.out.println((double) c.count/totalCount2 + " \t" + c.count + " \t" + c.data);
        	}
        }
        
        // calculate the difference
        for (DataCount<String> c1: counts1)
    		if ((double) c1.count/totalCount1 <= 0.01 && (double) c1.count/totalCount1 >= 0.0001)
        	for (DataCount<String> c2: counts2)
        		if ((double) c2.count/totalCount2 <= 0.01 && (double) c2.count/totalCount2 >= 0.0001)
        			if( c1.data.equals(c2.data) )
        			{
        				System.out.println("Match with word: " + c1.data + " freq1 = " + (double) c1.count/totalCount1 
        						+ ", freq2 = " + (double) c2.count/totalCount2);
        				errorSum += Math.pow( (double) c1.count/totalCount1 - (double) c2.count/totalCount2, 2.);
        			}
        System.out.println("Error Sum is: " + errorSum);
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
    	// comment below 4 lines to test within Eclipse
        /*(if (args.length != 3) {
            System.err.println("Usage: filename of document to analyze");
            System.exit(1);
        }*/
        
        /* Elton: Thien if you want to test within eclipse go to Run->Run configurations...>Program arguments
         * and type file names into the box. 
         */
        //correlator("C:/Users/thien/Documents/GitHub/CS146-Project-3/src/rawProjectFiles/hamlet.txt", 
        		//"C:/Users/thien/Documents/GitHub/CS146-Project-3/src/rawProjectFiles/the-new-atlantis.txt");
        correlator("C:/Users/Elton/git/CS146-Project-3/src/txtFiles/hamlet.txt", 
        		"C:/Users/Elton/git/CS146-Project-3/src/txtFiles/the-new-atlantis.txt");
        //System.out.println("Total words are: " + totalCount);
    }
}
