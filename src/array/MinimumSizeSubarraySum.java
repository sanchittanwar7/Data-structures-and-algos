package array;

public class MinimumSizeSubarraySum {

	public static void main(String[] args) {
		int arr[] = {3,2,1,1,1,1,1};
		int n = 5;
		System.out.println(minSubArrayLen(n, arr));
	}
	
	public static int minSubArrayLen(int s, int[] nums) {
		int start = 0, end = -1, sum = 0, minLen, len;
        while(end < nums.length - 1 && sum < s){
            end++;
            sum += nums[end];
        }
        if(sum < s)
        	return 0;
        minLen = end - start + 1;
        end++;
        while(end <= nums.length){
            sum += end == nums.length ? 0 : nums[end];
            while(sum >= s){
                sum -= nums[start];
                start++;
            }
            start--;
            sum += nums[start];
            len = end == nums.length ? end - start : end - start + 1;
            if(len< minLen) {
                minLen = len;
            }
            end++;
        }
        return minLen;
    }

}
