package dfs;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Q14503 {
	static final int DIRTY = 0;
	static final int WALL = 1;
	static final int CLEAN = 2;
	static int[] dirR = {-1, 0, 1, 0}; //북 동 남 서
	static int[] dirC = {0, 1, 0, -1};
	static int ans = 0;
	static int row;
	static int col;
	static int[][] map;
	static boolean[] isClean;

	private static void clearMap(Location robot) {
		int r = robot.getRow();
		int c = robot.getCol();
		robot.setDir(robot.getDir() < 0 ? robot.getDir()+5 : robot.getDir());
		
		/* 청소 */
		if(map[r][c] != CLEAN) {
			map[r][c] = CLEAN;
			ans++;
		}
		
		
//		System.out.println("["+r+", "+c+"]");
		
		/* 탐색 */
		isClean = new boolean[4];
		for(int d = 0; d < 4; d++) {
			if(r+dirR[d] >= 0 && r+dirR[d] < row && c+dirC[d] >= 0 && c+dirC[d] < col) {
				if(map[r+dirR[d]][c+dirC[d]] != DIRTY ) {
					isClean[d] = true;
				}
			}
		}
		
		if(isClean[0] && isClean[1] && isClean[2] && isClean[3]) { // 4방향이 다 청소가 된 경우
			int backDir = ( robot.getDir()-2 < 0 ? robot.getDir()+2 : robot.getDir()-2 );
			int backRow = r+dirR[backDir];
			int backCol = c+dirC[backDir];
			if(backRow >= 0 && backRow < row && backCol >= 0 && backCol < col) {
				if(map[r+dirR[backDir]][c+dirC[backDir]] != WALL) {
					robot.setRow(r + dirR[backDir]);
					robot.setCol(c + dirC[backDir]);
					clearMap(robot);
				}else {
					return;
				}
			}else {
				return;
			}
		}else {
			int leftDir = ( robot.getDir()-1 < 0 ? robot.getDir()+3 : robot.getDir()-1 );
			int leftRow = r+dirR[leftDir];
			int leftCol = c+dirC[leftDir];
			if(leftRow >= 0 && leftRow < row && leftCol >= 0 && leftCol < col) {
				if(isClean[leftDir] == false) {
					robot.setRow(leftRow);
					robot.setCol(leftCol);
				}
				robot.setDir(leftDir);
				clearMap(robot);
			}
			
		}
		
	}
	
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		row = Integer.parseInt(st.nextToken());
		col = Integer.parseInt(st.nextToken());
		map = new int[row][col];
		st = new StringTokenizer(br.readLine());
		int r = Integer.parseInt(st.nextToken());
		int c = Integer.parseInt(st.nextToken());
		int d = Integer.parseInt(st.nextToken());
		Location robot = new Location(r,c,d);
		for(int i = 0; i < row; i++) {
			st = new StringTokenizer(br.readLine());
			for(int j = 0; j < col; j++) {
				map[i][j] = Integer.parseInt(st.nextToken());
			}
		}
		clearMap(robot);
		System.out.println(ans);
		
		br.close();
	}

}

class Location {
	private int row;
	private int col;
	private int dir;
	
	public Location() {}

	public Location(int row, int col, int dir) {
		this.row = row;
		this.col = col;
		this.dir = dir;
	}
	
	public int getRow() {
		return row;
	}
	public void setRow(int row) {
		this.row = row;
	}
	public int getCol() {
		return col;
	}
	public void setCol(int col) {
		this.col = col;
	}
	public int getDir() {
		return dir;
	}
	public void setDir(int dir) {
		this.dir = dir;
	}
	
}