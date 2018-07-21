package stacks_and_queues;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Stack;

public class evaluate_expression {

	public static void main(String[] args) {
		ArrayList<String> a1 = new ArrayList<>(Arrays.asList("2", "1", "+", "3", "*"));
		ArrayList<String> a2 = new ArrayList<>(Arrays.asList("4", "13", "5", "/", "+"));
		System.out.println(evalRPN(a1));
		System.out.println(evalRPN(a2));
	}
	
	public static int evalRPN(ArrayList<String> a) {
		Stack<String> s = new Stack<>();
		for(String str : a) {
			if(isOperand(str))
				s.push(str);
			else {
				s.push(eval(s.pop(), s.pop(), str));
			}
		}
		return Integer.parseInt(s.peek());
	}

	private static String eval(String pop, String pop2, String str) {
		int op1 = Integer.parseInt(pop2);
		int op2 = Integer.parseInt(pop);
		switch(str) {
			case "+" : return Integer.toString(op1 + op2);
			case "-" : return Integer.toString(op1 - op2);
			case "*" : return Integer.toString(op1 * op2);
			case "/" : return Integer.toString(op1 / op2);
		}
		return "";
	}

	private static boolean isOperand(String str) {
		try {
			Integer.parseInt(str);
			return true;
		}
		catch(Exception e) {
			return false;
		}
	}

}
