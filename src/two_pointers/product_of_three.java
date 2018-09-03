package two_pointers;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.Scanner;
import java.util.TreeSet;

public class product_of_three {

	public static void main(String[] args) {
		Scanner s = new Scanner(System.in);
		int n = s.nextInt();
		int x = s.nextInt();
		ArrayList<Integer> arr = new ArrayList<>();
		for(int i = 0; i < n; i++)
			arr.add(s.nextInt());
		System.out.println(threeSum(arr, x));
	}
	
	public static long threeSum(ArrayList<Integer> arr, int x) {
		int sum, i, j, k, first;
		long count = 0;
		Collections.sort(arr);
		System.out.println(arr);
        TreeSet<String> set = new TreeSet<String>();
		ArrayList<ArrayList<Integer>> ans = new ArrayList<ArrayList<Integer>>();
		for(i = 0; i < arr.size(); i++) {
			j = i+1;
			k = arr.size()-1;
			first = arr.get(i);
			while(j < k) {
				sum = first * arr.get(j) * arr.get(k);
				if(sum == x) {
					String str = first + ":" + arr.get(j) + ":" + arr.get(k);
                    if (!set.contains(str)) {
                        ans.add(new ArrayList<>(Arrays.asList(first, arr.get(j), arr.get(k))));
                        set.add(str);
                        count++;
                    }
                    j++;
                    k--;
				}
				else if(sum < 0)
					j++;
				else
					k--;
			}
		}
		return count;
    }

}
