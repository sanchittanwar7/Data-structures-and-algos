package hashing;

import java.util.HashMap;

public class tp {

	public static void main(String[] args) {
		HashMap<Integer, Integer> m1 = new HashMap<>();
		m1.put(1, 1);
		HashMap<Integer, Integer> m2 = (HashMap<Integer, Integer>) m1.clone();
		m2.remove(1);
		System.out.println(m1);
		System.out.println(m2);
	}

}
