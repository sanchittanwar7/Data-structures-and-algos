package stacks_and_queues;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.Stack;

public class largest_rectangle_in_histograph {

	public static void main(String[] args) {
		ArrayList<Integer> arr = new ArrayList<>(Arrays.asList(2,1,5,6,2,3));
		System.out.println(largestArea(arr));
	}
	
	public static int largestArea(ArrayList<Integer> arr) {
		int area, left, right, maxArea = Integer.MIN_VALUE, len = arr.size();
//		System.out.println(arr);
		ArrayList<Integer> prevSmaller = prevSmaller(arr);
		ArrayList<Integer> nextSmaller = nextSmaller(arr);
//		System.out.println(prevSmaller);
//		System.out.println(nextSmaller);
		for(int i = 0; i < arr.size(); i++) {
			left = prevSmaller.get(i);
			right = nextSmaller.get(i) == -1 ? len : nextSmaller.get(i);
			area = (right - left - 1) * arr.get(i);
			if(area > maxArea)
				maxArea = area;
		}
		return maxArea;
	}
	
	public static ArrayList<Integer> prevSmaller(ArrayList<Integer> arr) {
		ArrayList<Integer> ans = new ArrayList<>(Collections.nCopies(arr.size(), 0));
		Stack<pair> s = new Stack<pair>();
		for(int i = arr.size()-1; i >= 0; i--){
			if(s.empty() || arr.get(i) > s.peek().val)
				s.push(new pair(arr.get(i), i));
			else{
				while(!s.empty() && arr.get(i) < s.peek().val){
					ans.set(s.peek().index, i);
					s.pop();
				}
				s.push(new pair(arr.get(i), i));
			}
		}
		while(!s.empty()){
			ans.set(s.peek().index, -1);
			s.pop();
		}
		return ans;
    }
	
	public static ArrayList<Integer> nextSmaller(ArrayList<Integer> arr) {
		ArrayList<Integer> ans = new ArrayList<>(Collections.nCopies(arr.size(), 0));
		Stack<pair> s = new Stack<pair>();
		for(int i = 0; i < arr.size(); i++){
			if(s.empty() || arr.get(i) > s.peek().val)
				s.push(new pair(arr.get(i), i));
			else{
				while(!s.empty() && arr.get(i) < s.peek().val){
					ans.set(s.peek().index, i);
					s.pop();
				}
				s.push(new pair(arr.get(i), i));
			}
		}
		while(!s.empty()){
			ans.set(s.peek().index, -1);
			s.pop();
		}
		return ans;
    }

}
