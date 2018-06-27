package array;

import java.util.ArrayList;
import java.util.Collections;

public class prettyPrint {

	public static void main(String[] args) {
		int n = 4;
		ArrayList<ArrayList<Integer>> ans = prettyPrint(n);
		for(ArrayList<Integer> answer : ans)
			System.out.println(answer);
	}
	
	public static ArrayList<ArrayList<Integer>> prettyPrint(int n) {
		int i, tick = 0, tock = 0, j, ele;
		ArrayList<ArrayList<Integer>> ans = new ArrayList<ArrayList<Integer>>();
		for(i = 0; i < 2*n-1; i++)
			ans.add(i, new ArrayList<Integer>(Collections.nCopies(2*n-1, 0)));
		for(i = 0; i < n; i++) {
			tick = tock;
			ele = n;
			for(j = 0 ; j < n; j++) {
				ans.get(i).set(j, ele);
				ans.get(i).set(2*n-2-j, ele);
				if(tick > 0) {
					ele--;
					tick--;
				}
			}
			tock++;
		}
		tock--;
		for(; i < 2*n-1; i++) {
			tock--;
			tick = tock;
			ele = n;
			for(j = 0 ; j < n; j++) {
				ans.get(i).set(j, ele);
				ans.get(i).set(2*n-2-j, ele);
				if(tick > 0) {
					ele--;
					tick--;
				}
			}
		}
		return ans;
    }

}
