package backtracking;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;

/* N-Queen */
/*
 * ��Ʈ��ŷ(������)�� ��ǥ ����
 * 
 * '����'�� �ٽ� Ű����
 * => � ����� ������ ���� ��, �������� ������ �� ����� �θ���� �ǵ��ư� �� �ٸ� �ڼճ�带 �˻�
 * => Ǯ�̽ð� ����!
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
			// ���� ������ ���
			if(tCol == col) return false;
			// �밢���� ��ġ�� ���
			if(Math.abs(tCol - col) == Math.abs(tRow - row)) return false;
		}
		return true;
	}
	
	private static void nQueen(int qNum) { //ü���ǿ� ���� �� ����
		if(qNum > N) return;
		
		for(int i = 1; i <= N; i++) {
			cols[qNum] = i;
			if(isPossible(qNum)) nQueen(qNum+1);
//			else cols[qNum] = 0;
		}
		
		// ��Ʈ��ŷ�Ǵ� ����! ���� ���·� �ǵ�����.
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
