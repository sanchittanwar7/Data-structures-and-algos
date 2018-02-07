package dp;

import java.util.Arrays;

public class MaximumNumberOfAs {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		for(int i = 1; i < 21; i++)
			System.out.println(i + ": " + maxAs(i));
	}

	private static int maxAs(int n) {
		if(n < 7)
			return n;
		int screen[] = new int[n], current;
		for(int i = 0; i < 6; i++)
			screen[i] = i+1;
		for(int i = 6; i < n; i++){
			screen[i] = 0;
			for(int bp = i-3; bp >= 0; bp--){
				current = (i-bp-1)*screen[bp];
				if(current > screen[i])
					screen[i] = current;
			}
		}
		System.out.println(Arrays.toString(screen));
		return screen[n-1];
	}

}
