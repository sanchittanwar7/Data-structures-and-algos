package BitManipulation;

import java.util.ArrayList;

public class min_xor {

	public static void main(String[] args) {
		ArrayList<Integer> arr = new ArrayList<>();
		arr.add(0);
		arr.add(2);
		arr.add(5);
		arr.add(7);
		System.out.println(findMinXor(arr));
	}
	

	public static int findMinXor(ArrayList<Integer> arr) {
		int xor, i, j, ans = Integer.MAX_VALUE;
		for(i = 0; i < arr.size(); i++) {
			for(j = i+1; j < arr.size(); j++) {
				xor = arr.get(i)^arr.get(j);
				if(xor < ans)
					ans = xor;
			}
		}
		return ans;
    }
	
}
