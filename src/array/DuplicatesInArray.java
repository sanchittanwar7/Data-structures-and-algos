package array;

import java.util.Scanner;

public class DuplicatesInArray {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		String ch = "y";
		do{
			Scanner s = new Scanner(System.in);
			int arr[] = CountFrequency.takeInput();
			printDuplicates(arr);
			System.out.println("Give another shot?");
			ch = s.next();
		}while(ch.equals("y"));
	}
	
	private static void printDuplicates(int arr[]){
		for(int i = 0; i < arr.length; i++){
			if(arr[Math.abs(arr[i])] < 0){
				System.out.print(Math.abs(arr[i]));
				arr[Math.abs(arr[i])] = -arr[Math.abs(arr[i])];
			}
			else
				arr[Math.abs(arr[i])] = -arr[Math.abs(arr[i])];
		}
	}

}
