package bruteForce;

import java.util.Scanner;

public class Q1527{

	public static void main(String[] args) throws Exception {
		Scanner scan = new Scanner(System.in);
		int a = scan.nextInt();
		int b = scan.nextInt(); 
		scan.close();
		
//		StringBuilder sb = new StringBuilder();
		int cnt = 0;
		boolean check = true;
		
//		for(int i = a; i <= b; i++) {
//			sb.append(i);
//			for(int j = sb.length()-1; j >= 0; j--) {
//				if (sb.charAt(j) != '4' && sb.charAt(j) != '7') {
//					check = false;
//					break;
//				}
//			}
//			if(check == true) {
//				cnt++;
//			}else {
//				check = true;
//			}
//			sb.delete(0, sb.length());
//		}
		
		int temp;
		
		for(int i = a; i <= b; i++) {
			temp = i;
			while(temp != 0) {
				
				if (temp%10 != 4 && temp%10 != 7) {
					System.out.println(temp);
					check = false;
					break;	
				}
				temp = temp / 10;
			}
			if(check == true) {
				cnt++;
			}else {
				check = true;
			}
		}
		System.out.println(cnt);
	}
}

