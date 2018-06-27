package array;

import java.util.ArrayList;

public class pascal_triangle {

	public static void main(String[] args) {
		int n = 10;
		ArrayList<ArrayList<Integer>> ans = generate(n);
		for(ArrayList<Integer> row : ans) {
			System.out.println(row);
		}
	}
	
	public static ArrayList<ArrayList<Integer>> generate(int n) {
		ArrayList<ArrayList<Integer>> ans = new ArrayList<ArrayList<Integer>>();
		int i, j, previousRowNum = -1, index1, index2, element;
		for(i = 0; i < n; i++)
			ans.add(i, new ArrayList<Integer>());
		for(i = 0; i < n; i++) {
			index1 = 0;index2 = 1;
			for(j = 0; j <= i; j++) {
				if(j == 0 || j == i ) {
					ans.get(i).add(j, 1);
				}
				else {
					element = ans.get(previousRowNum).get(index1) + ans.get(previousRowNum).get(index2);
					ans.get(i).add(j, element);
					index1++;index2++;
				}
			}
			previousRowNum++;
		}
		return ans;
	}

}
