package recursion;

import java.util.ArrayList;
import java.util.Arrays;

public class sudoku {

	public static void main(String[] args) {
		ArrayList<ArrayList<Character>> a = new ArrayList<>();
		a.add(new ArrayList<>(Arrays.asList('5','3', '.', '.', '7', '.', '.', '.', '.')));
		a.add(new ArrayList<>(Arrays.asList('6','.', '.', '1', '9', '5', '.', '.', '.')));
		a.add(new ArrayList<>(Arrays.asList('.','9', '8', '.', '.', '.', '.', '6', '.')));
		a.add(new ArrayList<>(Arrays.asList('8','.', '.', '.', '6', '.', '.', '.', '3')));
		a.add(new ArrayList<>(Arrays.asList('4','.', '.', '8', '.', '3', '.', '.', '1')));
		a.add(new ArrayList<>(Arrays.asList('7','.', '.', '.', '2', '.', '.', '.', '6')));
		a.add(new ArrayList<>(Arrays.asList('.','6', '.', '.', '.', '.', '2', '8', '.')));
		a.add(new ArrayList<>(Arrays.asList('.','.', '.', '4', '1', '9', '.', '.', '5')));
		a.add(new ArrayList<>(Arrays.asList('.','.', '.', '.', '8', '.', '.', '7', '9')));
		solveSudoku(a);
		for(ArrayList<Character> row : a) {
			System.out.println(row);
		}
	}
	
//	public static boolean sudoku(int row,int col,ArrayList<ArrayList<Character>> board){
//        if(row>=9){
//            return true;
//        }
//        if(col>=9){
//            return sudoku(row+1,0,board);
//        }
//        if(board.get(row).get(col)!='.'){
//            return sudoku(row,col+1,board);
//        }
//        boolean[] possibilities = new boolean[9];
//        for(int i=0;i<9;i++){
//            possibilities[i] = true;
//        }
//        for(int i=0;i<9;i++){
//            if(board.get(i).get(col)!='.'){
//                possibilities[Character.getNumericValue(board.get(i).get(col))-1] = false;
//            }
//        }
//        for(int j=0;j<9;j++){
//            if(board.get(row).get(j)!='.'){
//                possibilities[Character.getNumericValue(board.get(row).get(j))-1] = false;
//            }
//        }
//        int up = (row)%3, down = 3-up-1;
//        int left = col%3, right = 3-left-1;
//        for(int i=row-up;i<=row+down;i++){
//            for(int j=col-left;j<=col+right;j++){
//                if(board.get(i).get(j)!='.'){
//                    possibilities[Character.getNumericValue(board.get(i).get(j))-1] = false;
//                }
//            }
//        }
//        /*for(int i=0;i<9;i++){
//            System.out.print(possibilities[i]+" ");
//        }
//        System.out.println();*/
//        for(int i=0;i<9;i++){
//            if(possibilities[i]){
//                board.get(row).set(col,(char)(i+1+'0'));
//                if(sudoku(row,col+1,board)){
//                    return true;
//                }
//                board.get(row).set(col,'.');
//            }
//        }
//        return false;
//    }
//    public static void solveSudoku(ArrayList<ArrayList<Character>> a) {
//        sudoku(0,0,a);
//    }
//	
	public static void solveSudoku(ArrayList<ArrayList<Character>> a) {
		helper(a, 0);
    }

	private static boolean helper(ArrayList<ArrayList<Character>> a, int i) {
		if(i >= 81)
			return true;
		int row = i/9;
		int col = i%9, boxCol, boxRow;
		if(a.get(row).get(col) != '.')
			helper(a, i+1);
		if(row >= 0 && row <=2)
			boxRow = 0;
		else if(row >= 3 && row <= 5)
			boxRow = 3;
		else 
			boxRow = 6;
		if(col >= 0 && col <=2)
			boxCol = 0;
		else if(col >= 3 && col <= 5)
			boxCol = 3;
		else 
			boxCol = 6;
		boolean isPossible = false;
		ArrayList<Integer> possible = new ArrayList<>(Arrays.asList(1,2,3,4,5,6,7,8,9));
		for(Character val : a.get(row)) {
			if(val != '.') {
				possible.remove(new Integer(val - 48));
			}
		}
		for(ArrayList<Character> line : a) {
			if(line.get(col) != '.') {
				possible.remove(new Integer(line.get(col) - 48));
			}
		}
		for(int j = 0; j < 3; j++) {
			for(int k = 0; k < 3; k++) {
				if(a.get(boxRow+j).get(boxCol+k) != '.') {
					possible.remove(new Integer(a.get(boxRow+j).get(boxCol+k) - 48));
				}
			}
		}
		for(Integer ele : possible) {
			a.get(row).set(col, (char)(ele+48));
			isPossible = helper(a, i+1);
			if(isPossible)
				return true;
		}
		return false;
	}

}
