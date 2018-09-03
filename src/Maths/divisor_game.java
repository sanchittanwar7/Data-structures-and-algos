package Maths;

public class divisor_game {

	public static void main(String[] args) {
		int a = 12, b = 3, c = 2;
		System.out.println(solve(a, b, c));

	}
	
	public static int solve(int a, int b, int c) {
		int lcm = lcm(b, c);
		return a / lcm;
    }

	public static int lcm(int n, int m) {
		int lcm = (n == m || n == 1) ? m :(m == 1 ? n : 0);
		if (lcm == 0) {
			int mm = m, nn = n;
			while (mm != nn) {
				while (mm < nn) { mm += m; }
				while (nn < mm) { nn += n; }
			}  
			lcm = mm;
		}
		return lcm;
	}

}
