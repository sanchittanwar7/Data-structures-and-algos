package array;

public class PivotInSortedArray {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		int arr[] = CountFrequency.takeInput();
		System.out.println(pivot(arr));
	}

	private static int pivot(int[] arr) {
		int start, end,mid;
		start = 0;
		end = arr.length - 1;
		if(arr[start] < arr[end])
			return 0;
		while(start <= end){
			mid = (start + end)/2;
			if(mid < arr.length - 1 && arr[mid] > arr[mid+1])
				return mid+1;
			else if(arr[mid] > arr[start])
				start = mid + 1;
			else
				end = mid - 1;
		}
		return arr.length-1;
	}

}
