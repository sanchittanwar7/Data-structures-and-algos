package array;

public class MajorityElement {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		int arr[] = CountFrequency.takeInput();
		System.out.println(getMajority(arr));
	}

	private static Integer getMajority(int[] arr) {
		int candidate = getCandidate(arr);
		int count = 0;
		for(int i = 0; i < arr.length; i++){
			if(arr[i] == candidate)
				count++;
		}
		return count > arr.length/2 ? candidate : null;
	}

	private static int getCandidate(int[] arr) {
		int count = 1, index = 0;
		for(int i = 0; i < arr.length; i++){
			if(arr[i] == arr[index])
				count ++;
			else
				count --;
			if(count == 0){
				index = i;
				count = 1;
			}
		}
		return arr[index];
	}

}
