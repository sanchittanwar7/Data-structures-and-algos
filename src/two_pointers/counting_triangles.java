package two_pointers;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;

public class counting_triangles {

	public static void main(String[] args) {
		ArrayList<Integer> a = new ArrayList<>(Arrays.asList(1,1,1,1,2,2,3,3,3));
		System.out.println(nTriang(a));
	}
	
	public static int nTriang(ArrayList<Integer> arr) {
		int n = arr.size();
        Collections.sort(arr);
        int count = 0;
        for (int i = 0; i < n-2; ++i){
            int k = i + 2;
            for (int j = i+1; j < n; ++j){
                while (k < n && arr.get(i) + arr.get(j) > arr.get(k))
                    ++k;
                count += k - j - 1;
            }
        }
        return count;
	}

}
