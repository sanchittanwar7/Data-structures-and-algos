package string;

import java.util.ArrayList;

public class valid_ips {

	public static void main(String[] args) {
		String s = "0100100";
		ArrayList<String> ans = restoreIpAddresses(s);
		for(String str : ans)
			System.out.println(str);
	}


	private static ArrayList<String> restoreIpAddresses(String s) {
		return getIps(s, 1);
	}


	private static ArrayList<String> getIps(String s, int part) {
		if(s.length() == 0 || part >= 4) {
			if(s.length() == 0 || Integer.parseInt(s) < 0 || Integer.parseInt(s) > 255)
				return new ArrayList<>();
			if(s.length() > 1 && s.charAt(0) == '0')
				return new ArrayList<>();
			ArrayList<String> finalAns = new ArrayList<>();
			finalAns.add(s);
			return finalAns;
		}
		ArrayList<String> ans = new ArrayList<>();
		ArrayList<String> finalAns = new ArrayList<>();
		int i = 1;
		String portion;
		while(i <= Math.min(3, s.length())) {
			portion = s.substring(0, i);
			if(Integer.parseInt(portion) >= 0 && Integer.parseInt(portion) <= 255) {
				if(!(portion.length() > 1 && portion.charAt(0) == '0')) {
					ans = getIps(s.substring(i), part+1);
					for(String answer : ans) {
						finalAns.add(portion  + "." + answer);
					}
				}
			}
			i++;
		}
		return finalAns;
	}

}
