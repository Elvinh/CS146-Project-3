package hashtable;

public class Cell<K,V> {
	private V value;
	private K key;
	
	Cell(V value, K key) {
		this.value = value;
		this.key = key;
	}
	public V getValue() {
		return this.value;
	}
	public K getkey() {
		return this.key;
	}
}
