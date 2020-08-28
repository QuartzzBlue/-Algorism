package bruteForce;

import java.util.Scanner;

public class Q2231{

	public static void main(String[] args) throws Exception {
		Scanner scan = new Scanner(System.in);
		int num = scan.nextInt();
		int length = (int)(Math.log10(num) + 1);
		int ans = 0;

		for(int i = num-1; i >= num-(9*length); i--) {
			int iLength = (int)(Math.log10(i) + 1);
			int temp = i;
			int sum = 0;
			for(int j = 0; j < iLength; j++) {
				sum += (temp%10);				
				temp = temp/10;
			}
			if(sum + i == num) {
				ans = i;
			}
		}
		System.out.println(ans);
		scan.close();
	}
}

