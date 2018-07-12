package BitManipulation;

public class reverse_bits {

	public static void main(String[] args) {
		long n = 3;
		System.out.println(reverse(n));
		
	}
	
	public static long reverse(long n) {
		String s = Long.toBinaryString(n);
		int l = s.length();
		for(int i = 0; i < 32-l; i++) {
			s = "0" + s;
		}
		s = reverse(s);
		long pow = 0, ans = 0;
		for(int i = s.length()-1; i >= 0; i--) {
			if(s.charAt(i) == '1')
				ans += Math.pow(2, pow);
			pow++;
		}
		return ans;
    }

	private static String reverse(String s) {
		if(s.length() <= 1)
			return s;
		return reverse(s.substring(1)) + s.charAt(0);
	}

}
