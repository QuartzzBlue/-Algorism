package dfs;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.StringTokenizer;

/* 테트로미노 */
/* 브루트포스 + dfs */

public class Q14500 {

	static int[] directionRow = {-1, 0, 1, 0};
	static int[] directionCol = {0, 1, 0, -1};
	static int[][] map;
	static boolean[][] visited;
	static ArrayList<Integer> wings = new ArrayList<Integer>();
	static int rowNum;
	static int colNum;
	static int maxSum = Integer.MIN_VALUE;
	
	private static void tetris(int blockNum, int sum, int row, int col) {
		if(blockNum == 4) {
			maxSum = Math.max(maxSum, sum);
			return;
		}
		
		// 'ㅗ' 를 제외한 다른 블럭들
		for(int d = 0; d < 4; d++) {
			int nextRow = row + directionRow[d];
			int nextCol = col + directionCol[d];
			if(nextRow >= 0 && nextRow < rowNum && nextCol >= 0 && nextCol < colNum) {
				if(visited[nextRow][nextCol]) {
					continue;
				}
				visited[nextRow][nextCol] = true;
				tetris(blockNum + 1, sum + map[nextRow][nextCol], nextRow, nextCol);
				visited[nextRow][nextCol] = false;
			}
		}
	}
	
	// 'ㅗ' 블럭
	private static void exceptions(int row, int col) {
		int sum = map[row][col];
		
		for(int d = 0; d < 4; d++) {
			int nextRow = row + directionRow[d];
			int nextCol = col + directionCol[d];
			
			if(nextRow >= 0 && nextRow < rowNum && nextCol >= 0 && nextCol < colNum) {
				if(map[nextRow][nextCol] != 0) {
					wings.add(map[nextRow][nextCol]);
					sum += map[nextRow][nextCol];
				}
			}		
		}
		if(wings.size() <= 2) {
			return;
		}else if (wings.size() == 3){
			maxSum = Math.max(maxSum, sum);
		}else {
			for(int d = 0; d < wings.size(); d++) {
				maxSum = Math.max(maxSum, sum-wings.get(d));	
			}
		}
		wings.clear();
		
	}
	
	public static void main(String[] args) throws Exception{
		BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer stringTokenizer = new StringTokenizer(bufferedReader.readLine());
		rowNum = Integer.parseInt(stringTokenizer.nextToken());
		colNum = Integer.parseInt(stringTokenizer.nextToken());
		map = new int[rowNum][colNum];
		visited = new boolean [rowNum][colNum];
		
		for(int r = 0; r < rowNum; r++) {
			stringTokenizer = new StringTokenizer(bufferedReader.readLine());
			for(int c = 0; c < colNum; c++) {
				map[r][c] = Integer.parseInt(stringTokenizer.nextToken());
			}
		}
		
		for(int r = 0; r < rowNum; r++) {
			for(int c = 0; c < colNum; c++) {
				tetris(0, 0, r, c);
				exceptions(r, c);
			}
		}
		
		System.out.println(maxSum);
		
	}

}
