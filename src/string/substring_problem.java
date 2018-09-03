package string;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class substring_problem {

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		String a = br.readLine();
		String b = br.readLine();
		String s = br.readLine();
		long count = 0;
		String t;
		for (int i = 0; i < s.length(); i++) {
			for (int j = i+1; j <= s.length(); j++) {
				t = s.substring(i, j);
				if(t.contains(a) && t.contains(b))
					count++;
			}
		}
		System.out.println(count);
	}
}
