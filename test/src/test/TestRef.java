package test;

public class TestRef {
	public static void main(String[] args) {
		Obj obj = new Obj();
		System.out.println(obj);
		
		changeRef(obj);
		System.out.println(obj);
		
		
	}
	
	private static void changeRef(Obj obj) {
		obj = null;
		System.out.println(obj);
	}
}

class Obj {
	private String str = "default";

	public String getStr() {
		return str;
	}

	public void setStr(String str) {
		this.str = str;
	}

	@Override
	public String toString() {
		return "Obj [str=" + str + "]";
	}
	
}
