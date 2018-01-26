package tree;

public class ParentArrayToBTree {

	/**
	 * @param args
	 */
	
//	int parentArray[] = {3, 5, 0, -1, 5, 3, 0};

	public static void main(String[] args) {
		int parentArray[] = {-1, 0, 1, 5, 1, 0};
		BinaryTreeNode<Integer> root = createTree(parentArray, -1);
		PrintTree.print(root);
	}

	private static BinaryTreeNode<Integer> createTree(int[] parentArray, int parent) {
		int pos = -1;
		for(int i = 0; i < parentArray.length; i++)
			if(parentArray[i] == parent){
				pos = i;
				parentArray[i] = -1;
				break;
			}
		if(pos == -1)
			return null;
		BinaryTreeNode<Integer> root = new BinaryTreeNode<Integer>(pos);
		root.left = createTree(parentArray, pos);
		root.right = createTree(parentArray, pos);
		return root;
	}

}
