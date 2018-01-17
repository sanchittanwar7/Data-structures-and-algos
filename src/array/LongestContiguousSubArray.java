package array;

class pair{
	int start;
	int end;
	
	pair(int start, int end){
		this.start = start;
		this.end = end;
	}
}

//10 12 11 94 56 32 34 36 33 35 37

public class LongestContiguousSubArray {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		int arr[] = CountFrequency.takeInput();
		pair ans = contiguousSequence(arr);
		if(ans == null)
			System.out.println("From index 0 to 0");
		else
			System.out.println("From index " + ans.start + " to " + ans.end);
	}

	private static pair contiguousSequence(int[] arr) {
		int max, min, maxLength = Integer.MIN_VALUE;
		pair ans = null;
		for(int i = 0; i < arr.length; i++){
			max = Integer.MIN_VALUE;
			min = Integer.MAX_VALUE;
			for(int j = i; j < arr.length; j++){
				if(arr[j] > max)
					max = arr[j];
				if(arr[j] < min)
					min = arr[j];
				if(max - min == j - i && max - min > maxLength){
					maxLength = j - i;
					ans = new pair(i, j);
				}
			}
		}
		return ans;
	}

}
