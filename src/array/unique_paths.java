package array;

public class unique_paths {

	public static void main(String[] args) {
		int a[][] = {{0,0,0}, {0,1,0}, {0,0,0}};
		System.out.println(uniquePathsWithObstacles(a));
	}

	public static int uniquePathsWithObstacles(int[][] a) {
		int m = a.length, n = a[0].length;
		int arr[][] = new int[m][n], i, j, top, right;
		for(i = 0; i < a.length; i++){
            if(a[i][0] == 1)
                break;
			arr[i][0] = 1;
        }
		for(i = 0; i < a[0].length; i++){
            if(a[0][i] == 1)
                break;
			arr[0][i] = 1;
        }
		for(i = 1; i < m; i++) {
			for(j = 1; j < n; j++) {
                if(a[i][j] == 1)
                    arr[i][j] = 0;
                else{
                    top = a[i-1][j] == 1 ? 0 : arr[i-1][j];
                    right = a[i][j-1] == 1 ? 0 : arr[i][j-1];
                    arr[i][j] = top + right;
                }
			}
		}
		return arr[m-1][n-1];
	}

}
