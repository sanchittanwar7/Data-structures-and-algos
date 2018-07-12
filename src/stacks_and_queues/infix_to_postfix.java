package stacks_and_queues;

import java.util.Stack;

public class infix_to_postfix {

	public static void main(String[] args) {
		String s = "(a+b+c)/d";
		System.out.println(toPostfix(s));
	}

	private static String toPostfix(String s) {
		String ans = "";
		Stack<Character> stk = new Stack<>();
		stk.push('_');
		char ele;
		for(int i = 0; i < s.length(); i++) {
			if(isOperator(s.charAt(i))) {
				if(s.charAt(i) == ')') {
					while(stk.peek() != '(') {
						ele = stk.pop();
						ans += ele;
					}
					stk.pop();
				}
				else if(s.charAt(i) == '(')
					stk.push('(');
				else {
					if(precedence(s.charAt(i)) > precedence(stk.peek())) {
						stk.push(s.charAt(i));
					}
					else {
						while(precedence(stk.peek()) >= precedence(s.charAt(i))) {
							ele = stk.pop();
							ans += ele;
						}
						stk.push(s.charAt(i));
					}
				}
			}
			else {
				ans += s.charAt(i);
			}
		}
		while(stk.size() > 1) {
			ans += stk.pop();
		}
		return ans;
	}

	private static int precedence(Character c) {
		switch(c) {
		case '-' : return 1;
		case '+' : return 2;
		case '*' : return 3;
		case '/' : return 4;
		case '^' : return 5;
		default : return 0;
		}
	}

	private static boolean isOperator(char c) {
		if(c == '+' || c == '-' || c == '*' || c == '/' || c == '(' || c == ')'|| c == '^')
			return true;
		return false;
	}

}
