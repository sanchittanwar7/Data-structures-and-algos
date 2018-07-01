package Maths;


public class grid_unique_path {

	public static void main(String[] args) {
		int row = 2, col = 1;
		System.out.println(uniquePaths(row, col));
	}

	private static int uniquePaths(int row, int col) {
		int[][] arr = new int[row][col];
		int i, j;
		for(i = 0; i < col; i++)
			arr[row-1][i] = 1;
		for(i = 0; i < row; i++)
			arr[i][col-1] = 1;
		i = row-2; j = col-2;
		for(; i >= 0; i--) {
			for(j = col-2; j >= 0; j--) {
				arr[i][j] = arr[i+1][j] + arr[i][j+1];
			}
		}
		return arr[0][0];
	}
	

}
