package tree;

public class RecoverBST {

	/**
	 * @param args
	 */
	
	//10 5 8 2 20 -1 -1 -1 -1 -1 -1
	//8 5 20 2 10 -1 -1 -1 -1 -1 -1

	static BinaryTreeNode<Integer> first, second, prev, mid;

	public static void main(String[] args) {
		BinaryTreeNode<Integer> root = BinaryTreeUse.takeInput();
		PrintTree.print(root);
		recoverTree(root);
		PrintTree.print(root);
	}

	private static void recoverTree(BinaryTreeNode<Integer> root) {
		recover(root);
		Integer temp;
		if(second == null){
			temp = mid.data;
			mid.data = first.data;
			first.data = temp;
		}
		else{
			temp = second.data;
			second.data = first.data;
			first.data = temp;
		}
	}

	private static void recover(BinaryTreeNode<Integer> root) {
		if(root == null)
			return;
		recover(root.left);
		if(prev != null){
			if(root.data < prev.data){
				if(first == null){
					first = prev;
					mid = root;
				}
				else
					second = root;
			}
		}
		prev = root;
		recover(root.right);
	}

}
