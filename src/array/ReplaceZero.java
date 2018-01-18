package array;

public class ReplaceZero {

	/**
	 * @param args
	 */
	
	//0 1 1 1 0 1 0
	//0 0 1 1 1 1 0 0 1 1 1 1 0 1 1 0 1 0 1 1 1 1 0
	public static void main(String[] args) {
		int arr[] = CountFrequency.takeInput();
		System.out.println(replaceZero(arr));
	}

	private static int replaceZero(int[] arr) {
		int prevPrev = -1, current = arr.length, prev = -1, ans;
		int i = 0;
		while(i < arr.length){
			if(arr[i] == 0){
				prev = i;
				i++;
				while(i < arr.length){
					if(arr[i] == 0){
						current = i;
						break;
					}
					i++;
				}
			}
			if(current != arr.length)
				break;
			i++;
		}
		System.out.println(prevPrev + " " + prev + " " + current);
//		return -1;
		i = current + 1;
		int len = current - prevPrev - 1;
		ans = prev;
		while(i < arr.length){
			while(i < arr.length && arr[i] == 1)
				i++;
			prevPrev = prev;
			prev = current;
			current = i;
			if(len < current - prevPrev - 1){
				len = current - prevPrev - 1;
				ans = prev;
			}
			i++;
		}
		return ans;
	}

}
