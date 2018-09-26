package hashing;

import java.util.HashMap;

public class fractions {

	public static void main(String[] args) {
		int a = -12, b = -6;
		System.out.println(fractionToDecimal(a, b));
	}

	public static String fractionToDecimal(int A, int B) {
		if(A == 0)
			return "0";
		StringBuffer ans = new StringBuffer("");
		long a = A, b = B;
		if((a<0&&b>0)||(a>0&&b<0)) {
			ans.append("-");
		}
		a = Math.abs(a);
		b = Math.abs(b);
		int index;
		HashMap<Long, Integer> map = new HashMap<>();
		ans.append(Long.toString(a/b));
		a = a%b;
		if(a == 0)
			return ans.toString();
		ans.append(".");
		while(a != 0) {
			if(map.containsKey(a)) {
				index = map.get(a);
				ans = ans.insert(index, "(").append(")");
				break;
			}
			map.put(a, ans.length());
			a *= 10;
			ans.append(Long.toString(a/b));
			a = a%b;
		}
		return ans.toString();
	}

}
