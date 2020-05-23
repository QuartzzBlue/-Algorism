package bruteForce;

import java.util.Scanner;

public class Q2858{

	public static void main(String[] args) throws Exception {
		Scanner scan = new Scanner(System.in);
		int r = scan.nextInt();
		int b = scan.nextInt();
		
		
		int sum = (r+4)/2;
		int w, l;
		for(w = 3; w < sum; w++) {
			l = sum-w;
			if((w-2)*(l-2) == b) {
				System.out.println(l + " " + w);
				scan.close();
				return;
			}
		}
	}
}

