package String;

import java.util.Scanner;

public class Q2908 {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		String[] pre_nums = sc.nextLine().split(" ");
		sc.close();
		
		int[] nums = new int[2];
		
		for(int i = 0; i < 2; i++) {
			int num = Integer.parseInt(pre_nums[i]);
			nums[i] += (num/100);
			nums[i] += (num%10)*100;
			nums[i] += ((num/10)%10)*10;
		}
		System.out.println(Math.max(nums[0], nums[1]));
		
	}

}
