package array;

import java.util.ArrayList;
import java.util.Arrays;

public class prime_subarray {

	public static void main(String[] args) {
		ArrayList<Integer> arr = new ArrayList<>(Arrays.asList(1,2,3));
		System.out.println(solve(arr));
	}
	
	public static int solve(ArrayList<Integer> arr) {
		int l = arr.size();
		int mat[][] = new int[l][l], i;
		int count = 0;
		for(i = 0; i < l; i++) {
			mat[i][i] = arr.get(i);
			if(isPrime(mat[i][i]))
			count++;
		}
		for(i = 0; i < l; i++) {
			for(int j = i+1; j < l; j++) {
				mat[i][j] = mat[i][j-1] + arr.get(j);
				if(isPrime(mat[i][j]))
					count++;
			}
		}
		return count;
	}
	
	static boolean isPrime(int n){
	    if (n <= 1)
	        return false;
	    for (int i = 2; i < n; i++)
	        if (n % i == 0)
	            return false;
	    return true;
	}

}
