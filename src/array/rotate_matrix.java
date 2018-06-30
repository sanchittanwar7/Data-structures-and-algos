package array;

import java.util.ArrayList;
import java.util.Arrays;

public class rotate_matrix {

	public static void main(String[] args) {
		ArrayList<ArrayList<Integer>> arr = new ArrayList<ArrayList<Integer>>();
		int n = 4;
		arr.add(new ArrayList<Integer>(Arrays.asList(1,2,3,4)));
		arr.add(new ArrayList<Integer>(Arrays.asList(5,6,7,8)));
		arr.add(new ArrayList<Integer>(Arrays.asList(9,10,11,12)));
		arr.add(new ArrayList<Integer>(Arrays.asList(13,14,15,16)));
		for(ArrayList<Integer> row : arr)
			System.out.println(row);
		arr = rotate(arr);
		for(ArrayList<Integer> row : arr)
			System.out.println(row);
	}

	private static ArrayList<ArrayList<Integer>> rotate(ArrayList<ArrayList<Integer>> arr) {
		int r1,c1,r2,c2,r3,c3,r4,c4,n = arr.size(), i = 0, temp, temp1, turn = 0, innerRound = 0;
		while(turn < n/2) {
			r1 = c1 = turn;
			r2 = turn; c2 = c1 + n - 1 - 2*turn;
			r3 = r1 + n - 1 - 2*turn; c3 = c1 + n - 1 - 2*turn;
			r4 = r1 + n - 1 - 2*turn; c4 = turn;
//			System.out.println(r1 + " " + c1);
//			System.out.println(r2 + " " + c2);
//			System.out.println(r3 + " " + c3);
//			System.out.println(r4 + " " + c4);
			i = 0;
			while(i < n - 1 - innerRound) {
				temp = arr.get(r2).get(c2);
				arr.get(r2).set(c2, arr.get(r1).get(c1));
				temp1 = arr.get(r3).get(c3);
				arr.get(r3).set(c3, temp);
				temp = arr.get(r4).get(c4);
				arr.get(r4).set(c4, temp1);
				arr.get(r1).set(c1, temp);
				c1++;
				r2++;
				c3--;
				r4--;
				i++;
			}
			turn++;
			innerRound += 2;
			System.out.println();
		}
		return arr;
	}

}
