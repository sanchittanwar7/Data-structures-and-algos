package array;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;

public class find_duplicates {

	public static void main(String[] args) {
		ArrayList<Integer> arr = new ArrayList<Integer>(Arrays.asList(3,4,1,4,1));
		System.out.println(repeatedNumber(arr));
	}
	
	public static int repeatedNumber(final List<Integer> arr) {
		HashMap<Integer, Boolean> map = new HashMap<Integer, Boolean>();
		for(Integer ele : arr) {
			if(map.containsKey(ele))
				return ele;
			map.put(ele, true);
		}
		return -1;
    }

}
