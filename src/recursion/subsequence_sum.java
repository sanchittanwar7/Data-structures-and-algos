package recursion;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Scanner;

//998244353

class answer{
	ArrayList<Integer> subs;
	int sum;
	int gcd;
	
	answer(){
		subs = new ArrayList<>();
		sum = 0;
		gcd = 0;
	}
}

public class subsequence_sum {

	public static void main(String[] args) {
		Scanner s = new Scanner(System.in);
		int n = s.nextInt();
		int k = s.nextInt();
		int arr[] = new int[n];
		for(int i = 0; i < n; i++)
			arr[i] = s.nextInt();
		long num, sum = 0;
		ArrayList<answer> ans = subs(arr, k);
		for(answer row : ans) {
			System.out.println(row.subs + " " +row.sum+ " " + row.gcd);
			num = row.sum * row.gcd;
			sum += num;
		}
		System.out.println(sum%99244353);
	}
	
	static int gcd(int a, int b)
    {
        if (a == 0)
            return b;
        return gcd(b % a, a);
    }

	private static ArrayList<answer> subs(int[] arr, int n) {
		if(n == 1) {
			ArrayList<answer> ans = new ArrayList<>();;
			for(int i = 0; i < arr.length; i++) {
				answer obj = new answer();
				obj.subs = new ArrayList<>(Arrays.asList(arr[i]));
				obj.sum = arr[i];
				obj.gcd = arr[i];
				ans.add(obj);
			}
			return ans;
		}
		ArrayList<answer> ans = new ArrayList<>();
		ArrayList<Integer> modify;
		for(int k = 1; k < arr.length; k++) {
			ArrayList<answer> temp1 = subs(Arrays.copyOfRange(arr, k, arr.length), n-1);
			for(int i = 0; i < temp1.size(); i++) {
				modify = temp1.get(i).subs;
				modify.add(0, arr[0]);
				answer obj = new answer();
				obj.subs = modify;
				obj.sum = temp1.get(i).sum + arr[0];
				obj.gcd = gcd(temp1.get(i).gcd, arr[0]);
				if(!ans.contains(obj))
					ans.add(obj);
			}
		}
		return ans;
	}

}
