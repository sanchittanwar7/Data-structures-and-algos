package tree;

public class CheckIdentical {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		int arr1[] = {3,5,4,6,1,0,2};
		int arr2[] = {3,1,5,2,4,6,0};
		System.out.println(checkIdentical(arr1, arr2, 0, 0, Integer.MIN_VALUE, Integer.MAX_VALUE));
	}

	private static boolean checkIdentical(int[] arr1, int[] arr2, int index1, int index2,int min, int max) {
		int i, j;
		for(i = index1; i < arr1.length; i++){
			if(arr1[i] > min && arr1[i] < max)
				break;
		}
		for(j = index2; j < arr2.length; j++){
			if(arr2[j] > min && arr2[j] < max)
				break;
		}
		if(i == arr1.length || j == arr2.length){
			if(i == arr1.length && j == arr2.length)
				return true;
			return false;
		}
		if(arr1[i] == arr2[j])
			return checkIdentical(arr1, arr2, i+1, j+1, min, arr1[i]) && checkIdentical(arr1, arr2, i+1, j+1, arr1[i], max);
		return false;
	}

}
