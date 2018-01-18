package array;

public class BuySellStock {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		int arr[] = {100, 80, 120, 130, 70, 60, 100, 125};
		System.out.println("Max profit : " + maxProfit(arr));
	}

	private static int maxProfit(int[] arr) {
		int smallest = arr[0], profit = Integer.MIN_VALUE;
		for(int i = 1; i < arr.length; i++){
			if(arr[i] < smallest)
				smallest = arr[i];
			else if(profit < arr[i] - smallest)
				profit = arr[i] - smallest;
		}
		return profit;
	}

}
