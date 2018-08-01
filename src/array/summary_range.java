package array;

import java.util.ArrayList;
import java.util.List;

public class summary_range {

	public static void main(String[] args) {
		int arr[] = {0,1,2,4,5,7};
		List<String> ans = summaryRanges(arr);
		System.out.println(ans);
	}
	
	public static List<String> summaryRanges(int[] nums) {
        List<String> ans = new ArrayList<String>();
        String str;
        int start = 0, end = 1;
        while(end <= nums.length){
            while(end < nums.length && nums[end] - nums[end-1] == 1)
                end++;
            if(nums[end - 1] == nums[start])
                str = "" + nums[start];
            else
                str = nums[start] + "->" + nums[end-1];
            ans.add(str);
            start = end;
            end = start+1;
        }
        return ans;
    }

}
