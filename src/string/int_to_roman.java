package string;

class Values{
	String low, high, higher;
	Values(String low, String high, String higher){
		this.low = low;
		this.high = high;
		this.higher = higher;
	}
}

public class int_to_roman {

	public static void main(String[] args) {
		int n1 = 1776;
		int n2 = 1954;
		int n3 = 1990;
		int n4 = 2014;
		int n5 = 2018;
		
		final StringBuffer str = new StringBuffer("abc");
		str.append("ab");
		System.out.println(str);
		
		System.out.println(intToRoman(n1));
		System.out.println(intToRoman(n2));
		System.out.println(intToRoman(n3));
		System.out.println(intToRoman(n4));
		System.out.println(intToRoman(n5));

	}

	private static String intToRoman(int n) {
		Values[] value = new Values[3];
		value[0] = new Values("I", "V", "X");
		value[1] = new Values("X", "L", "C");
		value[2] = new Values("C", "D", "M");
		int place = -1, num, i = 0;
		String ans = "", roman;
		while(i < 3) {
			num = n%10;
			place++;
			if(num >= 1 && num <= 3) {
				while(num > 0) {
					ans = value[place].low + ans;
					num--;
				}
			}
			else if(num == 4)
				ans = value[place].low + value[place].high + ans;
			else if(num == 5)
				ans = value[place].high + ans;
			else if(num >= 6 && num <= 8) {
				roman = value[place].high;
				while(num > 5) {
					roman = roman + value[place].low;
					num--;
				}
				ans = roman + ans;
			}
			else if(num == 9)
				ans = value[place].low + value[place].higher + ans;
			n /= 10;
			i++;
		}
		while(n > 0) {
			ans = "M" + ans;
			n--;
		}
		return ans;
	}

}
