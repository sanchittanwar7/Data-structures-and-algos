package two_pointers;

import java.util.ArrayList;
import java.util.Arrays;

public class container_with_max_water {

	public static void main(String[] args) {
		ArrayList<Integer> a = new ArrayList<>(Arrays.asList(1));
		System.out.println(maxArea(a));
	}
	
	public static int maxArea(ArrayList<Integer> a) {
		int i = 0, j = a.size()-1, area, maxArea = Integer.MIN_VALUE;
		while(i <= j) {
			area = Math.min(a.get(i), a.get(j)) * (j - i);
			if(area > maxArea) {
				maxArea = area;
			}
			if(a.get(i) < a.get(j))
				i++;
			else
				j--;
		}
		return maxArea;
    }

}
