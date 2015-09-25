package hashtable;

import java.util.Iterator;
import java.util.LinkedList;
<<<<<<< HEAD

// comment
=======
import hashtable.Cell;
>>>>>>> origin/master
public class HashTable<K,V> {
	private static final int MAX_SIZE = 100;

	private LinkedList<Cell<K,V>>[] table;
	private int count;
	
	public HashTable() {
	}
	public void put(Cell<K,V> newCell) {
		int index = -1;
		index = hashingFunction(newCell.getkey());
		
		if(table[index] == null) {
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
		for(int i = 0; i < table[index].size(); i++) {
			if(table[index].get(i).getkey() == key) {
				targetValue = table[index].get(i).getValue();
				break;
			}
		}
		return targetValue;
	}
	int hashingFunction(K key) {
		int index = -1;
		return index;
	}
}
