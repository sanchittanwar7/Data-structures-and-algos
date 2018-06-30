package array;

import java.util.ArrayList;

//class Interval {
//	int start;
//	int end;
//	Interval() { start = 0; end = 0; }
//	Interval(int s, int e) { start = s; end = e; }
//}

//import array.Interval;


public class merge_intervals {

	public static void main(String[] args) {
		ArrayList<Interval> arr = new ArrayList<Interval>();
		arr.add(new Interval(1, 2));
		arr.add(new Interval(3, 5));
		arr.add(new Interval(6, 7));
		arr.add(new Interval(8, 10));
		arr.add(new Interval(12, 16));
		Interval newInterval = new Interval(4, 9);
		
		ArrayList<Interval> arr1 = new ArrayList<Interval>();
		arr1.add(new Interval(2, 3));
		arr1.add(new Interval(7, 9));
		Interval newInterval1 = new Interval(4,6);
		arr = insert(arr1, newInterval1);
		for(Interval interval : arr) {
			System.out.println(interval.start + " " + interval.end);
		}
	}

	private static ArrayList<Interval> insert(ArrayList<Interval> arr, Interval newInterval) {
		int temp;
		boolean isInserted = false;
		if(newInterval.start > newInterval.end) {
			temp = newInterval.start;
			newInterval.start = newInterval.end;
			newInterval.end = temp;
		}
		ArrayList<Interval> ans = new ArrayList<Interval>();
		if(newInterval.end < arr.get(0).start) {
			ans.add(newInterval);
			isInserted = true;
		}
		Interval currentInterval;
		int i, start, end;
		for(i = 0; i < arr.size(); i++) {
			currentInterval = arr.get(i);
			if(currentInterval.end < newInterval.start || ( currentInterval.start > newInterval.end) && isInserted )
				ans.add(currentInterval);
			else {
				start = Math.min(currentInterval.start, newInterval.start);
				while(i < arr.size() && arr.get(i).start <= newInterval.end) {
					i++;
				}
				i--;
				end = Math.max(arr.get(i).end, newInterval.end);
				Interval mergedInterval = new Interval(start, end);
				ans.add(mergedInterval);
				isInserted = true;
			}
		}
		if(!isInserted)
			ans.add(newInterval);
		return ans;
	}

}
