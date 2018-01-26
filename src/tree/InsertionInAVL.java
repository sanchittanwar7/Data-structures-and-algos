package tree;

public class InsertionInAVL {

	/**
	 * @param args
	 */

	//1 2 3 4 5 6 -1 -1 -1 -1 -1 -1 -1

	public static void main(String[] args) {
		//		BinaryTreeNode<Integer> root = BinaryTreeUse.takeInput();
		//		PrintTree.print(root);
		BinaryTreeNode<Integer> root = null;
//		root = insert(root, 0);
//		root = insert(root, 1);
//		root = insert(root, 2);
//		root = insert(root, 3);
//		root = insert(root, 4);
//		root = insert(root, 6);
//		root = insert(root, 5);
		
		root = insert(root, 10);
		root = insert(root, 20);
		root = insert(root, 30);
		root = insert(root, 40);
		root = insert(root, 50);
		root = insert(root, 25);

		BinaryTreeUse.print(root);
	}

	private static int height(BinaryTreeNode<Integer> N) {
		if (N == null)
			return 0;

		return N.height;
	}

	private static BinaryTreeNode<Integer> insert(BinaryTreeNode<Integer> root,int key) {
		if(root == null)
			return new BinaryTreeNode<Integer>(key);
		if(key < root.data)
			root.left = insert(root.left, key);
		else
			root.right = insert(root.right, key);
		root.height = Math.max(height(root.left), height(root.right)) + 1;
		int balance = height(root.left) - height(root.right);
		if(balance > 1){
			if(key < root.left.data){
				//LL
				return rightRotate(root);
			}
			else{
				root.left = leftRotate(root.left);
				return rightRotate(root);
				//LR
			}
		}
		if(balance < -1){
			if(key > root.right.data){
				//RR
				return leftRotate(root);
			}
			else{
				root.right = rightRotate(root.right);
				return leftRotate(root);
				//RL
			}
		}
		return root;
	}

	private static BinaryTreeNode<Integer> leftRotate(BinaryTreeNode<Integer> node) {
		BinaryTreeNode<Integer> x = node.right;
		BinaryTreeNode<Integer> y = x.left;

		x.left = node;
		node.right = y;
		
		node.height = Math.max(height(node.left), height(node.right)) + 1;
		x.height = Math.max(height(x.left), height(x.right)) + 1; 

		return x;
	}

	private static BinaryTreeNode<Integer> rightRotate(BinaryTreeNode<Integer> node) {
		BinaryTreeNode<Integer> x = node.left;
		BinaryTreeNode<Integer> y = x.right;

		x.right = node;
		node.left = y;

		node.height = Math.max(height(node.left), height(node.right)) + 1;
		x.height = Math.max(height(x.left), height(x.right)) + 1; 
		
		return x;
	}

}
