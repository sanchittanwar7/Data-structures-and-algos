package string;

import java.math.BigInteger;

public class power_of_two {

	public static void main(String[] args) {
		String s = "36893488150000000000";
		System.out.println(power(s));
	}

	private static int power(String s) {
		BigInteger b = new BigInteger(s);
		BigInteger two = new BigInteger("2");
		BigInteger zero = new BigInteger("0");
		BigInteger mod;
		while(b.compareTo(two) != 0) {
			mod = b.mod(two);
			System.out.println( "B : " + b + " mod : " + mod);
			if(mod.compareTo(zero) != 0)
				return 0;
			b = b.divide(two);
		}
		return 1;
	}

}
