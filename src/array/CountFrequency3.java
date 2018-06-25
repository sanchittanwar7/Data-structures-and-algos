package array;

import java.util.Arrays;

public class CountFrequency3 {

	/* Time Complexity : O(n)
	 * Space Complexity : O(1)
	 */
	public static void main(String[] args) {
		int arr[] = CountFrequency.takeInput();
		int n = arr.length;
		for(int i = 0; i < n; i++)
			arr[i] -= 1;
		System.out.println(Arrays.toString(arr));
		for(int i = 0; i < n; i++)
			arr[arr[i]%n] += n;
		System.out.println(Arrays.toString(arr));

		for(int i = 0; i < n; i++)
			System.out.println(i+1 + " " + arr[i]/n);
		for(int i = 0; i < n; i++)
			arr[i] = arr[i]%n + 1;
	}

}
