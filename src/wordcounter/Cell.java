package wordcounter;

public class Cell {
	private String value;
	private String key;
	private int count;
	
	Cell(String value) {
		this.count = 1;
		this.value = value;
		this.key = value;
	}
	Cell(String value, String key) {
		this.count = 1;
		this.value = value;
		this.key = key;
	}
	public String getValue() {
		return this.value;
	}
	public String getkey() {
		return this.key;
	}
	public int getCount() {
		return count;
	}
	public void incCount() {
		this.count++;;
	}
}
