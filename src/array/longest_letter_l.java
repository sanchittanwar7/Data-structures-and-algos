package array;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;

class dimension{
	int height;
	int width;

	dimension(int h, int w){
		this.height = h;
		this.width = w;
	}
}

public class longest_letter_l {

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		String nums = br.readLine();
		int r = Integer.parseInt(nums.split(" ")[0]);
		int c = Integer.parseInt(nums.split(" ")[1]);
		int i;
		char arr[][] = new char[r][c];
		for(i = 0; i < r; i++)
			arr[i] = br.readLine().toCharArray();
		long ans = func(arr, r, c);
		if(ans == -1)
			System.out.println("NO");
		else {
			System.out.println("YES");
			System.out.println(ans);
		}
	}

	private static long func(char[][] arr, int r, int c) {
		dimension ans[][] = new dimension[r][c];
		int i, j, vertical, horizontal;
		long answer = -1;
		for(i = 0; i < r; i++) {
			for(j = c-1; j >= 0; j--) {
				if(arr[i][j] == '*') {
					ans[i][j] = new dimension(0, 0);
				}
				else {
					vertical = i > 0 ? ans[i-1][j].width > 1 ? 0 : ans[i-1][j].height : 0;
					horizontal = j != c-1 ? ans[i][j+1].height > 1 ? 0 : ans[i][j+1].height : 0;
					ans[i][j] = new dimension(vertical+1, horizontal+1);
					if(ans[i][j].height != 0 && ans[i][j].width != 0 && answer < ans[i][j].height + ans[i][j].width - 1) {
						answer = ans[i][j].height + ans[i][j].width - 1;
					}
				}
			}
		}
		for(i = 0; i < r; i++) {
			for(j = 0; j < c; j++)
				System.out.print(ans[i][j].height + ", " + ans[i][j].width + "------");
			System.out.println();
		}
		return answer;
	}

}
