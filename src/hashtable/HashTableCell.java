package hashtable;

import java.util.LinkedList;

import hashtable.Cell;
public class HashTableCell<K,V> {
	private static final int MAX_SIZE = 100;
//testsd
	private LinkedList<Cell<K,V>>[] table;
	private int count;
	
	public HashTableCell() {
	}
	public void put(Cell<K,V> newCell) {
		int index = -1;
		index = hashingFunction(newCell.getkey());
		
		if(table[index] == null) { //creates a new bucket linked list if index has no value
			LinkedList<Cell<K,V>> bucket = new LinkedList<Cell<K,V>>();
			table[index] = bucket;
			table[index].add(newCell);
		}
		else {
			table[index].add(newCell);
		}
		count++;
	}
	V get(K key) {
		int index = hashingFunction(key);
		V targetValue = null;
		for(int i = 0; i < table[index].size(); i++) { //searching linked list at index for key value
			if(table[index].get(i).getkey() == key) {
				targetValue = table[index].get(i).getValue();
				break;
			}
		}
		return targetValue;
	}
	int hashingFunction(K key) {
		int index = -1;
		
		index = myHashCode(key) % count;
		if (index < 0 )
			index += count;
		
		return index;
	}
	
	// helper method to calculate hash, similar to built-in Java hashCode()
	private int myHashCode( K key )
	{
		int hash, h = 0;
		char [] val = key.toString().toCharArray();
		
		for ( int i = 0; i < key.toString().length(); i++ )
			h = 37 * h + val[i];
		
		hash = h;
		// System.out.println(hash);
		return hash;
	}
}
