package string;

import java.util.Stack;

public class BalancedParenthesis {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		String str = "[()]{}{[()()]()}";
		String str1 = "[(])";
		System.out.println(isBalanced(str1));
	}

	private static boolean isBalanced(String str) {
		Stack<Character> s = new Stack<Character>();
		for(int i = 0; i < str.length(); i++){
			if(!isClosing(str.charAt(i)))
				s.push(str.charAt(i));
			else{
				if(s.peek() == compliment(str.charAt(i)))
					s.pop();
				else
					return false;
			}
		}
		return s.isEmpty();
	}

	private static char compliment(Character c) {
		if(c == ')')
			return '(';
		else if(c == '}')
			return '{';
		return '[';
	}

	private static boolean isClosing(char c) {
		return (c == ')' || c == '}' || c == ']');
	}

}
