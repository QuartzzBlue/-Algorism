package math2;

import java.io.*;
import java.util.ArrayList;
import java.util.StringTokenizer;

public class Q2581 {

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		StringTokenizer st = new StringTokenizer(br.readLine());
		int min = Integer.parseInt(st.nextToken()); 
		int max = Integer.parseInt(st.nextToken());
		
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
		
		for(int i = 0; i < pn.size(); i++) {
			bw.write(pn.get(i)+"\n");
		}
		
		bw.flush();
		br.close();
		bw.close();
	}	
}
