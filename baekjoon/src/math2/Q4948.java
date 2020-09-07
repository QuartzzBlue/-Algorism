package math2;

import java.io.*;
import java.util.ArrayList;

public class Q4948 {

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int min = Integer.parseInt(br.readLine()); 
		int max = Integer.parseInt(br.readLine());
		int sum = 0;
		ArrayList<Integer> pn = new ArrayList<Integer>();
		boolean[] check = new boolean[max+1];
		
		for(int i = 2; i <= max; i++) {
			if(i >= min && check[i] == false) {
				pn.add(i);
			}
			for(int j = i*2; j <= max; j += i) {
				check[j] = true;
			}
		}
		
		if(pn.size() == 0) {
			System.out.println(-1);
		}else {
			for(int i = 0; i < pn.size(); i++) {
				sum += pn.get(i);
			}
			
			System.out.println(sum+"\n"+pn.get(0));
		}
		
		br.close();

	}	
}
