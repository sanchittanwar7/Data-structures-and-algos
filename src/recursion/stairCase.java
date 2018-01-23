package recursion;

public class stairCase {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		int stairs = 4;
		System.out.println(findWays(stairs));
	}

	private static int findWays(int stairs) {
		if(stairs < 0)
			return 0;
		if(stairs == 0)
			return 1;
		return findWays(stairs-1) + findWays(stairs-2) + findWays(stairs-3);
	}

}
