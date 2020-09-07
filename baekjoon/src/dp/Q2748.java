package dp;

import java.io.BufferedReader;
import java.io.InputStreamReader;

//문제, 피보나치2 
public class Q2748 {
	long[] sum;
	int N;
	
	Q2748(int N){
		this.sum = new long[100];
		this.sum[0] = 0;
		this.sum[1] = 1;
		this.N = N;
	}
	
	public void dp (int idx) {
		sum[idx] = sum[idx-2] + sum[idx-1];
		if(idx == N) return;
		dp(idx+1);
	}
	
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in)); 
		int n = Integer.parseInt(br.readLine());
		
		Q2748 fibo = new Q2748(n);
		if(n >= 2) fibo.dp(2);
		System.out.println(fibo.sum[fibo.N]);
		br.close();
	}

}
