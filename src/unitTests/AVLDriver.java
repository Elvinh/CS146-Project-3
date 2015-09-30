
package unitTests;

import wordcounter.AvlTree;
import wordcounter.TreePrinter;
import wordcounter.BinarySearchTree;

public class AVLDriver {

	public static void main(String[] args) {
		BinarySearchTree<Integer> avl = new AvlTree<Integer>();
		Integer num;			
		
		for(int i=0; i < 35; i++) {
			do {
				num =(int) randomWithRange(10,99);
			}while(avl.contains(num, avl.getRoot())); //Generates random number till a unique number is found.
			
			System.out.println("Inserting: " + num.toString());
			avl.incCount(num);
			TreePrinter tr = new TreePrinter(avl);
			tr.print("Count: " + Integer.toString(avl.getSize()));
			System.out.println("");
		}
		
	}
	
	static int randomWithRange(int min, int max)
	{
	   int range = (max - min) + 1;     
	   return (int)(Math.random() * range) + min;
	}
}
