package test.regex;

public class TestPhone {

	public static void main(String[] args) {
		String regex = "^(0[0-9]{2,3})-([2-9][0-9]{6,7})-([0-9]{1,4})$";
		
		String phone = "0101-88551199-2201-";
		
		System.out.println(phone.matches(regex));
	}
}
