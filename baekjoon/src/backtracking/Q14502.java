package backtracking;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;
/*
 * 14502번 연구소
 * DFS(벽 3개 세우기) + BFS(바이러스 퍼트리기)
 */

public class Q14502 {
	static final char BLANK = 0;
	static final char WALL = 1;
	static final char VIRUS = 2;
	static final int[] dc = {0, 0, 1, -1}; //위 아래 오 왼
	static final int[] dr = {-1, 1, 0, 0};
	static int row;
	static int col;
	static int mSafeZone;
	static int[][] map;
//	static Queue<Integer> rQueue;
//	static Queue<Integer> cQueue;
	
	private static void cntSafeZone(int[][] virusMap) {
		int tmp = 0;
		for(int r = 0; r < row; r++) {
			for(int c = 0; c < col; c++) {
				if(virusMap[r][c] == BLANK) {
					tmp++;
				}
			}
		}
		mSafeZone = Math.max(mSafeZone, tmp);
	}
	
	// BFS
	private static void spreadVirus(int[][] tMap) {
		Queue<Integer> rQueue = new LinkedList<Integer>();
		Queue<Integer> cQueue = new LinkedList<Integer>();
		int[][] virusMap = new int[row][col];
		for(int r = 0; r < row; r++) {
			for(int c = 0; c < col; c++) {
				virusMap[r][c] = tMap[r][c];
				if(tMap[r][c] == VIRUS) {
					rQueue.add(r);
					cQueue.add(c);
				}
			}
		}
//		int[][] virusMap = tMap.clone(); // 왜 클론은 안먹힐까앙
		while(!rQueue.isEmpty()) {
			int r = rQueue.poll();
			int c = cQueue.poll();
			
			for(int i = 0; i < 4; i++) {
				int nr = r+dr[i];
				int nc = c+dc[i];
				if(nr >= 0 && nr < row && nc >= 0 && nc < col && virusMap[nr][nc] == BLANK) {
					virusMap[nr][nc] = VIRUS;
					rQueue.add(nr);
					cQueue.add(nc);
				}
			}
		}
		
		cntSafeZone(virusMap);
	}
	
	// DFS
	private static void setSafeWall(int wNum, int[][] tMap) { //세운 벽 수와 지도
		if(wNum == 3) {
			spreadVirus(tMap);
			return;
		}
		
		for(int r = 0; r < row; r++) {
			for(int c = 0; c < col; c++) {
				if(tMap[r][c] == BLANK) {
					tMap[r][c] = WALL;
					setSafeWall(wNum+1, tMap);
					tMap[r][c] = BLANK;
				}
			}
		}
		
		
	}
	
	private static void simulate() {
		/*
		 * 여기서 for문을 먼저 한번 돌려주는 이유는 
		 * dfs를 다 돌 때마다 bfs를 진행해야 되기 때문
		 */
		
		
		for(int r = 0; r < row; r++) {
			for(int c = 0; c < col; c++) {
				if(map[r][c] == BLANK) {
					map[r][c] = WALL;
					setSafeWall(1, map);
					map[r][c] = BLANK;
				}
			}
		}
		
	}

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in)); 
//		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		mSafeZone = 0;
		
		StringTokenizer st = new StringTokenizer(br.readLine());
		row = Integer.parseInt(st.nextToken());
		col = Integer.parseInt(st.nextToken());
		
		map = new int[row][col];
//		int[][] tMap = new int[row][col];
		
		for(int r = 0; r < row; r++) {
			st = new StringTokenizer(br.readLine());
			for(int c = 0; c < col; c++) {
				map[r][c] =  Integer.parseInt(st.nextToken());
//				tMap[r][c] = map[r][c];
			}
		}
		
		
		simulate();
		System.out.println(mSafeZone);
		
		br.close();
		
	}

}
