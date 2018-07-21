package dp;

import java.util.Arrays;


//Imagine you have a special keyboard with the following keys: 
//Key 1:  Prints 'A' on screen
//Key 2: (Ctrl-A): Select screen
//Key 3: (Ctrl-C): Copy selection to buffer
//Key 4: (Ctrl-V): Print buffer on screen appending it
//                 after what has already been printed. 
//
//If you can only press the keyboard for N times (with the above four
//keys), write a program to produce maximum numbers of A's. That is to
//say, the input parameter is N (No. of keys that you can press), the 
//output is M (No. of As that you can produce).


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
