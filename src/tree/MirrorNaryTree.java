package tree;

public class MirrorNaryTree {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		treeNode<Integer> root = TreeUse.takeInput();
		TreeUse.print(root);
		mirror(root);
		TreeUse.print(root);
	}

	private static void mirror(treeNode<Integer> root) {
		if(root == null)
			return;
		treeNode<Integer> temp;
		int i = 0;
		int j = root.children.size() - 1;
		while(i < j){
			temp = root.children.get(i);
			root.children.set(i, root.children.get(j));
			root.children.set(j, temp);
			i++;
			j--;
		}
		for(treeNode<Integer> child : root.children)
			mirror(child);
	}

}
