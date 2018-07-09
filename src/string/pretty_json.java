package string;

import java.util.ArrayList;

public class pretty_json {

	public static void main(String[] args) {
		String str = "[\"foo\", {\"bar\":[\"baz\",null,1.0,2]}]";
		String str1 = "{A:\"B\",C:{D:\"E\",F:{G:\"H\",I:\"J\"}}}";
		ArrayList<String> ans = prettyJSON(str);
		for(String s : ans)
			System.out.println(s);
	}

	public static ArrayList<String> prettyJSON(String s) {
		int start = 0, end = 0, noOfTabs = 0;
		String str;
		ArrayList<String> ans = new ArrayList<>();
		while(end < s.length()-1) {
			str = "";
			for(int i = 0; i < noOfTabs; i++)
				str += "\t";
			while(end < s.length()-1 && s.charAt(end) != '[' && s.charAt(end) != '{' && s.charAt(end+1) != '}' && s.charAt(end+1) != ']' && s.charAt(end) != ',' && ((s.charAt(end) != ':')||!(s.charAt(end+1) == '[' || s.charAt(end+1) == '{')) ) {
				end++;
			}
			if(s.charAt(end) == '[' || s.charAt(end) == '{') 
				noOfTabs++;
			if(s.charAt(end+1) == ']' || s.charAt(end+1) == '}')
				noOfTabs--;
			str += s.substring(start, ++end);
			start = end;
			ans.add(str);
		}
		ans.add(""+s.charAt(end));
		return ans;
	}
}


