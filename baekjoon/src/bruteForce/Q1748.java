package bruteForce;

import java.util.Scanner;

public class Q1748{

	public static void main(String[] args) throws Exception {
		Scanner scan = new Scanner(System.in);
		int num = scan.nextInt();
		int length = 0;
		StringBuilder sb = new StringBuilder();
		
		for(int i = 1; i <= num; i++) {
			sb.append(i);
			length += sb.length();
			sb.delete(0, sb.length());
		}
		System.out.println(length);
		scan.close();
	}
}

