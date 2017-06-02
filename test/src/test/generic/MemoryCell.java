package test.generic;

public class MemoryCell<T> {

	private T storedValue;
	
	public T read() {
		return storedValue;
	}
	
	public void write(T x) {
		this.storedValue = x;
	}
	
	public static void main(String[] args) {
		MemoryCell<String> m = new MemoryCell<String>();
		m.write("37");
		
		String val = m.read();
		
		System.out.println("contents are:" + val);
	}
}


