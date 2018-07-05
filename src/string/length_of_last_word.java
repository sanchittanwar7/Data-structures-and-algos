package string;

public class length_of_last_word {

	public static void main(String[] args) {
		String str = "   ";
		System.out.println(lastWord(str));
	}

	private static int lastWord(String str) {
		String[] arr = str.split(" ");
		return arr.length == 0 ? 0 : arr[arr.length-1].length();
	}

}
