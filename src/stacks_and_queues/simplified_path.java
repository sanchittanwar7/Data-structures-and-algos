package stacks_and_queues;

import java.util.Arrays;
import java.util.Stack;

public class simplified_path {

	public static void main(String[] args) {
		String str = "/a/./b/../../c/";
		String str1 = "/../";
		String str2 = "/./../../giq/xns/zvk/../vkd/qhp/pyf/wie/atv/thv/./kqs/seq/fzw/cav/./../.././rjn/elx/gyn/lla/gkd/zig/qud/vyx/./eqd/ple/vst/loc/./../uak/wvz/vxe/ibc/../bns/psb/./kjo/bky/oks/./cjg/yyh/spf/abt";

		System.out.println(simplifyPath(str));
		System.out.println(simplifyPath(str1));
		System.out.println(simplifyPath(str2));

	}
	
	public static String simplifyPath(String str) {
		Stack<String> s = new Stack<>();
		String sp[] = str.split("/");
		System.out.println(Arrays.toString(sp));
		StringBuilder ans = new StringBuilder("");
		for(String dir : sp) {
			if(dir.equals("..")) {
				if(s.isEmpty())
					continue;
				s.pop();
			}
			else if(dir.equals(".") || dir.equals(""))
				continue;
			else
				s.push(dir);
		}
		if(s.isEmpty())
			return "/";
		while(!s.isEmpty()) {
			ans = ans.insert(0, "/"+s.pop());
		}
		return ans.toString();
	}

}
