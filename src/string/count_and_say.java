package string;

import java.util.ArrayList;

public class count_and_say {

	public static void main(String[] args) {
		int n = 40;
		System.out.println(countAndSay(n));
	}

	private static String countAndSay(int n) {
		if(n == 1)
			return "1";
		String prev = "1";
		String current = "";
		int i = 0, j, count;
		char ele;
		while(i < n-1) {
			current = "";
			j = 0;
			for(j = 0; j < prev.length(); j++) {
				ele = prev.charAt(j);
				count = 0;
				while(j < prev.length() && prev.charAt(j) == ele) {
					count++;
					j++;
				}
				j--;
				current += (count) + "" + (ele);
			}
			prev = current;
			i++;
		}
		return current;
	}

}
