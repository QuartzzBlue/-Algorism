package math2;

import java.io.*;
import java.util.StringTokenizer;

public class Q3009 {
	
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = null;
		int[] x = new int[3];
		int[] y = new int[3];
		for(int i = 0; i < 3; i++) {
			st = new StringTokenizer(br.readLine());
			x[i] = Integer.parseInt(st.nextToken());
			y[i] = Integer.parseInt(st.nextToken());
		}
		if(x[0] == x[1])
			System.out.print(x[2]+" ");
		else if(x[0] == x[2]) 
			System.out.print(x[1]+" ");
		else if(x[1] == x[2])
			System.out.print(x[0]+" ");
		
		if(y[0] == y[1])
			System.out.print(y[2]);
		else if(y[0] == y[2]) 
			System.out.print(y[1]);
		else if(y[1] == y[2])
			System.out.print(y[0]);
		
		
		br.close();
		

	}	
}
