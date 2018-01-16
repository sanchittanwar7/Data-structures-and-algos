package array;

import java.util.Scanner;

public class FibonacciNumber {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		Scanner s = new Scanner(System.in);
		System.out.println("Enter n : ");
		int n = s.nextInt();
		System.out.println(fibo(n));
	}

	private static int fibo(int n) {
		if(n == 1)
			return 0;
		if(n == 2)
			return 1;
		int a = 0, b = 1, c = 0;
		while(n-3 >= 0){
			c = a+b;
			a = b;
			b = c;
			n--;
		}
		return c;
	}

}
