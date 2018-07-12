package two_pointers;

import java.util.ArrayList;
import java.util.Arrays;

public class remove_duplicates {

	public static void main(String[] args) {
		ArrayList<Integer> a = new ArrayList<>(Arrays.asList(5000,5000,5000));
		System.out.println(removeDuplicates(a));
		System.out.println(a);

	}
	
	public static int removeDuplicates(ArrayList<Integer> a) {
		int i, j;
		for(i = 0; i < a.size(); i++) {
			j = i;
			while(j < a.size() && a.get(j).equals(a.get(i)))
				j++;
			a.subList(i+1, j).clear();
		}
		return a.size();
    }

}
