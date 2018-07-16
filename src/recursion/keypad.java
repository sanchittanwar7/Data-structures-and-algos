package recursion;

import java.util.ArrayList;
import java.util.Arrays;

public class keypad {

	static ArrayList<String> ans = new ArrayList<>();
	
	public static void main(String[] args) {
		String s = "22";
//		keypad(123, "");
//		System.out.println(ans);
		ArrayList<String> ans = letterCombinations(s);
		for(String str : ans)
			System.out.println(str);
	}
	
	public static ArrayList<String> letterCombinations(String A) {
		ans = new ArrayList<>();
		if(Integer.parseInt(A) == 0) {
			ans.add(A);
			return ans;
		}
		keypad(Integer.parseInt(A), "");
		return ans;
    }
	
	public static String[] helper(int n){
		switch(n){
		case 0:String help[]={"0"};
		return help;
		case 1:String help1[]={"1"};
		return help1;
		case 2:String help2[]={"a","b","c"};
		return help2;
		case 3:String help3[]={"d","e","f"};
		return help3;
		case 4:String help4[]={"g","h","i"};
		return help4;
		case 5:String help5[]={"j","k","l"};
		return help5;
		case 6:String help6[]={"m","n","o"};
		return help6;
		case 7:String help7[]={"p","q","r","s"};
		return help7;
		case 8:String help8[]={"t","u","v"};
		return help8;
		case 9:String help9[]={"w","x","y","z"};
		return help9;
		default:String d[]={""};
		return d;
		}
	}
	
	public static void keypad(int num,String s){
		if(num==0){
			ans.add(s);
			return;
		}
		String sub[]=helper(num%10);
		for(int i=0;i<sub.length;i++){
			keypad(num/10,s+sub[i]);
		}
		
	}

}
