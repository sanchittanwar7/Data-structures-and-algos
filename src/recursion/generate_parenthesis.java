package recursion;

import java.util.ArrayList;

public class generate_parenthesis {
	
	static ArrayList<String> ans;

	public static void main(String[] args) {
		int n = 0;
		ArrayList<String> str = generateParenthesis(n);
		for(String s : str)
			System.out.println(s);
	}
	
	public static ArrayList<String> generateParenthesis(int A) {
		ans = new ArrayList<>();
		generate("", A, 0);
		return ans;
    }

	private static void generate(String s, int leftToOpen, int leftToClose) {
		if(leftToOpen == 0) {
			for(int i = 0; i < leftToClose; i++)
				s += ')';
			ans.add(s);
			return;
		}
		generate(s + '(', leftToOpen - 1, leftToClose + 1);
		if(leftToClose != 0)
			generate(s + ')', leftToOpen, leftToClose - 1);
	}
	

}
