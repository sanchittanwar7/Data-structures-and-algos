package tree;

import java.util.ArrayList;
import java.util.Stack;

public class SerializeDeserialize {

	/**
	 * @param args
	 */
	
	//10 5 40 1 7 -1 50 -1 -1 -1 -1 -1 -1
	
	public static void main(String[] args) {
		BinaryTreeNode<Integer> root = BinaryTreeUse.takeInput();
		BinaryTreeUse.print(root);
		ArrayList<Integer> preorder = serialize(root);
		System.out.println(preorder);
		root = deserialize(preorder);
		BinaryTreeUse.print(root);
	}

	private static BinaryTreeNode<Integer> deserialize(ArrayList<Integer> preorder) {
		BinaryTreeNode<Integer> root = new BinaryTreeNode<Integer>(preorder.get(0));
		BinaryTreeNode<Integer> temp;
		Stack<BinaryTreeNode<Integer>> s = new Stack<BinaryTreeNode<Integer>>();
		s.push(root);
		for(int i = 1; i < preorder.size(); i++){
			temp = null;
			while(!s.isEmpty() && preorder.get(i) > s.peek().data)
				temp = s.pop();
			if(temp == null){
				temp = s.peek();
				temp.left = new BinaryTreeNode<Integer>(preorder.get(i));
				s.push(temp.left);
			}
			else{
				temp.right = new BinaryTreeNode<Integer>(preorder.get(i));
				s.push(temp.right);
			}
		}
		return root;
	}

	private static ArrayList<Integer> serialize(BinaryTreeNode<Integer> root) {
		if(root == null)
			return new ArrayList<Integer>();
		ArrayList<Integer> left_preorder = serialize(root.left);
		ArrayList<Integer> right_preorder = serialize(root.right);
		ArrayList<Integer> ans = new ArrayList<Integer>();
		ans.add(root.data);
		for(int data : left_preorder)
			ans.add(data);
		for(int data : right_preorder)
			ans.add(data);
		return ans;
	}

}
