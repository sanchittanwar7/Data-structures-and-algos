package string;

import java.util.ArrayList;

public class full_justify {

	public static void main(String[] args) {
		ArrayList<String> words = new ArrayList<>();
		words.add("");
//		words.add("must");
//		words.add("be");
//		words.add("shall");
//		words.add("be.");
//		words.add("text");
//		words.add("justificaiton");
		int n = 10;
		ArrayList<String> ans = fullJustify(words, n);
		for(String str : ans)
			System.out.println(str + " " + str.length());
	}

	public static ArrayList<String> fullJustify(ArrayList<String> words, int n) {
		int i, len, start, noOfSpaces, noOfWords, spacesPerWord, extraSpaces;
		String line = "";
		ArrayList<String> ans = new ArrayList<>();
//		for(i = 0; i < words.size(); i++) {
//			words.set(i, words.get(i) + "|");
//		}
		for(i = 0; i < words.size(); i++) {
			len = 0; noOfWords = 0;line = "";
			start = i;
			while(i < words.size() && len + words.get(i).length()<= n) {
				noOfWords++;
				len += words.get(i).length() + 1;
				i++;
			}
			len -= (noOfWords);
			noOfSpaces = n - len;
			spacesPerWord = noOfSpaces/Math.max(1, noOfWords - 1);
			extraSpaces = noOfSpaces%Math.max(1, noOfWords - 1);
//			System.out.println("len : " + len + " NOofWords : "  + noOfWords + " NoOfSpaces : " + noOfSpaces + " SpacesPerWord : " + spacesPerWord + " ExtraSpaces : " + extraSpaces);
			for(; start < i; start++) {
				line = line + words.get(start);
				if(noOfWords > 1) {
					for(int space = 0; space < spacesPerWord; space++)
						line += " ";
					noOfWords--;
				}
				if(extraSpaces > 0) {
					line += " ";
					extraSpaces--;
				}
			}
			line = line.trim();
			i--;
			
//			System.out.println(line + " " + line.length());
			ans.add(line);
		}
		for(i = 0; i < line.length(); i++) {
			if(line.charAt(i) == ' ') {
				start = i;
				while(i < line.length() && line.charAt(i) == ' ')
					i++;
				line = line.substring(0, start) + " " + line.substring(i);
				i = start;
			}
		}
		for(int j = line.length(); j < n; j++)
			line += " ";
		ans.set(ans.size()-1, line);
		return ans;
	}
}
