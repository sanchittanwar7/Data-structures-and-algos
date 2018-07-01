package Maths;

public class largest_coprime_divisor {

	public static void main(String[] args) {
		int i = 34, j = 765;
		System.out.println(cpFact(i, j));
	}
	
	static int gcd(int a, int b){
		if (b==0) 
			return a;
		return gcd(b,a%b);
	}

	private static int cpFact(int n1, int n2) {
		double i = 1, x;
		for( ; i <= n1; i++) {
			x = n1/i;
			if(x == (int)x) {
				if(gcd((int)x,n2) == 1)
					return (int) x;
			}
		}
		return 1;
	}

}
