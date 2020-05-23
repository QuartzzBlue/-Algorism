package baekjoon;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.StringTokenizer;

public class Q15552 {

	public static void main(String[] args) throws Exception {
		BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer token = null;
		int num = Integer.parseInt(bf.readLine());
		int[] output = new int[num];
		
		
		for(int i = 0; i < num; i++) {
			String line = bf.readLine();
			token = new StringTokenizer(line);
			int a = Integer.parseInt(token.nextToken());
			int b = Integer.parseInt(token.nextToken());
			output[i] = a + b;
		}
		
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		
		for(int i = 0; i < num; i++) {
			bw.write(output[i]+"\n");
		}
		bw.flush();
		
		bf.close();
		bw.close();
	}

}
