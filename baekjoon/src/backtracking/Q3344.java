package backtracking;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;

/* N-Queen */
/*
 * 백트래킹(되추적)의 대표 문제
 * 
 * '배제'가 핵심 키워드
 * => 어떤 노드의 유망성 점검 후, 유명하지 않으면 그 노드의 부모노드로 되돌아간 후 다른 자손노드를 검색
 * => 풀이시간 단축!
 * 
 * https://idea-sketch.tistory.com/29
 */
public class Q3344 {
	static int N;
	static int[] cols;
	
	private static boolean isPossible(int row) {
		int col = cols[row];
		for(int tRow = 0; tRow < row; tRow++) {
			int tCol = cols[tRow];
			// 열이 동일한 경우
			if(tCol == col) return false;
			// 대각선에 위치한 경우
			if(Math.abs(tCol - col) == Math.abs(tRow - row)) return false;
		}
		return true;
	}
	
	private static void nQueen(int qNum) { //체스판에 놓은 퀸 개수
		if(qNum > N) return;
		
		for(int i = 1; i <= N; i++) {
			cols[qNum] = i;
			if(isPossible(qNum)) nQueen(qNum+1);
//			else cols[qNum] = 0;
		}
		
		// 백트래킹되는 시점! 이전 상태로 되돌린다.
//		cols[qNum] = 0;
	}
	
	public static void main(String[] args) throws Exception{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in)); 
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		N = Integer.parseInt(br.readLine());
		cols = new int[N+1];
		
		nQueen(0);
		
		for(int i = 1; i <= N; i++) {
			bw.append(cols[i]+"\n");
		}
		bw.flush();
		br.close();
		bw.close();
	}

}
