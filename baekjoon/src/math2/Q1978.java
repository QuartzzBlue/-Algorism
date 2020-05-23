package math2;

import java.io.*;
import java.util.StringTokenizer;

public class Q1978 {

	static boolean isPrimeNum (int n) {
		if(n < 2) {
			return false;
		}
		for(int i = 2; i*i <= n; i++) {
			if(n % i == 0) {
				return false;
			}
		}
		return true;
	}
	
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int qty = Integer.parseInt(br.readLine()); 
		StringTokenizer st = new StringTokenizer(br.readLine());
		int count = 0;
		
		for(int i = 0; i < qty; i++) {
			int num = Integer.parseInt(st.nextToken());
			if(isPrimeNum(num)) {
				count++;
			}
		}
		
		System.out.println(count);
		br.close();

	}	
}
