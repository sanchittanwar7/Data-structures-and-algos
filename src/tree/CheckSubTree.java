package tree;

public class CheckSubTree {

	/**
	 * @param args
	 */
	
	//1 2 3 4 5 6 -1 -1 -1 -1 -1 -1 -1
    //1 6 -1 -1 -1
	
	//0 1 2 3 4 5 -1 -1 6 -1 -1 -1 7 -1 8 -1 -1 -1 -1
	//1 3 4 -1 6 -1 -1 -1 8 -1 -1
	//1 3 4 -1 6 -1 -1 -1 -1
	public static void main(String[] args) {
		System.out.println("Enter main tree : ");
		BinaryTreeNode<Integer> root = BinaryTreeUse.takeInput();
		PrintTree.print(root);
		System.out.println("Enter sub-tree : ");
		BinaryTreeNode<Integer> root2 = BinaryTreeUse.takeInput();
		PrintTree.print(root2);
		System.out.println(checkSubTree(root, root2));
	}

	private static boolean checkSubTree(BinaryTreeNode<Integer> root, BinaryTreeNode<Integer> root2) {
		BinaryTreeNode<Integer> node = findNode(root, root2);
		if(node == null)
			return false;
		return match(node, root2);
	}

	private static boolean match(BinaryTreeNode<Integer> root,BinaryTreeNode<Integer> node) {
		if(root == null || node == null){
			if(root == null && node == null)
				return true;
			return false;
		}
		if(root.data != node.data)
			return false;
		return match(root.left, node.left) && match(root.right, node.right);
	}

	private static BinaryTreeNode<Integer> findNode(BinaryTreeNode<Integer> root, BinaryTreeNode<Integer> root2) {
		if(root == null)
			return root;
		if(root.data == root2.data)
			return root;
		BinaryTreeNode<Integer> ans = findNode(root.left, root2);
		if(ans != null)
			return ans;
		ans = findNode(root.right, root2);
		if(ans != null)
			return ans;
		return null;
	}

}
