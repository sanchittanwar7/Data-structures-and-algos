package Maths;

public class power_of_two_integers {

	public static void main(String[] args) {
		int n = 536870912;
		System.out.println(isPower(n));
	}

	private static int isPower(int n) {
		double p;
		if(n == 1)
			return 1;
		for(int i = 1; i <= 1000; i++) {
			p = Math.log(n)/Math.log(i);
			System.out.println(i + " " + p);
			if(p == (int)p)
				return 1;
		}
		return 0;
	}

}
