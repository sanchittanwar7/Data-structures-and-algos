package array;

public class IncreasingSubsequenceWithMaxProductOfSize3 {

	//8 9 5 1 10 3 12
	//6 1 2 3 19 10 7

	public static void main(String[] args) {
		int arr[] = CountFrequency.takeInput();
		int index[] = maxProduct(arr);
		for(int i : index)
			System.out.print(arr[i] + " ");
	}

	private static int[] maxProduct(int[] arr) {
		int lsl, lgr, product = Integer.MIN_VALUE, a, b;
		int ans[] = new int[3];
		for(int i = 1; i < arr.length - 1; i++){
			lsl = LSL(arr, 0, i-1, arr[i]);
			lgr = LGR(arr, i+1, arr.length-1, arr[i]);
			a = lsl == -1 ? 0 : arr[lsl];
			b = lgr == -1 ? 0 : arr[lgr];
			if(a*arr[i]*b > product){
				product = a*arr[i]*b;
				ans[0] = lsl;
				ans[1] = i;
				ans[2] = lgr;
			}
		}
		return ans;
	}

	private static int LGR(int[] arr, int start, int end, int num) {
		int max = Integer.MIN_VALUE, maxIndex = -1;
		for(int i = start; i <= end; i++){
			if(arr[i] > num && arr[i] > max){
				max = arr[i];
				maxIndex = i;
			}
		}
		return maxIndex;
	}

	private static int LSL(int[] arr, int start, int end, int num) {
		int max = Integer.MIN_VALUE, maxIndex = -1;
		for(int i = start; i <= end; i++){
			if(arr[i] < num && arr[i] > max){
				max = arr[i];
				maxIndex = i;
			}
		}
		return maxIndex;
	}

}
