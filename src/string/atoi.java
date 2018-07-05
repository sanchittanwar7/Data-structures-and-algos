package string;

public class atoi {

	public static void main(String[] args) {
		String str = "-5121478262 8070067M75 X199R 547 8C0A11 93I630 4P4071 029W433619 M3 5 14703818 776366059B9O43393";
		System.out.println(512147826*10);
		System.out.println(atoi(str));
	}

	private static int atoi(String str) {
		int i = 0, n = str.length();
		boolean isNegative = false;
		while(i < n && str.charAt(i) == ' ')
			i++;
		str = str.substring(i);
		System.out.println("After removing leading space : " + str);
		i = 0;
		while(i < str.length() && ((str.charAt(i) >= 48 && str.charAt(i) <= 57) || (str.charAt(i) == 45 || str.charAt(i) == 43)))
			i++;
		str = str.substring(0, i);
		System.out.println("After removing suffix garbage : " + str +  " " + str.length());
		if(str.length() == 0)
			return 0;
		if(str.charAt(0) == '-' || str.charAt(0) == '+') {
			if(str.charAt(0) == '-')
				isNegative = true;
			str = str.substring(1);
			System.out.println("removing signs");
		}
		System.out.println("After removing signs : " + str);
		int ans = 0, prevAns;
		i = 0;
		while(i < str.length()) {
			prevAns = ans;
			ans = ans*10 + (str.charAt(i) - 48);
			System.out.println(prevAns + " " + prevAns + "*10+" + (str.charAt(i) - 48) + "=" + ans);
			if(ans/10 != prevAns) {
				if(isNegative)
					return Integer.MIN_VALUE;
				return Integer.MAX_VALUE;
			}
			i++;
		}
		return isNegative ? -ans : ans;
	}

}
