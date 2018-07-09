package BitManipulation;

public class number_of_ones {

	public static void main(String[] args) {
		long n = 11;
		System.out.println(numSetBits(n));
	}
	
	public static int numSetBits(long n) {
		String s = Long.toBinaryString(n);
		int count = 0;
		for(int i = 0; i < s.length(); i++)
			if(s.charAt(i) == '1')
				count++;
		return count;
    }

}
