package array;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.HashMap;

public class set_matrix_zeros {

	public static void main(String[] args) {
		ArrayList<ArrayList<Integer>> arr = new ArrayList<ArrayList<Integer>>();
		arr.add(new ArrayList<Integer>(Arrays.asList(1,0,0)));
		arr.add(new ArrayList<Integer>(Arrays.asList(1,1,1)));
		arr.add(new ArrayList<Integer>(Arrays.asList(1,1,1)));
		setZeros(arr);
		for(ArrayList<Integer> row : arr)
			System.out.println(row);
	}

	private static void setZeros(ArrayList<ArrayList<Integer>> arr) {
		HashMap<Integer, Boolean> row = new HashMap<Integer, Boolean>();
		HashMap<Integer, Boolean> col = new HashMap<Integer, Boolean>();
		int Row = arr.size(), Col = arr.get(0).size();
		int  i, j;
		for(i = 0; i < arr.size(); i++) {
			for(j = 0; j < arr.get(i).size(); j++) {
				if(arr.get(i).get(j) == 0) {
					row.put(i, true);
					col.put(j, true);
				}
			}
		}
		for(Integer r : row.keySet()) {
			arr.set(r, new ArrayList<Integer>(Collections.nCopies(Col, 0)));
		}
		for(Integer c : col.keySet()) {
			for(ArrayList<Integer> r : arr)
				r.set(c, 0);
		}
	}

}
