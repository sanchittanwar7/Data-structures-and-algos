package tree;

class info{
	int min;
	int max;
	boolean isBST;
	int size;
	
	info(int min, int max, int size, boolean isBST){
		this.min = min;
		this.max = max;
		this.size = size;
		this.isBST = isBST;
	}
}

//10 6 12 7 4 9 14 -1 -1 -1 -1 -1 -1 13 16 -1 -1 -1 -1
//10 15 1 7 16 9 14 -1 -1 -1 -1 -1 -1 -1 -1
public class LargestBST {

	
	public static void main(String[] args) {
		BinaryTreeNode<Integer> root = BinaryTreeUse.takeInput();
		BinaryTreeUse.print(root);
		info ans = getLargest(root);
		System.out.println(ans.size);
	}
	private static info getLargest(BinaryTreeNode<Integer> root) {
		if(root == null){
			return new info(Integer.MAX_VALUE, Integer.MIN_VALUE, 0, true);
		}
		info ans1 = getLargest(root.left);
		info ans2 = getLargest(root.right);
		if(!ans1.isBST || !ans2.isBST)
			return ans1.isBST ? ans1 : ans2;
		if(root.data > ans1.max && root.data < ans2.min)
			return new info(Math.min(root.data, ans1.min), Math.max(root.data, ans2.max), 1 + ans1.size + ans2.size, true);
		return ans1.size > ans2.size ? ans1 : ans2;
	}

}
