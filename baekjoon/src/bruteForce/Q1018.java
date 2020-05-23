package bruteForce;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Q1018 {

	static int CHESS = 8;
	static char[][] board = null;
	
	static int count(int n, int m) {
		
		int check01 = 0;
		int check02 = 0;
		
		for(int k = 0; k < CHESS; k++) {
			for(int l = 0; l < CHESS; l++) {
				if((k + l) % 2  == 0) {
					if(board[n+k][m+l] == 'W') {
						check01++;
					}
				}else {
					if(board[n+k][m+l] == 'B') {
						check01++;
					}
				}
			}
		}
		
		for(int k = 0; k < CHESS; k++) {
			for(int l = 0; l < CHESS; l++) {
				if((k + l) % 2  == 0) {					
					if(board[n+k][m+l] == 'B') {
						check02++;
					}
				}else{
					if(board[n+k][m+l] == 'W') {
						check02++;
					}
				}
			}
		}

		if(check01 >= check02) {
			return check02;
		}else {
			return check01;
		}
		
	}
	
	
	
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		
		int n = Integer.parseInt(st.nextToken()); 
		int m = Integer.parseInt(st.nextToken());  
		int cnt = -1;
		
		StringBuilder sb = new StringBuilder();
		board = new char[n][m];
		
		for(int i = 0; i < n; i++) {
			sb.append(br.readLine());
			for(int j = 0; j < m; j++) {
				board[i][j] = sb.charAt(j);
			}
			sb.delete(0, m);
		}
		br.close();
		
		for(int i = 0; i <= n-CHESS; i++) {
			for(int j = 0; j <= m-CHESS; j++) {
				int temp = count(i, j);
				if(temp == 0) {
					System.out.println(0);
					return;
				}else if(temp < cnt || cnt == -1) {
					cnt = temp;
				}				
			}
		}
		System.out.println(cnt);
	}

}

