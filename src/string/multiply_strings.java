package string;

public class multiply_strings {

	public static void main(String[] args) {
		String n1 = "5131848155574784703269632922904933776792735241197982102373370", n2 = "56675688419586288442134264892419611145485574406534291250836";
		String ans = multiply(n1, n2);
		String check = "290851027081985078955918627261751688832742312387314888842460711865148550965912482730570750031304678344564428861596637320";
		System.out.println(ans);
		System.out.println(check);
	}

	private static String multiply(String n1, String n2) {
		int pow = 0;
		String s, ans = "";
		for(int i = n2.length()-1; i >= 0; i--) {
			s = multi(n1, n2.charAt(i));
			System.out.println(s);
			for(int j = 0; j < pow; j++)
				s = s + "0";
			ans = add(ans, s);
			pow++;
		}
		return ans;
	}

	private static String add(String s1, String s2) {
		//		System.out.println(s1 + " " + s2);
		int n1 = s1.length()-1, n2 = s2.length()-1;
		String ans = "";
		int carry = 0, value;
		while(n1 >= 0 && n2 >= 0) {
			//			System.out.println(n1 + " " + n2);
			value = Integer.parseInt(""+s1.charAt(n1)) + Integer.parseInt(""+s2.charAt(n2));
			ans = "" + (value + carry)%10 + ans;
			carry = (value + carry)/10;
			n1--;n2--;
		}
		while(n1 >= 0) {
			value = Integer.parseInt(""+s1.charAt(n1));
			ans = "" + (value + carry)%10 + ans;
			carry = (value + carry)/10;
			n1--;
		}
		while(n2 >= 0) {
			value = Integer.parseInt(""+s2.charAt(n2));
			ans = "" + (value + carry)%10 + ans;
			carry = (value + carry)/10;
			n2--;
		}
		int i = 0;
		while(i < ans.length() && ans.charAt(i) == '0')
			i++;
//		if(i == 0)
//			return ans;
//		else if(i == ans.length())
//			return "0";
//		return ans.substring(i);
		return ans;
	}

	private static String multi(String s, char charAt) {
		int value, carry = 0;
		String ans = "";
		for(int i = s.length()-1; i >= 0; i--) {
			value = Integer.parseInt(""+s.charAt(i)) * Integer.parseInt("" + charAt);
			ans = "" + (value + carry)%10 + ans;
			carry = (value+carry)/10;
		}
		if(carry == 0)
			return ans;
		return Integer.toString(carry) + ans;
	}

}
