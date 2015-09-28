package wordcounter;

import java.util.LinkedList;

/**
 * TODO Replace this comment with your own.
 * 
 * Stub code for an implementation of a DataCounter that uses a hash table as
 * its backing data structure. We included this stub so that it's very clear
 * that HashTable works only with Strings, whereas the DataCounter interface is
 * generic.  You need the String contents to write your hashcode code.
 */
public class HashTable implements DataCounter<String> {
	private LinkedList<Cell>[] table;
	private int count;
   
	/** {@inheritDoc} */
    public DataCount<String>[] getCounts() {
    	DataCount<String>[] counts = null;
    	
    	for(int i = 0;i < table.length;i++) {
    		for(int j = 0;j < table[i].size();i++) {
    			counts[counts.length-1]= new DataCount<String>(table[i].get(j).getValue(), table[i].get(j).getCount());
    		}
    	}
    	
        return counts;
    }

    /** {@inheritDoc} */
    public int getSize() {
        // TODO Auto-generated method stub
        return count;
    }

    /** {@inheritDoc} */
    public void incCount(String data) {
        // TODO Auto-generated method stub
    	Cell newCell = new Cell(data);
		int index = -1;

		if(contains(newCell.getkey())) {
			newCell = get(newCell.getkey());
			newCell.incCount();
		}
		else {
			index = hashingFunction(newCell.getkey());
			
			if(table[index] == null) { //creates a new bucket linked list if index has no value
				LinkedList<Cell> bucket = new LinkedList<Cell>();
				table[index] = bucket;
				table[index].add(newCell);
			}
			else {
				table[index].add(newCell);
			}
			count++;
		}
		
    }

    public Boolean contains(String key) {
    	boolean found = false;
		int index = hashingFunction(key);
		
		for(int i = 0; i < table[index].size(); i++) { //searching linked list at index for key value
			if(table[index].get(i).getkey() == key) {
				found = true;
				break;
			}
		}
		return found;
    }
	Cell get(String key) {
		int index = hashingFunction(key);
		Cell targetValue = null;
		for(int i = 0; i < table[index].size(); i++) { //searching linked list at index for key value
			if(table[index].get(i).getkey() == key) {
				targetValue = table[index].get(i);
				break;
			}
		}
		return targetValue;
	}
	int hashingFunction(String key) {
		int index = -1;
		return index;
	}
}
