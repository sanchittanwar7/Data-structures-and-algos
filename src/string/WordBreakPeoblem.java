package string;

import java.util.HashMap;

public class WordBreakPeoblem {

	public static void main(String[] args) {
		String dictionary[] = {"arrays", "dynamic", "heaps", "IDeserve", "learn", "learning", "linked", "list", "platform", "programming", "stacks", "trees"};
		HashMap<String, Boolean> map = new HashMap<String, Boolean>();
		for(String str: dictionary)
			map.put(str, true);
		String str = "IDeservelearningplatform";
		System.out.println(wordBreak(map, str));
	}

	private static boolean wordBreak(HashMap<String, Boolean> map, String str) {
		boolean isValid[] = new boolean[str.length() + 1];
		int j;
		for(int i = 1; i <= str.length(); i++){
			if(map.containsKey(str.substring(0, i)) || isValid[i]){
				isValid[i] = true;
				j = i + 1;
				while(j <= str.length()){
					if(map.containsKey(str.substring(i, j)))
						isValid[j] = true;
					j++;
				}
				if(isValid[isValid.length - 1])
					return true;
			}
		}
		return isValid[isValid.length - 1];
	}

}
