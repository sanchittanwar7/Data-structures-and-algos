package string;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class kth_character {

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		char s[] = br.readLine().toCharArray();
		char min = s[s.length - 1], ans = min;
		for(int i = s.length - 2; i >= 0; i--) {
			if(s[i] <= min)
				min = s[i];
			else
				ans = s[i];
		}
		String str = String.valueOf(s);
		str = str.replaceAll(""+ans, "");
		System.out.println(str);
	}
}
