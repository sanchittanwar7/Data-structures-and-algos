package array;

public class LeaderInArray {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		int arr[] = CountFrequency.takeInput();
		leaders(arr);
	}

	private static void leaders(int[] arr) {
		int leader = Integer.MIN_VALUE;
		for(int i = arr.length-1; i >= 0; i--){
			if(arr[i] > leader){
				System.out.print(arr[i] + " ");
				leader = arr[i];
			}
		}
	}

}
