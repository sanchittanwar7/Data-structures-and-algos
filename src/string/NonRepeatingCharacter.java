package string;

public class NonRepeatingCharacter {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		String str = "DBCGHIEFKJLADTVDERFSWVGHQWCNOPENSMSJWIERTFB";
		System.out.println(nonRepeating(str));
	}

	private static char nonRepeating(String str) {
		int index[] = new int[26], pos, min = Integer.MAX_VALUE;
		for(int i = 0; i < 26; i++)
			index[i] = -1;
		for(int i = 0; i < str.length(); i++){
			pos = str.charAt(i) - 65;
			if(index[pos] == -1)
				index[pos] = i;
			else if(index[pos] > 0)
				index[pos] = -2;
		}
		for(int i = 0; i < 26; i++){
			if(index[i] > 0 && index[i] < min)
				min = index[i];
		}
		return str.charAt(min);
	}

}
