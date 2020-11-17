package silver1;

import java.util.Arrays;
import java.util.Scanner;

public class 쉬운계단수 {
	static final long MOD = 1000000000;
	static long[][] dp;
	
	public static long recur (int length, int digit) {
		if(length == 1) {
			return dp[1][digit];
		}
		
		if(dp[length][digit] == 0) {
			if(digit == 0) {
				dp[length][digit] = recur(length-1, 1) % MOD;
			}else if(digit == 9) {
				dp[length][digit] = recur(length-1, 8) % MOD;
			}else {
				dp[length][digit] = recur(length-1, digit-1) % MOD + recur(length-1, digit+1) % MOD;
			}
		}
		
		
		return dp[length][digit];
	}
	
	public static void main(String[] args) {
		Scanner scanner = new Scanner(System.in);
		int n = scanner.nextInt();
		long ans = 0;
		dp = new long[n+1][10];
		
		Arrays.fill(dp[1], 1);
		
		for(int i = 1; i < 10; i++) {
			ans = (recur(n, i) + ans) % MOD;
		}
		
		System.out.println(ans);
		scanner.close();
	}
}
