package array;

import java.util.ArrayList;

public class wierd_number_pattern {

	public static void main(String[] args) {
		int n = 10;
		printPatter(n);
	}

	private static void printPatter(int n) {
		ArrayList<Integer> prev = new ArrayList<Integer>();
		prev.add(1);
		ArrayList<Integer> current = new ArrayList<Integer>();
		System.out.println("1");
		int i = 0, j, ele, count;
		while(i < n-1) {
			j = 0;
			for(j = 0; j < prev.size(); j++) {
				ele = prev.get(j);
				count = 0;
				while(j < prev.size() && prev.get(j) == ele) {
					count++;
					j++;
				}
				j--;
				current.add(count);
				current.add(ele);
			}
			prev = current;
			for(int element : current)
				System.out.print(element);
			System.out.println();
			current = new ArrayList<Integer>();
			i++;
		}
	}

}
