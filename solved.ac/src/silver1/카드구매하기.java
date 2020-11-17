package silver1;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class 카드구매하기 {
	static int[] cardpack;
	static int N;
	static long dp[];
	
	static void purchase(int credit, int number) {
		if(number == N) {
			dp[N] = Math.max(dp[N], credit);
			return;
		}
		
		for(int i = 1; i <= N-number; i++) {
			if(dp[number+i] < credit+cardpack[i]) {
				dp[number+i] = credit+cardpack[i];
				purchase(credit+cardpack[i], number+i);
			}
			
		}
	}
	
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		N = Integer.parseInt(br.readLine());
		cardpack = new int[N+1];
		dp = new long[N+1];
		StringTokenizer st = new StringTokenizer(br.readLine());
		
		for(int i = 1; i <= N; i++) {
			cardpack[i] = Integer.parseInt(st.nextToken());
		}
		
		purchase(0, 0);
		System.out.println(dp[N]);
		br.close();
	}
}
