package chapter8;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.StringTokenizer;

public class Quantization {
	static int int_MAX = 987654321;
	static ArrayList<Integer> list;
	static int N;
	int[][] cache;
	
	Quantization() {
		cache = new int[101][11];
		for(int[] arr : cache) Arrays.fill(arr, -1);
		Collections.sort(list);
	}
	
	private int quantize(int idx, int parts) {
		if(idx == N) return 0;
		// ★☆★☆ 파트 다 묶었는데 숫자 남았을 때 예외처리! -> 큰 수 리턴시켜서 남은 연산에서 걸러지도록 처리
		if(parts == 0) return int_MAX;
		if(cache[idx][parts] != -1) return cache[idx][parts];
		
		cache[idx][parts] = int_MAX;
		for(int pSize = 1; idx + pSize <= N; pSize++) { // pSize = 한 파트의 사이즈
			cache[idx][parts] = Math.min(cache[idx][parts], 
									quantize(idx+pSize, parts-1) + minError(idx, idx+pSize));
		}
		
		return cache[idx][parts];
	}
	
	private int minError(int start, int end) {
		int sum = 0;
		int sqSum= 0;
		
		for(int i = start; i < end; i++) {
			sum += list.get(i);
			sqSum += list.get(i) * list.get(i);
		}
		int avg = Math.round((float)(sum / (end - start)));
		int ret = sqSum - 2*avg*sum + avg*avg*(end-start);
		return ret;
	}
	
	public static void main(String[] args) throws Exception{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		list = new ArrayList<Integer>();
		int caseN = Integer.parseInt(br.readLine());
		for(int i = 0; i < caseN; i++) {
			StringTokenizer st = new StringTokenizer(br.readLine());
			N = Integer.parseInt(st.nextToken());
			int q = Integer.parseInt(st.nextToken());
			st = new StringTokenizer(br.readLine());
			for(int j = 0; j < N; j++) {
				list.add(Integer.parseInt(st.nextToken()));
			}
			bw.append(new Quantization().quantize(0 , q) + "\n");
			list.clear();
		}
		bw.flush();
		br.close();
		bw.close();
	}

}

/* Input
2
10 3
3 3 3 1 2 3 2 2 2 1
9 3
1 744 755 4 897 902 890 6 777
 */
/* Output
0
651
*/