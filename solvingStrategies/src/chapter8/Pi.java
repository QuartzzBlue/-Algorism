package chapter8;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.Arrays;
import java.util.HashSet;
import java.util.Iterator;
import java.util.Set;


public class Pi {
	int MAX = Integer.MAX_VALUE - 11;
	int[] cache;
	String number;
	
	Pi(String number) {
		this.cache = new int[10002];
		Arrays.fill(cache, -1);
		this.number = number;
	}
	
	private int solve(int idx) {
		if(idx == number.length()) return 0;
		if(cache[idx] != -1) return cache[idx];
		
		cache[idx] = MAX;
		for(int n = 3; n <= 5; n++) {
			if(idx + n <= number.length()) {
				String temp = number.substring(idx, idx+n);
				int difficulty = setDifficulty(temp);
				cache[idx] = Math.min(cache[idx], solve(idx+n) + difficulty);
			    
			}
		}
		return cache[idx];
	}
	
	private int setDifficulty(String str) {
		int len = str.length();
		Set<Integer> set = new HashSet<Integer>();
		int piece = Integer.parseInt(str.substring(0, 1));
		
		for(int n = 1; n < len; n++) {
			int nPiece = Integer.parseInt(str.substring(n, n+1));
			set.add(piece - nPiece);
			piece = nPiece;
		}
		Iterator<Integer> it = set.iterator();
		
		/** 난이도 설정 **/
		if(set.size() == 1) {
			int tmp = Math.abs(it.next());
			if(tmp == 0) return 1;
			else if(tmp == 1) return 2;
			else return 5;
		}else if(set.size() == 2) {
			int tmpA = Math.abs(it.next());
			int tmpB = Math.abs(it.next());
			if(tmpA == tmpB) return 4;
			else return 10;
		}else {
			return 10;
		}
	}
	
	public static void main(String[] args) throws Exception{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		
		int N = Integer.parseInt(br.readLine());
		for(int i = 0; i < N; i++) {
			String num = br.readLine();
			Pi pi = new Pi(num);
			bw.append(pi.solve(0) + "\n");
		}
		bw.flush();
		br.close();
		bw.flush();
	}
}

/* Input
5
12341234
11111222
12122222
22222222
12673939
*/

/* Output
4
2
5
2
14
 */
