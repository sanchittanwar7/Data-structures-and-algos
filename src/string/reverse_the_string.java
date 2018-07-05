package string;

public class reverse_the_string {

	public static void main(String[] args) {
		String str = "    4r2h  d8as6cd     2br qdw   ";
		System.out.println(reverseWords(str));
	}

	private static String reverseWords(String str) {
		int i = 0, n = str.length(), start, end;
		while(i < n && str.charAt(i) == ' ')
			i++;
		str = str.substring(i);
		i = str.length()-1;
		while(i >= 0 && str.charAt(i) == ' ')
			i--;
		str = str.substring(0, i+1);
		start = 0; end = 0;
		String reverseWord;
		while(end < str.length()) {
			while(end < str.length() && str.charAt(end) != ' ')
				end++;
			reverseWord = reverse(str.substring(start, end));
			str = str.substring(0, start) + reverseWord + str.substring(end, str.length());
			start = end;
			while(end < str.length() && str.charAt(end) == ' ')
				end++;
			str = str.substring(0, start) + " " + str.substring(Math.min(end, str.length()));
			start++;
			end = start;
		}
		return reverse(str).substring(1);
	}

	private static String reverse(String str) {
		char ch[]=str.toCharArray();  
	    String rev="";  
	    for(int i=ch.length-1;i>=0;i--){  
	        rev+=ch[i];  
	    }  
	    return rev; 
	}

}
