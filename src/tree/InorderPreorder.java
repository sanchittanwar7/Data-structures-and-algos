package tree;

public class InorderPreorder {

	/**
	 * @param args
	 */
	
//	int inorder[] = {4,2,5,1,6,3,7};
//	int preorder[] = {1,2,4,5,3,6,7};
	
	public static void main(String[] args) {
		int inorder[] = {4,2,5,7,1,6,3};
		int preorder[] = {1,2,4,5,7,3,6};
		BinaryTreeNode<Integer> root = createTree(inorder, preorder, 0, inorder.length - 1, 0, preorder.length - 1);
		PrintTree.print(root);
	}

	private static BinaryTreeNode<Integer> createTree(int[] inorder,int[] preorder, int inStart, int inEnd, 
			int preStart, int preEnd) {
		if(inEnd - inStart < 0)
			return null;
		BinaryTreeNode<Integer> root = new BinaryTreeNode<Integer>(preorder[preStart]);
		int count = inStart, skip = 0;
		while(count <= inEnd && inorder[count] != preorder[preStart]) {
			count++;
			skip++;
		}
		root.left = createTree(inorder, preorder, inStart, count - 1, preStart + 1, preStart + skip);
		root.right= createTree(inorder, preorder, count + 1, inEnd, preStart + skip + 1, preEnd);
		return root;
	}

}
