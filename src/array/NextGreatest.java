package array;

import java.util.Stack;

public class NextGreatest {

	/**
	 * @param args
	 */
	
	//98 23 54 12 20 7 27
	public static void main(String[] args) {
		int arr[] = CountFrequency.takeInput();
		nextLargest(arr);
	}

	private static void nextLargest(int[] arr) {
		Stack<Integer> s = new Stack<Integer>();
		for(int i = 0; i < arr.length; i++){
			if(s.empty() || arr[i] < s.peek())
				s.push(arr[i]);
			else{
				while(!s.empty() && arr[i] > s.peek()){
					System.out.println(s.peek() + " " + arr[i]);
					s.pop();
				}
				s.push(arr[i]);
			}
		}
		while(!s.empty()){
			System.out.println(s.peek() + " null");
			s.pop();
		}
	}

}
