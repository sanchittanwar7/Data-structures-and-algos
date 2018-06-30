package array;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.Stack;

public class max_special_product {

	public static void main(String[] args) {
		ArrayList<Integer> arr = new ArrayList<Integer>(Arrays.asList(11, 12, 17, 13, 14, 15, 14, 18, 19, 10));
		ArrayList<Integer> arr1 = new ArrayList<Integer>(Arrays.asList(5, 9, 6, 8, 6, 4, 6, 9, 5, 4, 9));
		System.out.println(maxSpecialProduct(arr));
	}

	private static int maxSpecialProduct(ArrayList<Integer> arr) {
		HashMap<Integer, Integer> nextLargest = nextLargest(arr);
		HashMap<Integer, Integer> prevLargest = prevLargest(arr);
		System.out.println(nextLargest);
		System.out.println(prevLargest);
		long maxProd = 0, prod;
		for(int i = 0; i < arr.size(); i++) {
			if(nextLargest.get(i) != 0 && prevLargest.get(i) != 0) {
				prod = nextLargest.get(i) * prevLargest.get(i);
				if(prod > maxProd)
					maxProd = prod;
			}
		}
		return (int) (maxProd%1000000007);
	}

	private static HashMap<Integer, Integer> nextLargest(ArrayList<Integer> arr) {
		Stack<Integer> s = new Stack<Integer>();
		Stack<Integer> index = new Stack<Integer>();
		HashMap<Integer, Integer> nextLargest = new HashMap<Integer, Integer>();
		for(int i = 0; i < arr.size(); i++){
			if(s.empty() || arr.get(i) < s.peek()) {
				s.push(arr.get(i));
				index.push(i);
			}
			else{
				while(!s.empty() && arr.get(i) > s.peek()){
					nextLargest.put(index.peek(), i);
					//					System.out.println(s.peek() + " " + arr.get(i));
					s.pop();
					index.pop();
				}
				s.push(arr.get(i));
				index.push(i);
			}
		}
		while(!s.empty()){
			//			System.out.println(s.peek() + " null");
			nextLargest.put(index.peek(), 0);
			s.pop();
			index.pop();
		}
		return nextLargest;
	}

	private static HashMap<Integer, Integer> prevLargest(ArrayList<Integer> arr) {
		Stack<Integer> s = new Stack<Integer>();
		HashMap<Integer, Integer> prevLargest = new HashMap<Integer, Integer>();
		Stack<Integer> index = new Stack<Integer>();
		for(int i = arr.size()-1; i >= 0; i--){
			if(s.empty() || arr.get(i) < s.peek()) {
				s.push(arr.get(i));
				index.push(i);
			}
			else{
				while(!s.empty() && arr.get(i) > s.peek()){
					prevLargest.put(index.peek(), i);
					//					System.out.println(s.peek() + " " + arr.get(i));
					s.pop();
					index.pop();
				}
				s.push(arr.get(i));
				index.push(i);
			}
		}
		while(!s.empty()){
			//			System.out.println(s.peek() + " null");
			prevLargest.put(index.peek(), 0);
			s.pop();
			index.pop();
		}
		return prevLargest;
	}

}
