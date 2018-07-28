package stacks_and_queues;

import java.util.Stack;

public class redundant_brackets {

	public static void main(String[] args) {
		String str = "";
		System.out.println(checkRedundancy(str));
	}

	private static int checkRedundancy(String str) {
		Stack<Character> st = new Stack<>();
		char ch;
		boolean flag;
		for (int i = 0; i < str.length(); i++) {
			ch = str.charAt(i);
			if (ch == ')') {
				char top = st.peek();
				st.pop();
				flag = true;
				while (top != '(') {
					if (top == '+' || top == '-' || top == '*' || top == '/')
						flag = false;
					top = st.peek();
					st.pop();
				}
				if (flag == true)
					return 1;
			}
			else
				st.push(ch);
		}
		return 0;
	}

}
