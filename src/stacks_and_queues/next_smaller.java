package stacks_and_queues;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.Stack;

class pair{
	int val;
	int index;
	pair(int val, int index){
		this.val = val;
		this.index = index;
	}
}

public class next_smaller {

	public static void main(String[] args) {
		ArrayList<Integer> arr = new ArrayList<>(Arrays.asList( 6 ,3 ,6 ,9 ,7 ,9 ,1 ,3 ,2 ,7 ));
		System.out.println(prevSmaller(arr));
	}
	
	public static ArrayList<Integer> prevSmaller(ArrayList<Integer> arr) {
		ArrayList<Integer> ans = new ArrayList<>(Collections.nCopies(arr.size(), 0));
		Stack<pair> s = new Stack<pair>();
		for(int i = arr.size()-1; i >= 0; i--){
			if(s.empty() || arr.get(i) > s.peek().val)
				s.push(new pair(arr.get(i), i));
			else{
				while(!s.empty() && arr.get(i) < s.peek().val){
//					System.out.println(s.peek().val + " " + arr.get(i));
					ans.set(s.peek().index, arr.get(i));
					s.pop();
				}
				s.push(new pair(arr.get(i), i));
			}
		}
		while(!s.empty()){
//			System.out.println(s.peek().val + " null");
			ans.set(s.peek().index, -1);
			s.pop();
		}
		return ans;
    }

}
