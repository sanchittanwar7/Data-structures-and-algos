package tree;

public class LongestPrefixMatching {

	/**
	 * @param args
	 */

	final static int INVALID_NUM = Integer.MIN_VALUE;

	public static void main(String[] args) {
		triesNode root = new triesNode(INVALID_NUM, '^', false);
		String str[] = {"are", "area", "base", "cat", "cater", "children", "basement"};
		for(String string : str){
			TriesInsertion.insert(root, string, 0);
		}
		int length;
		String ans;
		String toFind[] = {"caterer", "basemexy", "child"};
		for(String string : toFind){
			length = search(root, string, -1);
			ans = length == -1 ? "<empty>" : string.substring(0, Math.abs(length));
			System.out.println(string + ": " + ans);
		}
	}

	private static int search(triesNode root, String string, int ansSoFar) {
		if(string.length() == 0){
			if(root.isLeaf)
				return 0;
			return -1;
		}
		if(root.isLeaf)
			ansSoFar = string.length();
		int pos = (int)string.charAt(0) - 96;
		triesNode current = root.children.get(pos);
		if(current == null){
			if(root.isLeaf)
				return 0;
			if(ansSoFar > 0)
				return -ansSoFar;
			return -1;
		}
		int ans = search(current, string.substring(1), ansSoFar);
		return ans >= 0 ? 1 + ans : ans;
	}

}
