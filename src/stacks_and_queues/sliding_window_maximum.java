package stacks_and_queues;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.Deque;
import java.util.LinkedList;
import java.util.List;
import java.util.PriorityQueue;
import java.util.Queue;
import java.util.Stack;

class maXStack {
    Stack<Integer> st = new Stack<>();
    Stack<Integer> maxSt = new Stack<>();
    public void push(int x) {
       st.push(x);
       int max = maxSt.isEmpty() ? x : maxSt.peek();
       maxSt.push(max > x ? max : x);    
    }

    public void pop() {
        if(st.size() != 0){
            st.pop();
            maxSt.pop();
        }
    }

    public int top() {
        if(st.size() == 0){
            return -1;
        }
        return st.peek();
    }

    public int getMax() {
        if(maxSt.size() == 0){
            return -1;
        }
        return maxSt.peek();
    }

}

public class sliding_window_maximum {

	public static void main(String[] args) {
		List<Integer> arr = new ArrayList<>(Arrays.asList(1 , 3, -1, -3, 5, 3, 6, 7));
		int n = 3;
		System.out.println(slidingMaximum(arr, n));
		System.out.println(sliding(arr, n));
	}
	
	
	private static ArrayList<Integer> sliding(List<Integer> arr, int n) {
		Deque<Integer> Qi = new LinkedList<Integer>();
		ArrayList<Integer> ans = new ArrayList<>();
        int i;
        for(i = 0; i < n; ++i) {
            while(!Qi.isEmpty() && arr.get(i) >= arr.get(Qi.peekLast()))
                Qi.removeLast();   // Remove from rear
            Qi.addLast(i);
        }
        for( ;i < arr.size(); ++i){
        	ans.add(arr.get(Qi.peek()));
            while((!Qi.isEmpty()) && Qi.peek() <= i-n)
                Qi.removeFirst();
            while((!Qi.isEmpty()) && arr.get(i) >= arr.get(Qi.peekLast()))
                Qi.removeLast();
            Qi.addLast(i);
        }
        ans.add(arr.get(Qi.peek()));
        return ans;
	}


	public static ArrayList<Integer> slidingMaximum(final List<Integer> arr, int n) {
		maXStack max = new maXStack();
		int i = 0;
		ArrayList<Integer> ans = new ArrayList<>();
		for(; i < n; i++)
			max.push(arr.get(i));
		ans.add(max.getMax());
		for(; i < arr.size(); i++) {
			max.pop();
			max.push(arr.get(i));
			ans.add(max.getMax());
		}
		return ans;
	}

}
