package backtracking;

import java.io.*;
import java.util.StringTokenizer;

public class Q2580 {
	static int[][] sdoku = new int[9][9];
//	public static void dfs(int row) {
//		if(row == 8) {
//			
//		}
//		
//		for(int i = 0; i < 9; i++) {
//			if(sdoku[row][i] == 0) {
//				for(int j = 1; j <= 9; j++) {
//					sdoku[row][i] = j;
//					isRight(row, col);
//					
//				}
//				sdoku[row][i] = 0;
//			}
//		}
//		
//	}
//	public static boolean isRight(int row, int col) {
//		if (checkRow(r, n) && checkCol(c, n, 0) && checkBox(r, c, n)) { 
//			return true; 
//		} 
//		return false;
//
//	}
	
	public static void main(String[] args) throws Exception{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = null;
        for(int i = 0; i < 9; i++) {
        	st = new StringTokenizer(br.readLine());
        	for(int j = 0; j < 9; j++) {
        		sdoku[i][j] = Integer.parseInt(br.readLine());
        	}
        	 
        }
		
        br.close();
	}
	
}