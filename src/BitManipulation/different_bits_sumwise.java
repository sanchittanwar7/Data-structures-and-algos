package BitManipulation;

import java.util.ArrayList;

public class different_bits_sumwise {

	public static void main(String[] args) {
		ArrayList<Integer> arr = new ArrayList<>();
		arr.add(1);
		arr.add(3);
		arr.add(5);
		System.out.println(cntBits(arr));
	}
	
	public static int cntBits(ArrayList<Integer> arr) {
		long ans = 0; 
        for (int i = 0; i < 32; i++) {
            int count = 0;
            for (int j = 0; j < arr.size(); j++)
                if ((arr.get(j) & (1 << i)) == 0)
                    count++;
            ans += (count * (arr.size() - count) * 2);
        }
         
        return (int)(ans%1000000007);
    }

}
