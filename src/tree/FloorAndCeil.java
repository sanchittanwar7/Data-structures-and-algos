package tree;

public class FloorAndCeil {

	/**
	 * @param args
	 */

	//6 2 9 0 4 8 -1 -1 -1 -1 -1 -1 -1

	public static void main(String[] args) {
		BinaryTreeNode<Integer> root = BinaryTreeUse.takeInput();
		PrintTree.print(root);
		for(int key = 0; key <= 10; key++){
			System.out.println(key + " " + ceil(root, key));
			System.out.println(key + " " + floor(root, key));
		}
	}

	private static int floor(BinaryTreeNode<Integer> root, int key) {
		if(root == null)
			return -1;
		int ans;
		if(root.data == key)
			return key;
		else if(root.data < key){
			ans = floor(root.right, key);
			if(ans == -1)
				return root.data;
			return ans;
		}
		else{
			return floor(root.left, key);
		}
	}

	private static int ceil(BinaryTreeNode<Integer> root, int key) {
		if(root == null)
			return -1;
		int ans;
		if(root.data == key)
			return key;
		if(root.data < key)
			return ceil(root.right, key);
		else{
			ans = ceil(root.left, key);
			if(ans == -1)
				return root.data;
			return ans;
		}
	}

}
