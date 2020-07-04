package boostCamp2020;

import java.util.ArrayList;

public class Q1 {
	public static void temp (int[] a1) {
		ArrayList<Integer> set = new ArrayList<Integer>();
		int len = a1.length;
		for(int i = 0; i < len; i++) {
			if(!set.contains(a1[i])) {
				set.add(a1[i]);
			}
		}
		System.out.println(set.toString());
		System.out.println(set.size());
	}
	public static void main(String[] args) {
		int[] a1 = {2, 3, 4, 3, 5};
		int[] a2 = {1, 6, 7};
		temp(a1);
	}

	
}
