package chapter8;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.StringTokenizer;

/** (Longest Increasing Subsequence) 최대 증가 부분 수열 **/
public class Jlis { 
	int[][] cache;
	ArrayList<Integer> arrA;
	ArrayList<Integer> arrB;

	Jlis() {
		this.cache = new int[101][101];
		for(int[] arr : this.cache) {
			Arrays.fill(arr, -1);
		}
		arrA = new ArrayList<Integer>();
		arrB = new ArrayList<Integer>();
	}
	
//	private int solve(int aIdx, int bIdx) {
//		
//		if(cache[aIdx][bIdx] != -1) return cache[aIdx][bIdx];
//		
//		cache[aIdx][bIdx] = 2;
//		
//		long a = arrA.get(aIdx);
//		long b = arrB.get(bIdx);
//		long max = Math.max(a, b);
//	
//		for(int anIdx = aIdx+1; anIdx < arrA.size(); anIdx++) {
//			if(max < arrA.get(anIdx)) 
//				cache[aIdx][bIdx] = Math.max(cache[aIdx][bIdx], solve(anIdx, bIdx)+1);
//		}
//		for(int bnIdx = bIdx+1; bnIdx < arrB.size(); bnIdx++) {
//			if(max < arrB.get(bnIdx)) 
//				cache[aIdx][bIdx] = Math.max(cache[aIdx][bIdx], solve(aIdx, bnIdx)+1);
//		}
////		cache[aIdx][bIdx] = ret;
//		
//		for(int i = 0; i < 6; i++) {
//			for (int j = 0; j < 6; j++) {
//				System.out.print(cache[i][j] + " ");
//			}
//			System.out.println();
//		}
//		System.out.println();
//		
//		return cache[aIdx][bIdx];
//	}
	
	private int solve(int aIdx, int bIdx) {
//		for(int i = 0; i < 6; i++) {
//			for (int j = 0; j < 6; j++) {
//				System.out.print(cache[i][j] + " ");
//			}
//			System.out.println();
//		}
//		System.out.println();
		
		if(cache[aIdx+1][bIdx+1] != -1) return cache[aIdx+1][bIdx+1];
			
		int ret = 2;
		long a = aIdx == -1 ? Long.MIN_VALUE : arrA.get(aIdx);
		long b = bIdx == -1 ? Long.MIN_VALUE : arrB.get(bIdx);
		long max = Math.max(a, b);
	
		for(int anIdx = aIdx+1; anIdx < arrA.size(); anIdx++) {
			if(max < arrA.get(anIdx)) 
				ret = Math.max(ret, solve(anIdx, bIdx)+1);
		}
		for(int bnIdx = bIdx+1; bnIdx < arrB.size(); bnIdx++) {
			if(max < arrB.get(bnIdx)) 
				ret = Math.max(ret, solve(aIdx, bnIdx)+1);
		}
		cache[aIdx+1][bIdx+1] = ret;
		return ret;
	}
	
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		int N = Integer.parseInt(br.readLine());
		for(int n = 0; n < N; n++) {
			Jlis jlis = new Jlis();
			StringTokenizer st = new StringTokenizer(br.readLine());
			int aN = Integer.parseInt(st.nextToken());
			int bN = Integer.parseInt(st.nextToken());
			st = new StringTokenizer(br.readLine());
			for(int a = 0; a < aN; a++) jlis.arrA.add(Integer.parseInt(st.nextToken()));
			st = new StringTokenizer(br.readLine());
			for(int b = 0; b < bN; b++) jlis.arrB.add(Integer.parseInt(st.nextToken()));
			bw.append(jlis.solve(-1, -1) + "\n");
//			bw.append(jlis.solve(0, 0) + "\n");
			
//			for(int i = 0; i < 8; i++) {
//				for (int j = 0; j < 8; j++) {
//					System.out.print(jlis.cache[i][j] + " ");
//				}
//				System.out.println();
//			}
		}
		
		bw.flush();
		bw.close();
		br.close();
	}
}

/* Input
3
3 3
1 2 4
3 4 7
3 3
1 2 3
4 5 6
5 3
10 20 30 1 2
10 20 30
*/

/* Output
5
6
5
 */