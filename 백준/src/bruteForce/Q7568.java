package bruteForce;

import java.io.*;
import java.util.StringTokenizer;

public class Q7568{

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = null;
		int testNum = Integer.parseInt(br.readLine());
		int[][] list = new int[testNum][2];
		int[] rank = new int[testNum];
		
        for(int i = 0; i < testNum; i++) {
        	st = new StringTokenizer(br.readLine());
        	list[i][0] = Integer.parseInt(st.nextToken()); //weight       	
        	list[i][1] = Integer.parseInt(st.nextToken()); //height

        }

        for(int i = 0; i < testNum; i++) {
        	rank[i] = 1;
        	for(int j = 0; j <testNum; j++) {
        		if(i != j) {
        			if(list[i][0] < list[j][0] && list[i][1] < list[j][1]) {
            			rank[i]++;
            		}
        		}	
        	}
        }
        
        for(int i = 0; i < testNum; i++) {
        	System.out.print(rank[i]+" ");
        }
        br.close();
	}

}

