package array;

import java.util.HashMap;
import java.util.Scanner;

public class array_manipulation {

	static long arrayManipulation(int n, int[][] queries) {
    	HashMap<Integer, Long> val = new HashMap<>();
    	long inc, max = Long.MIN_VALUE;
    	for(int i = 0; i < queries.length; i++) {
    		for(int j = queries[i][0]; j <= queries[i][1]; j++) {
    			if(val.containsKey(j)) {
    				inc = queries[i][2] + val.get(j);
    				val.put(j, inc);
    			}
    			else {
    				inc = queries[i][2];
    				val.put(j, inc);
    			}
    			if(inc > max)
    				max = inc;
    		}
    	}
    	return max;
    }

    public static void main(String[] args){
        Scanner s = new Scanner(System.in);
        int n = s.nextInt();
        int m = s.nextInt();
        int queries[][] = new int[m][3];
        for(int i = 0; i < m; i++)
        	for(int j = 0; j < 3; j++)
        		queries[i][j] = s.nextInt();
        System.out.println(arrayManipulation(n, queries));
    }
}
