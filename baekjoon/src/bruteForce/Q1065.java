package bruteForce;

import java.util.Scanner;

public class Q1065 {
	static int CNT = 0;
	static boolean getHansu(int num, int gap) {
		if(num/10 == 0) {
			CNT++;
			return true;
		}
		int b_num = num % 10;
		num = num / 10;
		if(b_num-(num%10) == gap) {
			return getHansu(num, gap);
		}else {
			return false;
		}
		
	}

	public static void main(String[] args) throws Exception{
		Scanner scan = new Scanner(System.in);
		int n = scan.nextInt();
		scan.close();
		
		for(int i = 1; i <= n; i++) {
			if(i<100) {
				CNT++;
				continue;
			}
			int temp = i;
			int gap = temp%10;
			temp /= 10;
			gap -= temp%10;
			getHansu(i, gap);
		}
		System.out.println(CNT);
	}

}
