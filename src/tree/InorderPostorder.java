package tree;

public class InorderPostorder {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		int inorder[] = {4,2,5,1,6,3,7};
		int postorder[] = {4,5,2,6,7,3,1};
		BinaryTreeNode<Integer> root = createTree(inorder, postorder, 0, inorder.length - 1, 0, postorder.length - 1);
		PrintTree.print(root);
	}

	private static BinaryTreeNode<Integer> createTree(int[] inorder,int[] postorder, int inStart, int inEnd,
			int postStart, int postEnd) {
		if(inEnd - inStart < 0)
			return  null;
		BinaryTreeNode<Integer> root = new BinaryTreeNode<Integer>(postorder[postEnd]);
		int pos = inStart;
		int skip = 0;
		while(pos <= inEnd && inorder[pos] != postorder[postEnd]){
			pos++;
			skip++;
		}
		root.left = createTree(inorder, postorder, inStart, pos - 1, postStart, postStart + skip - 1);
		root.right = createTree(inorder, postorder, pos + 1, inEnd, postStart + skip, postEnd - 1);
		return root;
	}

}
