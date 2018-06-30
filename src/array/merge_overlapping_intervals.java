package array;

import java.util.ArrayList;
import java.util.Collections;

//import array.Interval;


class Interval implements Comparable {
	int start;
	int end;
	Interval() { start = 0; end = 0; }
	Interval(int s, int e) { start = s; end = e; }

	public int compareTo(Object interval) {
		int compareage=((Interval)interval).start;
        /* For Ascending order*/
        return this.start-compareage;
	}
}



public class merge_overlapping_intervals {

	public static void main(String[] args) {
		ArrayList<Interval> arr = new ArrayList<Interval>();
		arr.add(new Interval(1, 2));
		arr.add(new Interval(3, 5));
		arr.add(new Interval(6, 7));
		arr.add(new Interval(8, 10));
		arr.add(new Interval(12, 26));
//		ArrayList<Interval> arr1 = new ArrayList<Interval>();
//		System.out.println(arr1);
		arr = merge(arr);
//		System.out.println(arr);
		for(Interval interval : arr) {
			System.out.println(interval.start + " " + interval.end);
		}
	}
	
	

	private static ArrayList<Interval> merge(ArrayList<Interval> arr) {
		Collections.sort(arr);
//		for(Interval interval : arr) {
//			System.out.println(interval.start + " " + interval.end);
//		}
		for(int i = 0; i < arr.size() - 1; i++) {
			if(arr.get(i).end >= arr.get(i+1).start) {
				Interval newInterval = new Interval(Math.min(arr.get(i).start, arr.get(i+1).start), Math.max(arr.get(i+1).end, arr.get(i).end));
				arr.remove(i);
				arr.remove(i);
				arr.add(i, newInterval);
				i--;
			}
		}
		return arr;
	}

}
