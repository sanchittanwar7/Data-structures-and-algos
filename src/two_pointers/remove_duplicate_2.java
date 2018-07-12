package two_pointers;

import java.util.ArrayList;
import java.util.Arrays;

public class remove_duplicate_2 {

	public static void main(String[] args) {
		ArrayList<Integer> a = new ArrayList<>(Arrays.asList(1,2,2,2));
		System.out.println(removeDuplicates(a));
		System.out.println(a);

	}

	public static int removeDuplicates(ArrayList<Integer> a) {
		int i, j, count;
		for(i = 0; i < a.size(); i++) {
			j = i;
			count = 0;
			while(j < a.size() && a.get(j).equals(a.get(i))) {
				count++;
				j++;
			}
			if(count > 2) {
				a.subList(i+2, j).clear();
			}
		}
		return a.size();
	}

}
