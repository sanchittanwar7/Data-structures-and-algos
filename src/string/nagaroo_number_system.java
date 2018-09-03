package string;

public class nagaroo_number_system {

	public static void main(String[] args) {
		String s1 = "389AEX7", s2 = "Hex";
		System.out.println(IsValidNumber(s1, s2));
	}

	private static boolean IsValidNumber(String s1, String s2) {
		if(s2.equals("Binary"))
			return isBinary(s1);
		else if(s2.equals("Decimal"))
			return isDecimal(s1);
		else if(s2.equals("Octal"))
			return isOctal(s1);
		else
			return isHexa(s1);
	}

	private static boolean isHexa(String s1) {
		int i;
		for(i = 0; i < s1.length(); i++) {
			if(!((s1.charAt(i) >= 48 && s1.charAt(i) <= 57) || (s1.charAt(i) >= 65 && s1.charAt(i) <= 70)))
				return false;
		}
		return true;
	}

	private static boolean isOctal(String s1) {
		int i;
		for(i = 0; i < s1.length(); i++) {
			if(s1.charAt(i) < 48 || s1.charAt(i) > 55)
				return false;
		}
		return true;
	}

	private static boolean isDecimal(String s1) {
		int i;
		for(i = 0; i < s1.length(); i++) {
			if(s1.charAt(i) < 48 || s1.charAt(i) > 57)
				return false;
		}
		return true;
	}

	private static boolean isBinary(String s1) {
		int i;
		for(i = 0; i < s1.length(); i++) {
			if(s1.charAt(i) != '0' && s1.charAt(i) != '1')
				return false;
		}
		return true;
	}

}
