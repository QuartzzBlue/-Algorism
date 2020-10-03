package dp;

import java.util.Scanner;

/* LCS (Longest Common Subsequence : 최장 길이 공통 수열) */
// https://www.youtube.com/watch?v=P-mMvhfJhu8&feature=youtu.be\

public class Q9251 {
	static int shortLength;
	static int[][] dp;
	static String str1, str2;
	
	private static void dynamicProgramming() {
		
		for(int rowNum = 1; rowNum <= str1.length(); rowNum++) {
			for(int colNum = 1; colNum <= str2.length(); colNum++) {
				
				if(str1.charAt(rowNum-1) == str2.charAt(colNum-1)) {
					dp[rowNum][colNum] = dp[rowNum-1][colNum-1] + 1;
				}else {
					dp[rowNum][colNum] = Math.max(dp[rowNum][colNum-1], dp[rowNum-1][colNum]);
				}
			}
		}
	}
	
	public static void main(String[] args) {
		Scanner scanner = new Scanner(System.in);
		str1 = scanner.nextLine();
		str2 = scanner.nextLine();
		
		dp = new int[str1.length()+1][str2.length()+1];
		
		dynamicProgramming();
		System.out.println(dp[str1.length()][str2.length()]);
		
		scanner.close();
		
	}
}
