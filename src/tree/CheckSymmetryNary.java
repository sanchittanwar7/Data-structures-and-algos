package tree;

public class CheckSymmetryNary {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		treeNode<Integer> root = TreeUse.takeInput();
		TreeUse.print(root);
		System.out.println(checkSymmetry(root));
	}

	private static boolean checkSymmetry(treeNode<Integer> root) {
		return areMirror(root, root);
	}

	private static boolean areMirror(treeNode<Integer> root1,treeNode<Integer> root2) {
		if(root1 == null || root2 == null){
			if(root1 == null && root2 == null)
				return true;
			return false;
		}
		if(root1.data == root2.data){
			int i = 0;
			int j = root1.children.size() - 1;
			while(i < j){
				if(!areMirror(root1.children.get(i), root2.children.get(j)))
					break;
				i++;
				j--;
			}
			if(i < j)
				return false;
			return true;
		}
		return false;
	}

}
