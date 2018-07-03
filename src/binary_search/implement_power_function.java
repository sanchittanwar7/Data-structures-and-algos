package binary_search;

public class implement_power_function {

	public static void main(String[] args) {
		int x = 71045970, n = 41535484, d = 64735492;
		System.out.println(pow(x,n,d));
	}

	private static int pow(int x, int n, int d) {
		if(n <= 1) {
			if(n == 0) {
				if(x == 0)
					return 0;
				return 1;
			}
			return x < 0 ? d + x%d : x%d;
		}
		long ans = pow(x,n/2,d);
		if(n%2 == 0)
			return (int) ((ans*ans)%d);
		int a = x < 0 ? d + x%d : x%d;
		return (int) ((a * ((ans * ans)%d))%d);
	}

}
