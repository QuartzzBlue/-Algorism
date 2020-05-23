package String;

import java.io.BufferedReader; 
import java.io.InputStreamReader; 

public class Q1316 {
	static int result = 0;
	
	private static void check(String input) {
		boolean[] alpabet = new boolean[26]; 
		int length = input.length(); 
		int i; 
		for(i=0; i<length; i++) { 
			char temp = input.charAt(i); 
			if(alpabet[temp-'a']) {
				return; 
			}else { 
				if(i< length-1 && temp != input.charAt(i+1)) { 
					alpabet[temp-'a'] = true; 
				} 
			}
		}
		
		result++;	
	} 
	
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in)); 
		int n = Integer.parseInt(br.readLine()); 
		for(int i = 0; i < n; i ++) { 
			String input = br.readLine().trim(); 
			check(input);
		} 
		System.out.print(result); 
	}

}