package baekjoon;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;

public class Q2741 {

	public static void main(String[] args) throws Exception {
		 BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	       int num = Integer.parseInt(br.readLine());
	       
	       BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
	       for(int i = 1; i < num+1; i++){
	           bw.write(i + "\n");
	       }
	       bw.flush();
	       
	       br.close();
	       bw.close();
	}

}
