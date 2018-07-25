package Maths;

public class round_off {

	public static void main(String[] args) {
		int n = 142;
		System.out.println(roundOff(n));
	}

	private static int roundOff(int n) {
		if(n < 10)
			return 10;
		int rem = n%10;
		if(rem >= 5) {
			return (n/10 + 1)*10;
		}
		return n/10*10;
	}

}
