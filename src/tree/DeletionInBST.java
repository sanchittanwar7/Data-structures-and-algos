package tree;

public class DeletionInBST {

	/**
	 * @param args
	 */
	
	//3 1 5 0 2 4 -1 -1 -1 -1 -1 -1 -1
	
	public static void main(String[] args) {
		BinaryTreeNode<Integer> root = BinaryTreeUse.takeInput();
		PrintTree.print(root);
		BinaryTreeNode<Integer> node = new BinaryTreeNode<Integer>(2);
		root = deleteNode(root, node);
		PrintTree.print(root);
	}

	private static BinaryTreeNode<Integer> deleteNode(BinaryTreeNode<Integer> root,BinaryTreeNode<Integer> node) {
		if(root == null)
			return null;
		if(node.data < root.data){
			root.left = deleteNode(root.left, node);
			return root;
		}
		else if(node.data > root.data){
			root.right = deleteNode(root.right, node);
			return root;
		}
		else{
			if(root.left == null && root.right == null)
				return null;
			else if((root.left == null && root.right != null) || (root.left != null && root.right == null)){
				if(root.right != null)
					return root.right;
				else
					return root.left;
			}
			else{
				int InOrderSuccessor = getMin(root.right);
				root.data = InOrderSuccessor;
				removeLeafNode(root.right, InOrderSuccessor);
				System.out.println(root.data);
				return root;
			}
		}
	}

	private static BinaryTreeNode<Integer> removeLeafNode(BinaryTreeNode<Integer> root,int node) {
		if(root == null)
			return null;
		if(root.data == node)
			return null;
		root.left = removeLeafNode(root.left, node);
		root.right = removeLeafNode(root.right, node);
		return root;
	}

	private static int getMin(BinaryTreeNode<Integer> root) {
		if(root == null)
			return Integer.MAX_VALUE;
		int minLeft = getMin(root.left);
		int minRight = getMin(root.right);
		return Math.min(root.data,Math.min(minLeft, minRight));
	}

}
