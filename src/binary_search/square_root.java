package binary_search;

public class square_root {

	public static void main(String[] args) {
		int n = 2;
		System.out.println(sqrt(n));
	}

	private static int sqrt(int n) {
		int start = 0, end = n;
		long mid = (start + end)/2;
		while(start != mid && mid*mid != n) {
			if(mid*mid > n)
				end = (int) mid;
			else
				start = (int) mid;
			mid = (start+end)/2;
		}
		return (int) mid;
	}

}
