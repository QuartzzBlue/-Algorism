package backtracking;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Q1987 {
	static boolean[] check = new boolean['Z'+1];
	static char[][] board;
	static int maxDist = -1;
	static int row, col;
	
	public static void dfs(int r, int c, int dist) {
		
		if(check[board[r][c]] == true) {
			
			maxDist = Math.max(maxDist, dist-1);
			return;
		}
		
		int[] dx = {-1, 1, 0, 0}, dy = {0, 0, -1, 1}; // north, south, west, east
		
		check[board[r][c]] = true;
		for(int i = 0; i < 4; i++) { //동서남북 방향으로 모두 돌기
			int tr = r + dx[i];
			int tc = c + dy[i];
			if(tr >= 0 && tc >= 0 && tr < row && tc < col) {
				dfs(tr, tc, dist+1);
			}
		}
		check[board[r][c]] = false;
		
		
	}
	
	public static void main(String[] args) throws Exception{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		row = Integer.parseInt(st.nextToken());
		col = Integer.parseInt(st.nextToken());
		board = new char[row][col];
		for(int i = 0; i < row; i++) {
			String temp = br.readLine();
			for(int j = 0; j < col; j++) {
				board[i][j] = temp.charAt(j);
			}
		}
		dfs(0, 0, 1);
		System.out.println(maxDist);
		br.close();
	}
}
