package chapter8;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.Arrays;

public class Asymtiling { // 비대칭 타일링

	private int width;
	private int[] cache;
	private final int MOD = 100000007;
	
	Asymtiling(int width) {
		this.width = width;
		this.cache = new int[101];
		Arrays.fill(cache, -1);
	}
	
	private int asymmetric() { /* 비대칭 타일링 방법 개수 리턴 */
		// width가 짝수인 경우과 홀수인 경우로 나눠서 생각
		if(width % 2 == 1) return (tiling(width) - tiling(width / 2) + MOD) % MOD;
		int ret = tiling(width);
        ret = (ret - tiling(width / 2) + MOD ) % MOD;
        ret = (ret - tiling(width / 2 - 1) + MOD) % MOD;
        return ret;
	}
	
	private int tiling(int len) {
		if(len <= 1) return 1;
		if(cache[len] != -1) return cache[len];
		return cache[len] = (tiling(len - 1) + tiling(len - 2)) % MOD;
	}
	
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		
		int N = Integer.parseInt(br.readLine());
		for(int i = 0; i < N; i++) {
			int n = Integer.parseInt(br.readLine());
			bw.append(new Asymtiling(n).asymmetric() + "\n");
		}
		
		bw.flush();
		br.close();
		bw.close();
	}

}
