package chapter6;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.StringTokenizer;

public class Boardcover {
	
	static BufferedWriter bw;
	static int r, c, blockNum, answer;
	static String[][] board = null;
	static boolean[][] covered = null;
	static Position[][] coverType = {
			{new Position(0, 0), new Position(1, 0), new Position(0, 1)},	//!ㄱ
			{new Position(0, 0), new Position(0, 1), new Position(1, 1)},	//ㄱ
			{new Position(0, 0), new Position(1, 0), new Position(1, 1)},	//ㄴ
			{new Position(0, 0), new Position(1, 0), new Position(1, -1)}	//!ㄴ
	};
	
	private static void cover(int depth) {
		if(depth == blockNum) {
			answer++;
			return;
		}
		
		Position now = findNextBlank();
		
		for(int i = 0; i < 4; i++) {
			if(check(now, i)) {
				set(now, i, true);
				cover(depth+1);
			}else {
				continue;
			}
			set(now, i, false);
		}
	}
	
	private static Position findNextBlank() {
		for(int i = 0; i < r; i++) {
			for(int j = 0; j < c; j++) {
				if(covered[i][j] == false) {
					return new Position(i, j);
				}
			}
		}
		return null;	
	}
	
	private static boolean check(Position now, int type) {
		for(int j = 0; j < 3; j++) {
			Position next = coverType[type][j];
			int nx = now.getX() + next.getX();
			int ny = now.getY() + next.getY();
			if(nx < 0 || ny < 0 || nx >= c || ny >= r || covered[ny][nx] == true) {
				return false;
			}
		}
		
		return true;
	}
	
	private static void set(Position now, int type, boolean flag) {
		for(int j = 0; j < 3; j++) {
			Position next = coverType[type][j];
			int nx = now.getX() + next.getX();
			int ny = now.getY() + next.getY();
			covered[ny][nx] = !covered[ny][nx];		
		}
	}
	
	private static boolean checkBlockNum() {
		int blank = 0;
		for(int i = 0; i < r; i++) {
			for(int j = 0; j < c; j++) {
				if(board[i][j].equals(".")) {
					blank++;
				}else {
					covered[i][j] = true;
				}
			}
		}
		if(blank%3 != 0) {
			return false;
		}
		blockNum = blank/3;
		return true;
	}
	
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		bw = new BufferedWriter(new OutputStreamWriter(System.out));
		StringTokenizer st = null;
		
		int n = Integer.parseInt(br.readLine());	//테스트 케이스 수
		
		for(int i = 0; i < n; i++) {
			st = new StringTokenizer(br.readLine());
			r = Integer.parseInt(st.nextToken());	//row
			c = Integer.parseInt(st.nextToken());	//column
			board = new String[r][c];
			covered = new boolean[r][c];
			for(int j = 0; j < r; j++) {
				board[j] = br.readLine().split("");
			}
			
			if(!checkBlockNum()) {
				bw.append(answer+"\n");
				continue;
			}else {
				answer = 0;
				cover(0);
				bw.append(answer+"\n");
			}
		}
		bw.flush();
		bw.close();
		br.close();
	}
}

class Position {
	int x;
	int y;
	
	public Position(int y, int x) {
		this.x = x;
		this.y = y;
	}

	public int getX() {
		return x;
	}

	public void setX(int x) {
		this.x = x;
	}

	public int getY() {
		return y;
	}

	public void setY(int y) {
		this.y = y;
	}
}
/* Input

3
3 7
#.....#
#.....#
##...##
3 7
#.....#
#.....#
##..###
8 10
##########
#........#
#........#
#........#
#........#
#........#
#........#
##########

 */

/* Output
 * 0
 * 2
 * 1514
 */

