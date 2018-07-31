package array;

import java.util.ArrayList;
import java.util.List;

public class pascal_triangle_II {

	public static void main(String[] args) {
		int n = 30;
		System.out.println(getRow(n));
	}

	public static List<Integer> getRow(int n) {
		long ele = 1;
		List<Integer> ans = new ArrayList<>();
		ans.add((int) ele);
		for(int i = 1; i <= n; i++) {
			ele = (int) (ele * (n-i+1)/i);
			ans.add((int) ele);
		}
		return ans;
	}

}
