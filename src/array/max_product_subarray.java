package array;

public class max_product_subarray {

	public static void main(String[] args) {
		int arr[] = {-4, 0, -3};
		System.out.println(maxProduct(arr));
	}

	public static int maxProduct(int[] nums) {
		int prod = 1, ans = 0, max = Integer.MIN_VALUE;
		boolean gotcha = false;
		for(int i = 0; i < nums.length; i++) {
			if(nums[i] > max)
				max = nums[i];
			if(nums[i] > 0) {
				gotcha = true;
				prod *= nums[i];
			}
			else {
				if(i != nums.length - 1 && nums[i+1] < 0) {
					prod = prod * nums[i] * nums[i+1];
					i += 2;
					gotcha = true;
				}
				else {
					if(prod > ans)
						ans = prod;
					prod = 0;
				}
			}
		}
		if(prod > ans)
			ans = prod;
		if(gotcha)
			return ans;
		return max;
	}
}
