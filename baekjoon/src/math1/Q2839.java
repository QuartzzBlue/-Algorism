package math1;

import java.io.BufferedReader;
import java.io.InputStreamReader;

public class Q2839 {

	public static void main(String[] args)  throws Exception{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		int num = Integer.parseInt(br.readLine());
		int count = 0;
		
		while(num >= 0) {
			if(num == 0) {
				System.out.println(count);
				return;
			}
			if(num%5 == 0) {
				System.out.println(num/5 + count);
				return;
			}
			num -= 3;
			count++;
		}
		System.out.println(-1);
		return;
	}

}