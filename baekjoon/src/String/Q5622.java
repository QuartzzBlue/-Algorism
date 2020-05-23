package String;

import java.util.Scanner;

public class Q5622 {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		String word = sc.nextLine().trim().toUpperCase();
		sc.close();
		int sec = 0;
		
		for(int i = 0; i < word.length(); i++) {
			
			int temp = (int)(word.charAt(i));
			if(temp < 'A') {
				sec += 11;
			}else if(temp <= 'C') {
				sec += 3;
			}else if(temp <= 'F') {
				sec += 4;
			}else if(temp <= 'I') {
				sec += 5;
			}else if(temp <= 'L') {
				sec += 6;
			}else if(temp <= 'O') {
				sec += 7;
			}else if(temp <= 'S') {
				sec += 8;
			}else if(temp <= 'V') {
				sec += 9;
			}else if(temp <= 'Z') {
				sec += 10;
			}
		}
		System.out.println(sec);
	}
}
