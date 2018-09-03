package stacks_and_queues;

import java.util.ArrayList;
import java.util.Scanner;

public class nissan_stack_n_queue {

	public static void main(String[] args) {
		Scanner s = new Scanner(System.in);
		int n = s.nextInt();
		int k = s.nextInt();
		int arr[] = new int[n];
		for(int i = 0; i < n; i++)
			arr[i] = s.nextInt();
		System.out.println(calc(arr, k));
	}

	private static long calc(int[] arr, int k) {
		Long sum1 = (long) 0, sum2 = (long) 0;
		int n = arr.length, i;
		ArrayList<Long> s = new ArrayList<>(), q = new ArrayList<>();
		for(i = 0; i < k-1; i++) {
			sum2 += arr[n - i - 1];
			sum1 += arr[i];
			s.add(sum1);
			q.add(0, sum2);
		}
		long max = Long.MIN_VALUE;
		for(i = 0; i < s.size(); i++)
			if(s.get(i) + q.get(i) > max)
				max = s.get(i) + q.get(i);
		return max;
	}

}
