package tree;

public class InsertionSearchingInBST {

	/**
	 * @param args
	 */
	
	//5 2 8 1 4 6 9 -1 -1 -1 -1 -1 -1 -1 -1
	
	public static void main(String[] args) {
		BinaryTreeNode<Integer> root = BinaryTreeUse.takeInput();
		PrintTree.print(root);
		BinaryTreeNode<Integer> node = new BinaryTreeNode<Integer>(7);
		insert(root, node);
		PrintTree.print(root);
		node = search(root, 6);
		System.out.println(node.right.data);
	}

	private static BinaryTreeNode<Integer> search(BinaryTreeNode<Integer> root,int i) {
		if(root == null)
			return null;
		if(root.data == i)
			return root;
		if(i < root.data)
			return search(root.left, i);
		return search(root.right, i);
	}
	

	private static void insert(BinaryTreeNode<Integer> root,BinaryTreeNode<Integer> node) {
		if(root == null)
			return;
		if(root.left == null && root.right == null){
			if(node.data < root.data)
				root.left = node;
			else
				root.right = node;
			return;
		}
		if(node.data < root.data)
			insert(root.left, node);
		else
			insert(root.right, node);
		return;
	}

}
