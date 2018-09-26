package hashing;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Set;

public class points_on_straight_line {

	public static void main(String[] args) {
		ArrayList<Integer> x = new ArrayList<>(Arrays.asList(0,1,-1));
		ArrayList<Integer> y = new ArrayList<>(Arrays.asList(0,1,-1));
		System.out.println(maxPoints(x, y));
	}

	public static int maxPoints(ArrayList<Integer> x, ArrayList<Integer> y) {
		if(x.size() == 0 || y.size() == 0)
            return 0;
        HashMap<Double, ArrayList<Set<Integer>>> map = new HashMap<>();
        int n = x.size(), i, j, divident, divisor, ans = 1;
        double slope;
        boolean newLine;
        ArrayList<Set<Integer>> points = new ArrayList<>();
        for(i = 0; i < n; i++) {
            for(j = i+1; j < n; j++) {
                divident = y.get(j) - y.get(i);
                divisor = x.get(j) - x.get(i);
                slope = divisor == 0 ? Integer.MAX_VALUE : (1.0 * divident) / divisor;
                if(map.containsKey(slope)) {
                    points = map.get(slope);
                    newLine = true;
                    for(Set<Integer> s : points)
                        if(s.contains(i) || s.contains(j)) {
                            points.remove(s);
                            s.add(i);
                            s.add(j);
                            points.add(s);
                            map.put(slope, points);
                            newLine = false;
                            break;
                        }
                    if(newLine) {
                        Set<Integer> s = new HashSet<>();
                        s.addAll(Arrays.asList(i, j));
                        points.add(s);
                        map.put(slope, points);
                    }
                }
                else {
                    Set<Integer> s = new HashSet<>();
                    s.addAll(Arrays.asList(i, j));
                    ArrayList<Set<Integer>> point = new ArrayList<>();
                    point.add(s);
                    map.put(slope, point);
                }
            }
        }
        Set<Double> slopes = map.keySet();
        for(Double slp : slopes) {
            ArrayList<Set<Integer>> coordinates = map.get(slp);
            for(Set<Integer> coordinate : coordinates)
                if(coordinate.size() > ans)
                    ans = coordinate.size();
        }
        return ans;
	}

}
