package bfs;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class Q7576 {
	
	static final int RIPE_TOMATO = 1;
	static final int UNRIPE_TOMATO = 0;
	static final int EMPTY_BOX = -1;
	static int[] rowDirection = {-1, 0, 1, 0}; //ºÏ µ¿ ³² ¼­
	static int[] colDirection = {0, 1, 0, -1};
	
	static int row, column;
	static int[][] map;
	static int minDay = -1;
	
	public static int bfs() {
		Queue<Integer> rowQueue = new LinkedList<Integer>();
		Queue<Integer> colQueue = new LinkedList<Integer>();
		Queue<Integer> dayQueue = new  LinkedList<Integer>();
		
		for(int r = 0; r < row; r++) {
			for(int c = 0; c < column; c++) {
				if(map[r][c] == RIPE_TOMATO) {
					rowQueue.add(r);
					colQueue.add(c);
					dayQueue.add(0);
				}
			}
		}
		
		while(!rowQueue.isEmpty()) {
			int r = rowQueue.poll();
			int c = colQueue.poll();
			int day = dayQueue.poll();
			minDay = day;
			
			for(int d = 0; d < 4; d++) {
				int nextRow = r + rowDirection[d];
				int nextCol = c + colDirection[d];
				if(nextRow >= 0 && nextRow < row && nextCol >= 0 && nextCol < column) {
					if(map[nextRow][nextCol] == UNRIPE_TOMATO) {
						map[nextRow][nextCol] = RIPE_TOMATO;
						rowQueue.add(nextRow);
						colQueue.add(nextCol);
						dayQueue.add(day+1);
					}
				}
			}
		}
		
		for(int r = 0; r < row; r++) {
			for(int c = 0; c < column; c++) {
				if(map[r][c] == UNRIPE_TOMATO) {
					return -1;
				}
			}
		}
		
		return minDay;
	}
	
	public static void main(String[] args) throws IOException{
		BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer tokenizer = new StringTokenizer(bufferedReader.readLine());
		column = Integer.parseInt(tokenizer.nextToken());
		row = Integer.parseInt(tokenizer.nextToken());
		map = new int[row][column];
		
		for(int i = 0; i < row; i++) {
			tokenizer = new StringTokenizer(bufferedReader.readLine());
			for(int j = 0; j < column; j++) {
				map[i][j] = Integer.parseInt(tokenizer.nextToken());
			}
		}

		System.out.println(bfs());
		bufferedReader.close();
		
	}

}
