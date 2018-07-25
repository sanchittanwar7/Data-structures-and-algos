package array;

public class jump_game {

	public static void main(String[] args) {
		int a1[] = {2,3,1,1,4}, a2[] = {3,2,1,0,4};
		System.out.println(canJump(a1));
		System.out.println(canJump(a2));
	}

	public static boolean canJump(int[] nums) {
		if(nums.length == 1)
            return true;
        int minJump = 1;
		for(int i = nums.length-2; i > 0; i--) {
			if(nums[i] < minJump)
				minJump++;
            else
                minJump = 1;
		}
		if(minJump <= nums[0])
			return true;
		return false;
	}

}
