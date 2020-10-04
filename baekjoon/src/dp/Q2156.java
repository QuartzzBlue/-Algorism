package dp;

import java.io.BufferedReader;
import java.io.InputStreamReader;

/* 포도주 시식 */
public class Q2156 {
	static int[] wineGlasses;
	static int[] dp;
	
	private static int wineTasting(int glassNum) {
		
		if(glassNum <= 2) {
			return (glassNum == 1 ? wineGlasses[1] : wineGlasses[1] + wineGlasses[2]);
		}
		
		dp[0] = 0;
		dp[1] = wineGlasses[1];
		dp[2] = dp[1] + wineGlasses[2];

		for(int i = 3; i <= glassNum; i++) {
			
			// i번째 잔까지의 최대 값 구하기!
			// 1) i-3번째 잔까지의 최댓값 + i-1번째 잔 + i번째 잔
			// 2) i-2번째 잔까지의 최댓값 + i번째 잔
			// 3) i-1번째 잔까지의 최댓값 (i번째 잔 패스)
			dp[i] = Math.max(dp[i-3] + wineGlasses[i-1] + wineGlasses[i]
					, dp[i-2] + wineGlasses[i]);
			dp[i] = Math.max(dp[i-1], dp[i]);
		}
		
		return dp[glassNum];
		
	}
	
	public static void main(String[] args) throws Exception{
		BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));
		int glassNum = Integer.parseInt(bufferedReader.readLine());
		wineGlasses = new int[glassNum+1];
		dp = new int[glassNum+1];
		
		for(int i = 1; i <= glassNum; i++) {
			wineGlasses[i] = Integer.parseInt(bufferedReader.readLine());
		}
		
		System.out.println(wineTasting(glassNum));

	}
}
