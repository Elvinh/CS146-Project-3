package thienTree;

import java.text.NumberFormat;
import java.util.ArrayList;
import java.util.Locale;
import java.util.Random;

/**
 * Driver class for Part 1 of Project 2: Validating BST, AVL trees
 * Thien Van
 * CS 146 Fall 2015
 * 09/18/2015
 * 
 * Code for the BST, AVL implementations adapted from Michael Loceff, Foothill College
 * Code for the TreePrinter adopted from Professor Ron Mak, San Jose State University
 */
public class DriverPart2 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		// timing formatting
	    long startTime, stopTime;
	    // for formatting output neatly
	    NumberFormat tidy = NumberFormat.getInstance(Locale.US);
	    tidy.setMaximumFractionDigits(4);
		
		tBST testBST1 = new tBST();
		tBST testBST2 = new tBST();
		tBST testBST3 = new tBST();
		tBST testBST4 = new tBST();
		tBST testBST5 = new tBST();

		tBST testAvl1 = new tAvlTree();
		tBST testAvl2 = new tAvlTree();
		tBST testAvl3 = new tAvlTree();
		tBST testAvl4 = new tAvlTree();
		tBST testAvl5 = new tAvlTree();

		
		// creating static list of integers for each test case
		int n1 = 1000, n2 = 10000, n3 = 100000, n4 = 1000000, n5 = 2000000, k = 100000, 
				tbst1 = 0, tbst2 = 0, tbst3 = 0, tbst4 = 0, tbst5 = 0, 
				tavl1 = 0, tavl2 = 0, tavl3 = 0, tavl4 = 0, tavl5 = 0;
		
		Random rndm = new Random();
		
		ArrayList<Integer> randIntListN1 = new ArrayList<Integer>();
		ArrayList<Integer> randIntListN2 = new ArrayList<Integer>();
		ArrayList<Integer> randIntListN3 = new ArrayList<Integer>();
		ArrayList<Integer> randIntListN4 = new ArrayList<Integer>();
		ArrayList<Integer> randIntListN5 = new ArrayList<Integer>();
		
		for (int i = 0; i < n1; i++)
		{
			int value = rndm.nextInt(n1);
			randIntListN1.add(value);
		}
		for (int i = 0; i < n2; i++)
		{
			int value = rndm.nextInt(n2);
			randIntListN2.add(value);
		}
		for (int i = 0; i < n3; i++)
		{
			int value = rndm.nextInt(n3);
			randIntListN3.add(value);
		}
		for (int i = 0; i < n4; i++)
		{
			int value = rndm.nextInt(n4);
			randIntListN4.add(value);
		}
		for (int i = 0; i < n5; i++)
		{
			int value = rndm.nextInt(n5);
			randIntListN5.add(value);
		}
		
		// inserting into a BST
		startTime = System.nanoTime();  // ------------------ start
		for (int i = 0; i < n1; i++)
		{
			testBST1.insert(randIntListN1.get(i));
		}	
		stopTime = System.nanoTime();    // ---------------------- stop
		System.out.println("Elapsed Time for BST with n1 : "
             + tidy.format( (stopTime - startTime) / 1e9)
             + " seconds.");
		
		startTime = System.nanoTime();  // ------------------ start
		for (int i = 0; i < n2; i++)
		{
			testBST2.insert(randIntListN2.get(i));
		}	
		stopTime = System.nanoTime();    // ---------------------- stop
		System.out.println("Elapsed Time for BST with n2 : "
             + tidy.format( (stopTime - startTime) / 1e9)
             + " seconds.");
		
		startTime = System.nanoTime();  // ------------------ start
		for (int i = 0; i < n3; i++)
		{
			testBST3.insert(randIntListN3.get(i));
		}	
		stopTime = System.nanoTime();    // ---------------------- stop
		System.out.println("Elapsed Time for BST with n3 : "
             + tidy.format( (stopTime - startTime) / 1e9)
             + " seconds.");
		
		startTime = System.nanoTime();  // ------------------ start
		for (int i = 0; i < n4; i++)
		{
			testBST4.insert(randIntListN4.get(i));
		}	
		stopTime = System.nanoTime();    // ---------------------- stop
		System.out.println("Elapsed Time for BST with n4 : "
             + tidy.format( (stopTime - startTime) / 1e9)
             + " seconds.");
		
		startTime = System.nanoTime();  // ------------------ start
		for (int i = 0; i < n5; i++)
		{
			testBST5.insert(randIntListN5.get(i));
		}	
		stopTime = System.nanoTime();    // ---------------------- stop
		System.out.println("Elapsed Time for BST with n5 : "
             + tidy.format( (stopTime - startTime) / 1e9)
             + " seconds.");
		
		// inserting into an Avl
		startTime = System.nanoTime();  // ------------------ start
		for (int i = 0; i < n1; i++)
		{
			testAvl1.insert(randIntListN1.get(i));
		}	
		stopTime = System.nanoTime();    // ---------------------- stop
		System.out.println("Elapsed Time for Avl with n1 : "
             + tidy.format( (stopTime - startTime) / 1e9)
             + " seconds.");
		
		startTime = System.nanoTime();  // ------------------ start
		for (int i = 0; i < n2; i++)
		{
			testAvl2.insert(randIntListN2.get(i));
		}	
		stopTime = System.nanoTime();    // ---------------------- stop
		System.out.println("Elapsed Time for Avl with n2 : "
             + tidy.format( (stopTime - startTime) / 1e9)
             + " seconds.");
		
		startTime = System.nanoTime();  // ------------------ start
		for (int i = 0; i < n3; i++)
		{
			testAvl3.insert(randIntListN3.get(i));
		}	
		stopTime = System.nanoTime();    // ---------------------- stop
		System.out.println("Elapsed Time for Avl with n3 : "
             + tidy.format( (stopTime - startTime) / 1e9)
             + " seconds.");
		
		startTime = System.nanoTime();  // ------------------ start
		for (int i = 0; i < n4; i++)
		{
			testAvl4.insert(randIntListN4.get(i));
		}	
		stopTime = System.nanoTime();    // ---------------------- stop
		System.out.println("Elapsed Time for Avl with n4 : "
             + tidy.format( (stopTime - startTime) / 1e9)
             + " seconds.");
		
		startTime = System.nanoTime();  // ------------------ start
		for (int i = 0; i < n5; i++)
		{
			testAvl5.insert(randIntListN5.get(i));
		}	
		stopTime = System.nanoTime();    // ---------------------- stop
		System.out.println("Elapsed Time for Avl with n5 : "
             + tidy.format( (stopTime - startTime) / 1e9)
             + " seconds.");
		
		// part 2
		
		// initialize K list
		ArrayList<Integer> randIntListK = new ArrayList<Integer>();
		
		for (int i = 0; i < k; i++)
		{
			int value = rndm.nextInt(k);
			randIntListK.add(value);
		}
		
		// begin testing BST for k
		
		startTime = System.nanoTime();  // ------------------ start
		for (int i = 0; i < k; i++)
		{
			testBST1.contains(randIntListK.get(i));
			
			// check to see if contains function works
			//if(testBST1.contains(randIntListK.get(i)))
				//	tbst1++;
		}	
		stopTime = System.nanoTime();    // ---------------------- stop
		System.out.println("Elapsed Time for BST n1 tree with k searches : "
             + tidy.format( (stopTime - startTime) / 1e9)
             + " seconds.");
		//System.out.println("number of matches in n1 for BSTsearches : " + tbst1);
	
		startTime = System.nanoTime();  // ------------------ start
		for (int i = 0; i < k; i++)
		{
			testBST2.contains(randIntListK.get(i));
			
			// check to see if contains function works
			//if(testBST2.contains(randIntListK.get(i)))
				//tbst2++;
		}	
		stopTime = System.nanoTime();    // ---------------------- stop
		System.out.println("Elapsed Time for BST n2 tree with k searches : "
             + tidy.format( (stopTime - startTime) / 1e9)
             + " seconds.");
		//System.out.println("number of matches in n2 for BSTsearches : " + tbst2);
		
		startTime = System.nanoTime();  // ------------------ start
		for (int i = 0; i < k; i++)
		{
			testBST3.contains(randIntListK.get(i));
			
			// check to see if contains function works
			//if(testBST3.contains(randIntListK.get(i)))
				//tbst3++;
		}	
		stopTime = System.nanoTime();    // ---------------------- stop
		System.out.println("Elapsed Time for BST n3 tree with k searches : "
             + tidy.format( (stopTime - startTime) / 1e9)
             + " seconds.");
		//System.out.println("number of matches in n3 for BSTsearches : " + tbst3);
		
		startTime = System.nanoTime();  // ------------------ start
		for (int i = 0; i < k; i++)
		{
			testBST4.contains(randIntListK.get(i));
			
			// check to see if contains function works
			//if(testBST4.contains(randIntListK.get(i)))
				//tbst4++;
		}	
		stopTime = System.nanoTime();    // ---------------------- stop
		System.out.println("Elapsed Time for BST n4 tree with k searches : "
             + tidy.format( (stopTime - startTime) / 1e9)
             + " seconds.");
		//System.out.println("number of matches in n4 for BSTsearches : " + tbst4);
		
		startTime = System.nanoTime();  // ------------------ start
		for (int i = 0; i < k; i++)
		{
			testBST5.contains(randIntListK.get(i));
			
			// check to see if contains function works
			//if(testBST5.contains(randIntListK.get(i)))
				//tbst5++;
		}	
		stopTime = System.nanoTime();    // ---------------------- stop
		System.out.println("Elapsed Time for BST n5 tree with k searches : "
             + tidy.format( (stopTime - startTime) / 1e9)
             + " seconds.");
		//System.out.println("number of matches in n5 for BSTsearches : " + tbst5);
		
		
		// begin AVL testing for k
		
		startTime = System.nanoTime();  // ------------------ start
		for (int i = 0; i < k; i++)
		{
			testAvl1.contains(randIntListK.get(i));
			
			// check to see if contains function works
			//if(testAvl1.contains(randIntListK.get(i)))
				//tavl1++;
		}	
		stopTime = System.nanoTime();    // ---------------------- stop
		System.out.println("Elapsed Time for Avl n1 tree with k searches : "
             + tidy.format( (stopTime - startTime) / 1e9)
             + " seconds.");
		//System.out.println("number of matches in n1 for AVLsearches : " + tavl1);
		
		startTime = System.nanoTime();  // ------------------ start
		for (int i = 0; i < k; i++)
		{
			testAvl2.contains(randIntListK.get(i));
			
			// check to see if contains function works
			//if(testAvl2.contains(randIntListK.get(i)))
				//tavl2++;
		}	
		stopTime = System.nanoTime();    // ---------------------- stop
		System.out.println("Elapsed Time for Avl n2 tree with k searches : "
             + tidy.format( (stopTime - startTime) / 1e9)
             + " seconds.");
		//System.out.println("number of matches in n2 for AVLsearches : " + tavl2);
		
		startTime = System.nanoTime();  // ------------------ start
		for (int i = 0; i < k; i++)
		{
			testAvl3.contains(randIntListK.get(i));
			
			// check to see if contains function works
			//if(testAvl3.contains(randIntListK.get(i)))
				//tavl3++;
		}	
		stopTime = System.nanoTime();    // ---------------------- stop
		System.out.println("Elapsed Time for Avl n3 tree with k searches : "
             + tidy.format( (stopTime - startTime) / 1e9)
             + " seconds.");
		//System.out.println("number of matches in n3 for AVLsearches : " + tavl3);
		
		startTime = System.nanoTime();  // ------------------ start
		for (int i = 0; i < k; i++)
		{
			testAvl4.contains(randIntListK.get(i));
			
			// check to see if contains function works
			//if(testAvl4.contains(randIntListK.get(i)))
				//tavl4++;
		}	
		stopTime = System.nanoTime();    // ---------------------- stop
		System.out.println("Elapsed Time for Avl n4 tree with k searches : "
             + tidy.format( (stopTime - startTime) / 1e9)
             + " seconds.");
		//System.out.println("number of matches in n4 for AVLsearches : " + tavl4);
		
		startTime = System.nanoTime();  // ------------------ start
		for (int i = 0; i < k; i++)
		{
			testAvl5.contains(randIntListK.get(i));
			
			// check to see if contains function works
			//if(testAvl5.contains(randIntListK.get(i)))
				//tavl5++;
		}	
		stopTime = System.nanoTime();    // ---------------------- stop
		System.out.println("Elapsed Time for Avl n5 tree with k searches : "
             + tidy.format( (stopTime - startTime) / 1e9)
             + " seconds.");
		//System.out.println("number of matches in n5 for AVLsearches : " + tavl5);
	
		// Sanity checks
/*		System.out.println("height of bst1 is " + testBST1.showHeight());
		System.out.println("height of avl1 is " + testAvl1.showHeight());

		System.out.println("size of bst5 is " + testBST5.size());
		System.out.println("size of avl5 is " + testAvl5.size());*/
		
		// part 3: test on n5 trees
		
		// initialize number of insertions and searches
		int m = 100000;
		
		// initialize m list of 100000 integers
		ArrayList<Integer> randIntListM = new ArrayList<Integer>();
		
		for (int i = 0; i < m; i++)
		{
			int value = rndm.nextInt(m);
			randIntListM.add(value);
		}
		
		// base case with m for n3
		startTime = System.nanoTime();  // ------------------ start
		for (int i = 0; i < m; i++)
		{
			testBST5.insert(randIntListM.get(i));
			testBST5.contains(randIntListM.get(i));
			
			// check to see if contains function works
			//if(testAvl5.contains(randIntListM.get(i)))
				//tavl5++;
		}	
		stopTime = System.nanoTime();    // ---------------------- stop
		System.out.println("Elapsed Time for BST with m insert and searches : "
             + tidy.format( (stopTime - startTime) / 1e9)
             + " seconds.");
		
		startTime = System.nanoTime();  // ------------------ start
		for (int i = 0; i < m; i++)
		{
			testAvl5.insert(randIntListM.get(i));
			testAvl5.contains(randIntListM.get(i));
			
			// check to see if contains function works
			//if(testAvl5.contains(randIntListM.get(i)))
				//tavl5++;
		}	
		stopTime = System.nanoTime();    // ---------------------- stop
		System.out.println("Elapsed Time for Avl with m insert and searches : "
             + tidy.format( (stopTime - startTime) / 1e9)
             + " seconds.");
	
		// base case with m/2 insertions, m/5 searches
		startTime = System.nanoTime();  // ------------------ start
		for (int i = 0; i < m; i++)
		{
			testBST5.insert(randIntListM.get(i/2));
			testBST5.contains(randIntListM.get(i/5));
			
			// check to see if contains function works
			//if(testAvl5.contains(randIntListM.get(i)))
				//tavl5++;
		}	
		stopTime = System.nanoTime();    // ---------------------- stop
		System.out.println("Elapsed Time for BST with m/2 insert and m/5 searches : "
             + tidy.format( (stopTime - startTime) / 1e9)
             + " seconds.");
		
		startTime = System.nanoTime();  // ------------------ start
		for (int i = 0; i < m; i++)
		{
			testAvl5.insert(randIntListM.get(i/2));
			testAvl5.contains(randIntListM.get(i/5));
			
			// check to see if contains function works
			//if(testAvl5.contains(randIntListM.get(i)))
				//tavl5++;
		}	
		stopTime = System.nanoTime();    // ---------------------- stop
		System.out.println("Elapsed Time for Avl with m/2 insert and m/5 searches : "
             + tidy.format( (stopTime - startTime) / 1e9)
             + " seconds.");
		
		// base case with m/5 insertions, m/2 searches
		startTime = System.nanoTime();  // ------------------ start
		for (int i = 0; i < m; i++)
		{
			testBST5.insert(randIntListM.get(i));
			testBST5.contains(randIntListM.get(i));
			
			// check to see if contains function works
			//if(testAvl5.contains(randIntListM.get(i)))
				//tavl5++;
		}	
		stopTime = System.nanoTime();    // ---------------------- stop
		System.out.println("Elapsed Time for BST with m/5 insert and m/2 searches : "
             + tidy.format( (stopTime - startTime) / 1e9)
             + " seconds.");
		
		startTime = System.nanoTime();  // ------------------ start
		for (int i = 0; i < m; i++)
		{
			testAvl5.insert(randIntListM.get(i));
			testAvl5.contains(randIntListM.get(i));
			
			// check to see if contains function works
			//if(testAvl5.contains(randIntListM.get(i)))
				//tavl5++;
		}	
		stopTime = System.nanoTime();    // ---------------------- stop
		System.out.println("Elapsed Time for Avl with m/5 insert and m/2 searches : "
             + tidy.format( (stopTime - startTime) / 1e9)
             + " seconds.");
		
		// base case with m for n5
		startTime = System.nanoTime();  // ------------------ start
		for (int i = 0; i < m; i++)
		{
			testBST5.insert(randIntListM.get(i));
			testBST5.contains(randIntListM.get(i));
			
			// check to see if contains function works
			//if(testAvl5.contains(randIntListM.get(i)))
				//tavl5++;
		}	
		stopTime = System.nanoTime();    // ---------------------- stop
		System.out.println("Elapsed Time for BST with m insert and searches : "
             + tidy.format( (stopTime - startTime) / 1e9)
             + " seconds.");
		
		startTime = System.nanoTime();  // ------------------ start
		for (int i = 0; i < m; i++)
		{
			testAvl5.insert(randIntListM.get(i));
			testAvl5.contains(randIntListM.get(i));
			
			// check to see if contains function works
			//if(testAvl5.contains(randIntListM.get(i)))
				//tavl5++;
		}	
		stopTime = System.nanoTime();    // ---------------------- stop
		System.out.println("Elapsed Time for Avl with m insert and searches : "
             + tidy.format( (stopTime - startTime) / 1e9)
             + " seconds.");
	
		// base case with m/2 insertions, m/5 searches
		startTime = System.nanoTime();  // ------------------ start
		for (int i = 0; i < m; i++)
		{
			testBST5.insert(randIntListM.get(i/2));
			testBST5.contains(randIntListM.get(i/5));
			
			// check to see if contains function works
			//if(testAvl5.contains(randIntListM.get(i)))
				//tavl5++;
		}	
		stopTime = System.nanoTime();    // ---------------------- stop
		System.out.println("Elapsed Time for BST with m/2 insert and m/5 searches : "
             + tidy.format( (stopTime - startTime) / 1e9)
             + " seconds.");
		
		startTime = System.nanoTime();  // ------------------ start
		for (int i = 0; i < m; i++)
		{
			testAvl5.insert(randIntListM.get(i/2));
			testAvl5.contains(randIntListM.get(i/5));
			
			// check to see if contains function works
			//if(testAvl5.contains(randIntListM.get(i)))
				//tavl5++;
		}	
		stopTime = System.nanoTime();    // ---------------------- stop
		System.out.println("Elapsed Time for Avl with m/2 insert and m/5 searches : "
             + tidy.format( (stopTime - startTime) / 1e9)
             + " seconds.");
		
		// base case with m/5 insertions, m/2 searches
		startTime = System.nanoTime();  // ------------------ start
		for (int i = 0; i < m; i++)
		{
			testBST5.insert(randIntListM.get(i));
			testBST5.contains(randIntListM.get(i));
			
			// check to see if contains function works
			//if(testAvl5.contains(randIntListM.get(i)))
				//tavl5++;
		}	
		stopTime = System.nanoTime();    // ---------------------- stop
		System.out.println("Elapsed Time for BST with m/5 insert and m/2 searches : "
             + tidy.format( (stopTime - startTime) / 1e9)
             + " seconds.");
		
		startTime = System.nanoTime();  // ------------------ start
		for (int i = 0; i < m; i++)
		{
			testAvl5.insert(randIntListM.get(i));
			testAvl5.contains(randIntListM.get(i));
			
			// check to see if contains function works
			//if(testAvl5.contains(randIntListM.get(i)))
				//tavl5++;
		}	
		stopTime = System.nanoTime();    // ---------------------- stop
		System.out.println("Elapsed Time for Avl with m/5 insert and m/2 searches : "
             + tidy.format( (stopTime - startTime) / 1e9)
             + " seconds.");
	}
}
