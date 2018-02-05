package string;

import java.util.HashMap;
import java.util.Set;

public class DNASequence {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		String str = "AAAAACCCCCAAAAACCCCCCAAAAAGGGTTT";
		HashMap<String, Integer> ans = analyse(str);
		Set<String> keys = ans.keySet();
		for(String string : keys){
			if(ans.get(string) > 1)
				System.out.println(string);
		}
	}

	private static HashMap<String, Integer> analyse(String str) {
		HashMap<String, Integer> ans = new HashMap<String, Integer>();
		int start = 0, end = 10, newValue;
		String sub;
		while(end <= str.length()){
			sub	= str.substring(start, end);
			newValue = 1;
			if(ans.containsKey(sub)){
				newValue = ans.get(sub) + 1;
			}
			ans.put(sub, newValue);
			start++;
			end++;
		}
		return ans;
	}

}
