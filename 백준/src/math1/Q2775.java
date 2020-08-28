package math1;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;


public class Q2775 {

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		
		int[][] apartment = new int[15][15];
		for(int i = 1; i < 15; i++) {
			apartment[0][i] = i; 
		}
		
		for(int f = 1; f < 15; f++) {
			for(int n = 1; n < 15; n++) {
				for(int u = 1; u <= n; u++) {
					apartment[f][n] += apartment[f-1][u]; 
				}
			}
		}
		
		int t = Integer.parseInt(br.readLine());
		int floor, num;
		
		for(int i = 0; i < t; i++) {
			floor = Integer.parseInt(br.readLine());
			num = Integer.parseInt(br.readLine());
			bw.write(apartment[floor][num]+"\n");
		}
		
		bw.flush();
		br.close();
		bw.flush();
		
		
		
	}	
}
