package string;

public class addBinaryStrings {
	static String carry;

	public static void main(String[] args) {
		String str1 = "10001100010111000101100010100110001001101010000010011010", str2 = "101111000100100100111110010010101110101001100100101001111010011000000110";
		System.out.println(addBinary(str1, str2));
	}

	private static String addBinary(String s1, String s2) {
		String addOn = "";
		int i, n1 = s1.length(), n2 = s2.length();
		for(i = 0; i < Math.abs(n1-n2); i++) {
			addOn += "0";
		}
		if(n1 < n2)
			s1 = addOn + s1;
		else
			s2 = addOn + s2;
		carry = "0";
		String val, ans = "";
		for(i = s1.length()-1; i >= 0; i--) {
			val = add(carry+s1.charAt(i)+s2.charAt(i));
			ans = val + ans;
		}
		if(carry.equals("1"))
			return carry+ans;
		return ans;
		
	}

	private static String add(String s) {
		switch(s) {
			case "000" : return "0";
			case "001" : return "1";
			case "010" : return "1";
			case "011" : carry = "1";
				return "0";
			case "100" : carry = "0"; 
				return "1";
			case "101" : return "0";
			case "110" : return "0";
			case "111" : return "1";
		}
		return "";
	}

	private static String convert(long i) {
		System.out.println(i);
		String s, ans = "";
		while(i > 0) {
			s = i%2 == 0 ? "0" : "1";
			ans = s + ans;
			i /= 2;
		}
		return ans;
	}

	private static double afterDecimal(String binary) {
		char[] numbers = binary.toCharArray();
	    double result = 0;
	    for(int i=0; i<binary.length(); i++)
	        if(numbers[i]=='1')
	            result += Math.pow(2, -(numbers.length-i - 1));
	    return result;
	}

	private static long beforeDecimal(String binary) {
		char[] numbers = binary.toCharArray();
	    long result = 0;
	    for(int i=numbers.length - 1; i>=0; i--)
	        if(numbers[i]=='1')
	            result += Math.pow(2, (numbers.length-i - 1));
	    return result;
	}

}
