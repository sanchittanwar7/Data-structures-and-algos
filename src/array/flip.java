package array;

import java.util.ArrayList;
import java.util.Arrays;

public class flip {

	public static void main(String[] args) {
		String str = "111";
		ArrayList<Integer> ans = flip(str);
		System.out.println(ans);
	}

	private static ArrayList<Integer> flip(String A) {
		int i,j, len = A.length(), finalsum = 0, sum = 0;
	    ArrayList<Integer> res = new ArrayList<Integer>(Arrays.asList(-1,-1));
	    int start, end;
		start = end = 0;
	    
	    for (i = 0; i < len; i++) {
	        if (A.charAt(i) == '0')
	            sum += 1;
	        else 
	            sum -= 1;
	        
	        if (sum < 0) {
	            sum = 0;
	            start = i+1;
	        }
	        
	        if (sum > finalsum) {
	            finalsum = sum;
	            res.set(0, start);
	            end = i;
	            res.set(1,end);
	        }
	    }
	    
	    if (res.get(0) != -1 && res.get(1) != -1) {
	    	res.set(0,res.get(0) + 1);
	    	res.set(1,res.get(1) + 1);
		    return res;
	    }
	    return new ArrayList<Integer>();
	}

}
