package dp;

import java.io.BufferedReader;
import java.io.InputStreamReader;

/* ������ �ý� */
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
			
			// i��° �ܱ����� �ִ� �� ���ϱ�!
			// 1) i-3��° �ܱ����� �ִ� + i-1��° �� + i��° ��
			// 2) i-2��° �ܱ����� �ִ� + i��° ��
			// 3) i-1��° �ܱ����� �ִ� (i��° �� �н�)
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
