package tree;

import java.util.Stack;

//5 3 7 2 4 6 -1 1 -1 -1 -1 -1 -1 -1 -1

public class BST_iterator {
	
	Stack<Integer> s = new Stack<>();

	BST_iterator(TreeNode root){
		createStack(root);
	}

	private void createStack(TreeNode root) {
		if(root == null)
			return;
		createStack(root.right);
		s.push(root.val);
		createStack(root.left);
		
	}

	public static void main(String[] args) {
		TreeNode root = TreeNodeUse.takeInput();
		TreeNodeUse.print(root);
		BST_iterator i = new BST_iterator(root);
		while (i.hasNext()) 
			System.out.print(i.next());

	}

	public boolean hasNext() {
		return !s.isEmpty();
	}

	/** @return the next smallest number */
	public int next() {
		int top = s.pop();
		return top;
	}

}
