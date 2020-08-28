package Sorting;

import java.io.BufferedWriter;
import java.io.OutputStreamWriter;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Scanner;

public class Q1427 {

	public static void main(String[] args) throws Exception {
		Scanner scan = new Scanner(System.in);
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		String num = scan.nextLine();
		
		
		ArrayList<Integer> nums = new ArrayList<>();
		
		for(int i = 0; i < num.length(); i++) {
			nums.add(Integer.parseInt(num.substring(i, i+1)));
		}
		
		Collections.sort(nums);
		for(int j = nums.size()-1; j >= 0 ; j--) {
			bw.write(nums.get(j)+"");
		}
		scan.close();
		bw.flush();
		bw.close();
	}

}
