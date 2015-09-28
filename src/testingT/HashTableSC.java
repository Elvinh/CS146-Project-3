package testingT;

import java.util.LinkedList;
import java.util.ListIterator;

public class HashTableSC<E> {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}

	static final int INIT_TABLE_SIZE = 97;
	static final double INIT_MAX_LAMBDA = 1.5;
	
	private LinkedList<E> [] table;
	private int size;
	private int tableSize;
	private double maxLambda;
	
	// constructors
	
	// if desired tablesize larger than initial, find next large prime for size 
	public HashTableSC( int ts )
	{
		int k;
		
		if (ts < INIT_TABLE_SIZE)
			tableSize = INIT_TABLE_SIZE;
		else
			tableSize = nextPrime(ts);
		
		allocateListArray();
		maxLambda = INIT_MAX_LAMBDA;
	}
	
	public HashTableSC()
	{
		this(INIT_TABLE_SIZE);
	}
	
	public boolean contains( E x )
	{
		LinkedList<E> theTable = table[myHash(x)];
		
		return theTable.contains(x);
	}
	
	public void makeEmpty()
	{
		
	}
	
	public boolean insert( E x )
	{
		LinkedList<E> theTable = table[myHash(x)];
		
		if ( theTable.contains(x) )
			return false;
		
		// not found so insert
		theTable.addLast(x);
		
		// check load factor
		if ( ++size > maxLambda * tableSize )
			rehash();
		
		return true;
	}
	
	public boolean remove( E x )
	{
		ListIterator<E> iter;
		LinkedList<E> theTable = table[myHash(x)];
		
		for ( iter = theTable.listIterator(); iter.hasNext(); )
			if ( x.equals(iter.next()) )
			{
				iter.remove();
				size--;
				return true;
			}
		
		// not found
		return false;
	}
	
	public int size() {	return size; }
	
	public boolean setMaxLambda( double lam )
	{
		if ( lam < .1 || lam > 100.)
			return false;
		maxLambda = lam;
		return true;
	}

	// private methods
	
	// double the tableSize but reallocate values based on tableSize (hash function)
	private void rehash()
	{
		// save old list and size then can allocate freely
		LinkedList<E>[] oldTable = table;
		int k, oldTableSize = tableSize;
		ListIterator<E> iter;
		
		tableSize = nextPrime(2*oldTableSize);
		
		// allocate a larger, empty array
		allocateListArray();
		
		// use the insert() algorithm to re-enter old data
		size = 0;
		for ( k = 0; k < oldTableSize; k++ )
			for ( iter = oldTable[k].listIterator(); iter.hasNext() ; )
				insert( iter.next() );
	}
	
	private int myHash( E x )
	{
		int hashVal;
		
		hashVal = myHashCode(x) % tableSize;
		if (hashVal < 0 )
			hashVal += tableSize;
		
		return hashVal;
	}
	
	// helper method to calculate hash
	private int myHashCode( E x )
	{
		int hash, h = 0;
		char [] val = x.toString().toCharArray();
		
		for ( int i = 0; i < x.toString().length(); i++ )
			h = 37 * h + val[i];
		
		hash = h;
		// System.out.println(hash);
		return hash;
	}
	
	
	private static int nextPrime( int n )
	{
		int k, candidate, loopLim;
		
		// loop doesn't work for 2 or 3
		if ( n <= 2 )
			return 2;
		else if ( n == 3 )
			return 3;
		
		for ( candidate = (n%2 == 0)? n+1 : n ; true ; candidate += 2)
		{
			// all primes > 3 are of the form 6k +/- 1
			loopLim = (int)( (Math.sqrt((double)candidate) + 1)/6);
			
			// we know it is odd. check for divisibility by 3
			if ( candidate % 3 == 0)
				continue;
			
			// now we can check for divisibility by 6k +/1 1 up to sqrt
			for ( k = 1; k <= loopLim; k++ )
			{
				if (candidate % (6*k - 1) == 0)
					break;
				if (candidate % (6*k + 1) == 0)
					break;
			}
			if ( k > loopLim)
				return candidate;
		}
	}
	
	// initializes the list array based off tableSize
	void allocateListArray()
	{
		int k;
		
		table = new LinkedList[tableSize];
		for ( k = 0; k < tableSize; k++)
			table[k] = new LinkedList<E>();
	}
}
