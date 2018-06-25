package array;

import java.util.ArrayList;
import java.util.Arrays;

public class addOneToNumber {

	public static void main(String[] args) {
		ArrayList<Integer> arr = new ArrayList<Integer>(Arrays.asList(0, 2, 1));
		arr = plusOne(arr);
		System.out.println(arr);
	}
	
	public static ArrayList<Integer> plusOne(ArrayList<Integer> arr) {
		ArrayList<Integer> ans = new ArrayList<Integer>();
		int carry = 1;
		for(int i = arr.size() - 1; i >= 0; i--) {
			ans.add(0, (arr.get(i) + carry)%10);
			carry = (arr.get(i) + carry)/10;
		}
		if(carry != 0)
			ans.add(0, carry);
		while(ans.get(0) == 0)
			ans = new ArrayList<Integer>(ans.subList(1, ans.size()));
		return ans;
    }

}
