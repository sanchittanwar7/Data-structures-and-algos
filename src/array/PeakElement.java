package array;

public class PeakElement {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		int arr[] = CountFrequency.takeInput();
		System.out.println(peak(arr));
	}

	private static int peak(int[] arr) {
		int start, end,mid;
		start = 0;
		end = arr.length - 1;
		mid = (start + end)/2;
		while(start <= end){
			mid = (start + end) / 2;

			if ((mid == 0 || arr[mid - 1] <= arr[mid]) && (mid == arr.length - 1 || arr[mid] >= arr[mid + 1])) 
				return arr[mid];
			else if (mid > 0 && arr[mid - 1] > arr[mid]) 
				end = mid - 1;
			else
				start = mid + 1;
		}
		return -1;
	}

}