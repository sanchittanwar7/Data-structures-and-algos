package tree;

public class HeightOfBTree {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		int parent[] = {1, 5, 5, 2, 2, -1, 3};
		int parent1[] = {-1, 0, 0, 1, 1, 3, 5};
		System.out.println(height(parent1));
	}

	private static int height(int[] parent) {
		int depth[] = new int[parent.length];
		int i;
		for(i = 0; i < depth.length; i++)
			depth[i] = 0;
		for(i = 0; i < parent.length; i++)
			fillDepthArray(parent, depth, i);
		int max = Integer.MIN_VALUE;
		for(i = 0; i < depth.length; i++)
			if(depth[i] > max)
				max = depth[i];
		return max;
	}

	private static void fillDepthArray(int[] parent, int[] depth, int i) {
		if(depth[i] != 0)
			return;
		if(parent[i] == -1){
			depth[i] = 1;
			return;
		}
		if(depth[parent[i]] == 0)
			fillDepthArray(parent, depth, parent[i]);
		depth[i] = depth[parent[i]] + 1;
	}
	

}
