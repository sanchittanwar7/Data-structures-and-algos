package array;

import java.util.HashMap;

public class CountFrequency2 {

	/* Time Complexity : O(n)
	 * Space Complexity : O(n)
	 */
	public static void main(String[] args) {
		int arr[] = CountFrequency.takeInput();
		countFrequency(arr);
	}

	private static void countFrequency(int[] arr) {
		HashMap<Integer, Integer> map = new HashMap<Integer, Integer>();
		int oldValue;
		for(int i = 0; i < arr.length; i++){
			if(map.containsKey(arr[i])){
				oldValue = map.get(arr[i]);
				map.put(arr[i], oldValue + 1);
			}
			else{
				map.put(arr[i], 1);
			}
		}
		
		for(int i = 1; i <= arr.length; i++){
			if(map.containsKey(i))
				System.out.println(i + " " + map.get(i));
			else
				System.out.println(i + " 0" );
		}
	}

}
