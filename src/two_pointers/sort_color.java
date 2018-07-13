package two_pointers;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;

public class sort_color {

	public static void main(String[] args) {
		ArrayList<Integer> arr = new ArrayList<>(Arrays.asList(0,1,2,0,1,2, 1, 2, 2, 1, 1, 2, 1, 2, 1, 2, 1, 2, 1, 0, 0, 0, 2, 1, 1, 2, 1, 1));
		sort(arr);
		System.out.println(arr);
	}
	
	public static void sortColors(ArrayList<Integer> a) {
		int i = 0, j = 1, n = a.size();
		while(j < n) {
			while(j < n && a.get(j) != 0) {
				j++;
			}
			if(j == n)
				break;
			Collections.swap(a, i, j);
			i++;
		}
		j = n-2;
		i = n-1;
		while(j >= 0) {
			while(j >=0 && a.get(j) != 2)
				j--;
			if(j < 0)
				break;
			Collections.swap(a, i, j);
			i--;
		}
    }
	
	public static void sort(ArrayList<Integer> a) {
		int i,k=a.size()-1,j=a.size()-1,tmp;
		for(i=0;i<k;i++){
			while(a.get(i)==0)
				i++;
			while(a.get(j)==1||a.get(j)==2)
				j--;
			if(i<=j){	
				Collections.swap(a, i, j);
				j--;
				continue;
			}
			for(;i<k;i++){
				while(a.get(i)==1)
					i++;
				while(a.get(k)==2)
					k--;
				if(i<k){
					Collections.swap(a, i, k);
					k--;
				}
			}
			break;
		}
	}

}
