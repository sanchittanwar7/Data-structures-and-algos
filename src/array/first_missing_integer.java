package array;

import java.util.ArrayList;
import java.util.Arrays;

public class first_missing_integer {

	public static void main(String[] args) {
		ArrayList<Integer> arr = new ArrayList<Integer>(Arrays.asList(-8,-6,-7));
		System.out.println(firstMissingPositive(arr));
	}
	
	public static int firstMissingPositive(ArrayList<Integer> arr) {
		int i;
		for(i = 0; i < arr.size(); i++)
			if(arr.get(i) <= 0) {
				arr.remove(i);
				i--;
			}
		if(arr.size() == 0)
			return 1;
		for(i = 0; i < arr.size(); i++){
			if(Math.abs(arr.get(i)) - 1 < arr.size() && arr.get(Math.abs(arr.get(i)) - 1) > 0)
				arr.set(Math.abs(arr.get(i)) - 1, -arr.get(Math.abs(arr.get(i)) - 1));
		}
		for(i = 0; i < arr.size(); i++)
			if (arr.get(i) > 0)
			return i+1; 
		return arr.size()+1;
    }
}
