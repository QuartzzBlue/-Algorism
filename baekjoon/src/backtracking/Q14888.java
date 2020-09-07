package backtracking;

import java.io.*;
import java.util.StringTokenizer;

public class Q14888 {
	static int n;
	static int min = Integer.MAX_VALUE;
	static int max = Integer.MIN_VALUE;
	static int[] nums, sign;
	
	public static void dfs(int depth, int val) {
		if(depth == n) {
			max = Math.max(max, val);
			min = Math.min(min, val);
			return;
		}
		
		for (int i = 0; i < 4; i++) {
			 
            if (sign[i] > 0) {
            	sign[i] -= 1;
                switch (i) {
                case 0:
                    dfs(depth + 1, val + nums[depth]);
                    break;
                case 1:
                    dfs(depth + 1, val - nums[depth]);
                    break;
                case 2:
                    dfs(depth + 1, val * nums[depth]);
                    break;
                case 3:
                    dfs(depth + 1, val / nums[depth]);
                    break;
                }
             // 이거 까먹음 ㅠ 여기까지 왔다는건 실패한거라서 다시 복구해줘야함
                sign[i] += 1;
            }
 
        }
	}
	public static void main(String[] args) throws Exception{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = null;
		n = Integer.parseInt(br.readLine());
		
        nums = new int[n];
        sign = new int[4];
        
        st = new StringTokenizer(br.readLine());
        
        for(int i = 0; i < n; i++) {
        	nums[i] = Integer.parseInt(st.nextToken());
        }
        
        st = new StringTokenizer(br.readLine());
        
        for(int i = 0; i < 4; i++) {
        	sign[i] = Integer.parseInt(st.nextToken());
        }
        
        
        dfs(1, nums[0]);
        System.out.println(max + "\n" + min);
        br.close();
	}
	
}