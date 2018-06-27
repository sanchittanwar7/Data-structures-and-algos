package array;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.Comparator;

public class hotel_booking {
	
	static ArrayList<Integer> deptList = new ArrayList<Integer>(Collections.nCopies(30, Integer.MAX_VALUE));


	public static void main(String[] args) {
		ArrayList<Integer> arr = new ArrayList<Integer>(Arrays.asList(49, 8, 22, 28, 9, 15, 42, 3));
		ArrayList<Integer> dept = new ArrayList<Integer>(Arrays.asList(72, 38, 66, 51, 49, 57, 79, 30 ));
		System.out.println(hotel(arr, dept, 2));
	}
	
//	public static boolean hotel(ArrayList<Integer> arr, ArrayList<Integer> dept, int k) {
//		ArrayList<Integer> status = new ArrayList<Integer>(Collections.nCopies(31, 0));
//		for(int i = 0; i < arr.size(); i++) {
//			for(int j = arr.get(i); j <= dept.get(i); j++) {
//				status.set(j, status.get(j) + 1);
//				if(status.get(j) > k)
//					return false;
//			}
//		}
//		return true;
//    }
	
	public static boolean hotel(final ArrayList<Integer> arr, final ArrayList<Integer> dept, int k) {
		int checkouts;
		Collections.sort(arr);
		Collections.sort(dept, new Comparator<Integer>(){
			public int compare(Integer X, Integer Y) {
//				Integer XY=(int) (Math.pow(10, (int)(Math.log10(Y)+1))*X + Y);
//				Integer YX=(int) (Math.pow(10, (int)(Math.log10(X)+1))*Y + X);
				return arr.get(dept.indexOf(X)).compareTo(arr.get(dept.indexOf(Y))) < 0 ? -1:1;
			}
		});
//		System.out.println(arr + " "  + dept);
		for(int i = 0; i < arr.size(); i++) {
			addToDeptList(dept.get(i));
			System.out.println(deptList);
			k--;
			if(k < 0) {
				checkouts = searchForCheckOut(arr.get(i));
				if(checkouts == 0)
					return false;
				else
					k += checkouts;
			}
		}
		return true;
		
	}

	private static int searchForCheckOut(Integer date){
		int count = 0;
		for(int i = 0; i < deptList.size(); i++) {
			if(deptList.get(i) <= date) {
				count++;
				deptList.remove(i);
			}
		}
		return count;
	}

	private static void addToDeptList(Integer date){
		System.out.println(date);
		if(date < deptList.get(0)) {
			
			deptList.add(0, date);
			return;
		}
		for(int i = 0; i < deptList.size(); i++) {
			if(date < deptList.get(i)) {
	
					deptList.add(i, date);
				return;
			}
		}
	}

}
