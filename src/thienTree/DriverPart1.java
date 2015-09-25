package thienTree;

import java.util.ArrayList;
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
public class DriverPart1 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		bstTest();
		avlTest();		
	}

	static void bstTest()
	{
		tBST testBST1 = new tBST();
		
		Random rndm10to99 = new Random();
		ArrayList<Integer> randIntList = new ArrayList<Integer>();
		int indexInsert = 0;
		int indexRemove = 0;
		
		// test random number generator
		for (int i = 0; i < 100; i++)
		{
			int value = rndm10to99.nextInt(90) + 10;
			randIntList.add(value);
		}
		
		while(testBST1.showHeight() < 5)
		{
			testBST1.insert(randIntList.get(indexInsert));
			indexInsert++;
		}

		TreePrinter tp1 = new TreePrinter(testBST1);
		tp1.print("Full Test BST1 printed below");
		
		while(testBST1.tRoot != null)
		{
			testBST1.remove(testBST1.tRoot);
			System.out.print(indexRemove + 1);
			tp1.print(" removal(s) from Test BST1");
			indexRemove++;
		}
		
		System.out.println(indexInsert + " attempted inserts with "
				+ indexRemove + " nodes removed");
	}
	
	static void avlTest()
	{
		tBST testAvl1 = new tAvlTree();
		Random rndm10to99 = new Random();
		ArrayList<Integer> randIntList = new ArrayList<Integer>();
		int indexInsert = 0;
		int indexRemove = 0;
		
		// test random number generator
		for (int i = 0; i < 100 && randIntList.size() < 35; i++)
		{
			int value = rndm10to99.nextInt(90) + 10;
			if (!randIntList.contains(value))
				randIntList.add(value);
		}
		
		for ( int elem : randIntList )
		{
			System.out.println("\nInserting node: " + elem);
			testAvl1.insert(elem);
			
			TreePrinter tp2 = new TreePrinter(testAvl1);
			
			System.out.print("\n" + (indexInsert + 1));
			tp2.print(" node(s) inserted. Showing result below.\n");
			indexInsert++;
		}
		
		System.out.println("\n" + indexInsert + " total unique inserts\n");
		
		while(testAvl1.tRoot != null)
		{
			System.out.println("\nRemoving root: " + testAvl1.tRoot.data);
			testAvl1.remove(testAvl1.tRoot.data);
			
			TreePrinter tp2 = new TreePrinter(testAvl1);

			System.out.print("\n" + (indexRemove + 1));
			tp2.print(" removal(s) from Test AVL1. Showing result below.\n");
			indexRemove++;
		}
	}
}
