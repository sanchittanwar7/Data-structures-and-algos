package array;

public class SearchInSortedMatrix {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		int[][] mat =  {   { 2, 6, 7, 11},
                { 3, 8, 10, 12},
                { 4, 9, 11, 13},
                { 5, 15, 16, 18}
                };
		System.out.println(search(mat, 4, 17));
	}

	private static boolean search(int[][] mat, int n, int num) {
		if(num < mat[0][0] || num > mat[n-1][n-1])
			return false;
		int r = 0, c = n-1;
		while(r <= n-1 && c >= 0){
			if(num > mat[r][c])
				r++;
			else if (num < mat[r][c])
				c--;
			else
				return true;
		}
		return false;
	}

}
