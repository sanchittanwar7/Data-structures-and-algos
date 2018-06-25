package array;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;

public class repeat_and_missing_number {

	public static void main(String[] args) {
		ArrayList<Integer> arr = new ArrayList<Integer>(Arrays.asList(3,1,2,5,3));
		System.out.println(repeatedNumber1(arr));
		System.out.println(repeatedNumber(arr));
	}

	private static ArrayList<Integer> repeatedNumber1(ArrayList<Integer> arr) {
		HashMap<Integer, Integer> map = new HashMap<Integer, Integer>();
		int l = arr.size(), A = -1, B = -1;
		int oldValue;
		for(int i = 0; i < l; i++){
			if(map.containsKey(arr.get(i))){
				oldValue = map.get(arr.get(i));
				map.put(arr.get(i), oldValue + 1);
			}
			else{
				map.put(arr.get(i), 1);
			}
		}
		System.out.println(map);
		for(int i = 1; i <= l; i++){
			try {
				if(map.get(i) == 2)
					A = i;
			}
			catch(Exception e) {
				B = i;
			}
		}
		ArrayList<Integer> ans = new ArrayList<Integer>();
		ans.add(B);
		ans.add(0,A);
		return ans;
	}

	public static ArrayList<Integer> repeatedNumber(final ArrayList<Integer> arr) {
		int i, index, l = arr.size(), A = 0, B = 0;
		for(i = 0; i < arr.size(); i++)
			arr.set(i, arr.get(i) - 1);
//		System.out.println(arr);
		for(i = 0; i < arr.size(); i++) {
			index = arr.get(i)%l;
			arr.set(index, arr.get(index) + l);
		}
//		System.out.println(arr);
		for(i = 0; i < l; i++) {
			if(arr.get(i)/l == 2)
				A = i+1;
			if(arr.get(i)/l == 0)
				B = i+1;
		}
//		System.out.println(A + " " + B);
		ArrayList<Integer> ans = new ArrayList<Integer>();
		ans.add(B);
		ans.add(0,A);
		return ans;
    }

}
