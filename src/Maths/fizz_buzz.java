package Maths;

import java.util.ArrayList;
import java.util.Arrays;

public class fizz_buzz {

	public static void main(String[] args) {
		int n = 20;
		ArrayList<String> ans = fizzBuzz(n);
		System.out.println(ans);
	}

	private static ArrayList<String> fizzBuzz(int n) {
		ArrayList<String> ans = new ArrayList<String>();
		for(int i = 1; i <= n; i++) {
			if(i%3 == 0 && i%5 == 0)
				ans.add("FizzBuzz");
			else if(i % 3 == 0)
				ans.add("Fizz");
			else if(i % 5 == 0)
				ans.add("Buzz");
			else
				ans.add(Integer.toString(i));
		}
		return ans;
	}

}
