package recursion;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Scanner;

class ans{
	int[] arr;
	long sum;
	long gcd;
}

public class test_aexp {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int n = sc.nextInt();
		int k = sc.nextInt();
		int input[] = new int[n];
		for(int i = 0; i < n; i++)
			input[i] = sc.nextInt();
		long ans = 0;   
		ans obj;
		List<int[]> subsets = new ArrayList<>();
		int[] s = new int[k];                 
		if (k <= input.length) {
			for (int i = 0; (s[i] = i) < k - 1; i++);  
			obj = getSubset(input, s);
			ans = ans + obj.sum * obj.gcd;
			subsets.add(obj.arr);
			for(;;) {
				int i;
				for (i = k - 1; i >= 0 && s[i] == input.length - k + i; i--); 
				if (i < 0) {
					break;
				}
				s[i]++;                    
				for (++i; i < k; i++) {  
					s[i] = s[i - 1] + 1; 
				}
				obj = getSubset(input, s);
				ans = ans + obj.sum * obj.gcd;
				subsets.add(obj.arr);
			}
		}
		System.out.println(ans);
	}

	private static long sum(int[] row) {
		long sum = 0;
		for(int ele : row)
			sum += ele;
		return sum;
	}

	static long findGCD(int arr[], int n){
		long result = arr[0];
		for (int i = 1; i < n; i++)
			result = gcd(arr[i], (int) result);
		return result;
	}

	static long gcd(int a, int b){
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


	static ans getSubset(int[] input, int[] subset) {
		ans obj = new ans();
		obj.arr = new int[subset.length]; 
		long sum = 0, gcd = 0;
		for (int i = 0; i < subset.length; i++) {
			obj.arr[i] = input[subset[i]];
			sum += obj.arr[i];
			gcd = gcd((int) gcd, obj.arr[i]);
		}
		obj.sum = sum;
		obj.gcd = gcd;
//		System.out.println(Arrays.toString(obj.arr) + " " + obj.sum + " " + obj.gcd );
		return obj;
	}

}
