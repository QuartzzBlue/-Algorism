package bruteForce;

import java.util.*;
import java.io.*;
 
class Q10448 {
	static ArrayList<Integer> gauss;
	static int triangleSum(int num) {
		for(int i = 0; i < gauss.size(); i++) {
			for(int j = 0; j < gauss.size(); j++) {
				for(int l = 0; l < gauss.size(); l++) {
					if(gauss.get(i) + gauss.get(j) + gauss.get(l) == num) {
						return 1;
					}
				}
			}
		}
		return 0;
	}
	
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        int n = Integer.parseInt(br.readLine());
        int[] nums = new int[n];
        gauss = new ArrayList<Integer>();
        
        for(int i=0; i<n; i++) {
            nums[i] = Integer.parseInt(br.readLine());
        }
        
        int k = 1;
        while(k*(k+1)/2 < 1000) {
        	gauss.add(k*(k+1)/2);
        	k++;
        }
        
        for(int i = 0; i < n ; i++) {
        	bw.write(triangleSum(nums[i])+"\n");
        }
        bw.flush();
        bw.close();
        br.close();
    }
}