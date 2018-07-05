package string;

import java.math.BigInteger;

public class compare_version_number {

	public static void main(String[] args) {
		String str1 = "643443896946", str2 = "2.487969654569425698";
		System.out.println(compareVersionPreProcess(str1, str2));
	}
	
	private static int compareVersionPreProcess(String str1, String str2) {
		return compareVersion(str1 + '.', str2 + '.');
	}

	public static int compareVersion(String s1, String s2) {
		if(s1.length() == 0 || s2.length() == 0) {
			System.out.println(s1 + " " + s2);
			int dot;
			if(s1.length() == 0 && s2.length() == 0)
				return 0;
			else if(s1.length() != 0) {
				dot = 0;
				while(s1.charAt(dot) != '.')
					dot++;
				s1 = Long.parseLong(s1.substring(0, dot)) == 0 ? "" : s1;
			}
			else {
				dot = 0;
				while(s2.charAt(dot) != '.')
					dot++;
				System.out.println(dot);
				s2 = Long.parseLong(s2.substring(0, dot)) == 0 ? "" : s2;
			}
			if(s1.length() == 0 && s2.length() == 0)
				return 0;
			return s1.length() == 0 ? -1 : 1;
		}
		int i = 0, n1 = s1.length(), n2 = s2.length();
		while(i < n1 && s1.charAt(i) != '.')
			i++;
		String cmp1 = s1.substring(0, i);
		String sub1 = s1.substring(i+1);
		i = 0;
		while(i < n2 && s2.charAt(i) != '.')
			i++;
		String cmp2 = s2.substring(0, i);
		String sub2 = s2.substring(i+1);
		BigInteger v1 = new BigInteger(cmp1);
		BigInteger v2 = new BigInteger(cmp2);
		if(v1.compareTo(v2) < 0)
			return -1;
		else if(v1.compareTo(v2) > 0)
			return 1;
		return compareVersion(sub1, sub2);
    }

}
