package tree;

public class TriesDeletion {

	/**
	 * @param args
	 */
	static int INVALID_NUM = Integer.MIN_VALUE;
	
	public static void main(String[] args) {
		triesNode root = new triesNode(INVALID_NUM, '^', false);
		TriesInsertion.insert(root, "there", 0);
		TriesInsertion.insert(root, "their", 0);
		TriesInsertion.insert(root, "sell", 0);
		TriesInsertion.insert(root, "sells", 0);
		TriesInsertion.insert(root, "sanchit", 0);
		TriesInsertion.insert(root, "tanwar", 0);
		delete(root, "sells");
		System.out.println(TriesInsertion.search(root, "sell"));
		System.out.println(TriesInsertion.search(root, "sells"));
		delete(root, "their");
		System.out.println(TriesInsertion.search(root, "there"));
		System.out.println(TriesInsertion.search(root, "their"));
		System.out.println(TriesInsertion.search(root, "sanchit"));
		delete(root, "sanchit");
		System.out.println(TriesInsertion.search(root, "sanchit"));
		System.out.println(TriesInsertion.search(root, "tanwar"));
	}

	private static boolean delete(triesNode current, String str) {
		if(str.length() == 0){
			if(current.numOfChilds > 0){
				current.isLeaf = false;
				return true;
			}
			return false;
		}
		int pos = (int)str.charAt(0) - 96;
		boolean ans = delete(current.children.get(pos), str.substring(1));
		if(!ans){
			current.children.set(pos, null);
			if(current.numOfChilds < 1)
				return false;
		}
		return true;
	}

}
