package recursion;

import java.util.Scanner;

public class permutation_II {
	
	static int ans;
	
	static void combinationUtil(int arr[], int n, int r, int index, int data[], int i){
		if (index == r) {
			int gcd = data[0];
			int sum = data[0];
			for (int j = 1; j < r; j++) {
				gcd = gcd(gcd, data[j]);
				sum += data[j];
			}
			ans = (ans + sum * gcd)%998244353;
			return;
		}
		if (i >= n)
			return;
		data[index] = arr[i];
		combinationUtil(arr, n, r, index + 1, data, i + 1);
		combinationUtil(arr, n, r, index, data, i + 1);
	}
	static void printCombination(int arr[], int n, int r){
		int data[] = new int[r];
		combinationUtil(arr, n, r, 0, data, 0);
	}
	
	static int findGCD(int arr[], int n){
	    int result = arr[0];
	    for (int i = 1; i < n; i++)
	        result = gcd(arr[i], result);
	    return result;
	}
	
	static int gcd(int a, int b){
		if(a == 0 || b == 0)
			return a == 0 ? b : a;
		while (a != b){
			if (a > b)        
				a = a - b;        
			else      
				b = b - a;        
		}
		return a;
	}

	public static void main(String[] args){
		Scanner s = new Scanner(System.in);
		int n = s.nextInt();
		int k = s.nextInt();
		int arr[] = new int[n];
		for(int i = 0; i < n; i++)
			arr[i] = s.nextInt();
		printCombination(arr, n, k);
		System.out.println(ans);
	}

}
