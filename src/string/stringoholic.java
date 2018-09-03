package string;

import java.util.ArrayList;
import java.util.Arrays;

public class stringoholic {
	
	public static final long M = 1000000007;

	public static void main(String[] args) {
		ArrayList<String> a = new ArrayList<>(Arrays.asList("a", "ababa", "aba"));
		System.out.println(solve(a));
	}
	
	public static int solve(ArrayList<String> a) {
		int i, inc;
		int arr[] = new int[a.size()];
		int index = 0;
		for(String str : a) {
			String s = new String(str);
			inc = 1;
			i = 1;
			int count = 1;
			while(str.length() != 1) {
				s = s.substring(inc) + s.substring(0, inc);
//				System.out.println(str + "------" + s);
				inc = (inc+1)%str.length();
//				i = (i + inc)%str.length();
				count++;
				if(s.equals(str)) {
					count--;
					break;
				}
			}
//			System.out.println(count);
			arr[index] = count;
			index++;
		}
		return (int) lcm_of_array_elements(arr);
    }
	
	public static long lcm_of_array_elements(int[] element_array) {
        long lcm_of_array_elements = 1;
        int divisor = 2;
        while (true) {
            int counter = 0;
            boolean divisible = false;
            for (int i = 0; i < element_array.length; i++) {
                if (element_array[i] == 0) {
                    return 0;
                }
                else if (element_array[i] < 0) {
                    element_array[i] = element_array[i] * (-1);
                }
                if (element_array[i] == 1) {
                    counter++;
                }
                if (element_array[i] % divisor == 0) {
                    divisible = true;
                    element_array[i] = element_array[i] / divisor;
                }
            }
            if (divisible) {
                lcm_of_array_elements = (lcm_of_array_elements * divisor)%M;
            }
            else {
                divisor++;
            }
            if (counter == element_array.length) {
                return lcm_of_array_elements;
            }
        }
    }

}
