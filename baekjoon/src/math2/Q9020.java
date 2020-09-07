package math2;

import java.io.*;
import java.util.ArrayList;

public class Q9020 {
	
	static int MAX = 10000;
	static boolean[] check;
	
	static boolean isPrimeNum(int num) {
		
		if(check[num] == false) {
			return true;
		}else {
			return false;
		}	
	}
	
	static void eratosthenes () {
		
		check = new boolean[MAX+1]; 
		
		for(int i = 2; i <= MAX; i++) {
			for(int j = i*2; j <= MAX; j += i) {
				check[j] = true;
			}
		}
	}

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		ArrayList<Integer> input = new ArrayList<Integer>();
		
		int ans = -1;
		
		int t = Integer.parseInt(br.readLine());
		for(int i = 0; i < t; i++) {
			input.add(Integer.parseInt(br.readLine()));
		}
		
		eratosthenes ();
		
		for(int i = 0; i < t; i++) {
			int n = input.get(i);
			for(int j = 2; j <= n/2; j++) {
				if(isPrimeNum(j)&&isPrimeNum(n-j)) {
					ans = j;				
				}
			}
			bw.write(ans + " " + (n-ans) + "\n");
		}
		
		bw.flush();
	
		br.close();
		bw.close();
	}	
}
