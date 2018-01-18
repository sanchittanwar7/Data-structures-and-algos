package array;

import java.util.Arrays;
import java.util.Scanner;

public class ArrayCorrespondingToStrings {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		Scanner s = new Scanner(System.in);
		System.out.println("Enter string : ");
		String str = s.next();
		int ans[] = getArray(str);
		System.out.println("Equivalent array : " + Arrays.toString(ans));
	}

	private static int[] getArray(String str) {
		int ans[] = new int[str.length() + 1];
		int iCount = 0;
		for(int i = 0; i < str.length(); i++)
			if(str.charAt(i) == 'i')
				iCount++;
		int increaseValue = str.length() - iCount + 2;
		int startValue = str.length() - iCount + 1;
		int decreaseValue = str.length() - iCount;
		ans[0] = startValue;
		for(int i = 0; i < str.length(); i++){
			if(str.charAt(i) == 'i'){
				ans[i+1] = increaseValue;
				increaseValue++;
			}
			else{
				ans[i+1] = decreaseValue;
				decreaseValue--;
			}
		}
		return ans;
	}

}
