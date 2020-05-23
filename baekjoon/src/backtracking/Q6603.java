package backtracking;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.StringTokenizer;

public class Q6603 {
	static int[] list;
	static int[] lottoNum = new int[6];
	static BufferedWriter bw;
	static int n;
	public static void lotto(int lastIndex, int depth) throws Exception{
		if(depth == 6) {
			for(int i = 0; i < 6; i++) {
				bw.write(lottoNum[i] + " ");
			}
			bw.newLine();
			return;
		}
		
		for(int i = lastIndex + 1; i < n; i++) {
			lottoNum[depth] = list[i];
			lotto(i, depth+1);
			
		}
	}
	
	public static void main(String[] args) throws Exception{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		bw = new BufferedWriter(new OutputStreamWriter(System.out));
		StringTokenizer st = null;
		String input;
	    while(true) {
	    	input = br.readLine();
	    	if(input.equals("0")) break;
	    	st = new StringTokenizer(input);
	    	n = Integer.parseInt(st.nextToken());
	    	list = new int[n];
	    	for(int i = 0; i < n; i++) {
	    		list[i] = Integer.parseInt(st.nextToken());
	    	}
	    	lotto(-1, 0);
	    	bw.newLine();
	    }
	    bw.flush();
	    bw.close();
	    br.close();
	   
	}
	
}
