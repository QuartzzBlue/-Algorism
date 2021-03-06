package backtracking;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class Q2178 {
	static int tx = 0;
	static int ty = 0;
	static int[][] map = null;
	static boolean visited[][] = null;
	static int answer = 1;
	
	public static void bfs() {
		Queue<Position> q = new LinkedList<Position>();
		q.add(new Position(0, 0));
		
		int[] dx = {0,1,0,-1}; //위 오른쪽 아래 왼쪽
		int[] dy = {-1,0,1,0};
		
		while(!q.isEmpty()) {
			Position startP = q.poll();
			int x = startP.getX();
			int y = startP.getY();
			visited[x][y] = true;
			
			for(int i = 0; i < 4; i++) {
				int nx = x+dx[i];
				int ny = y+dy[i];
				
				if(nx >= 0 && nx < tx && ny >= 0 && ny < ty) {
					if(map[nx][ny] == 1 && visited[nx][ny] == false) {
						q.add(new Position(nx, ny));
						visited[nx][ny] = true;
						answer++;
						map[nx][ny] = map[x][y]+1;
					}
				}
			}
			
		}
	}
	public static void main(String[] args) throws Exception{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine(), " ");
		tx = Integer.parseInt(st.nextToken());
		ty = Integer.parseInt(st.nextToken());
		map = new int[tx][ty];
		visited = new boolean[tx][ty];
		
		for(int i = 0; i < tx; i++) {
			String temp = br.readLine();
			for(int j = 0; j < ty; j++) {
				//외워두자! 문자->숫자 ASCII 코드 차는 48 (0-9 = 48-57)
				map[i][j] = temp.charAt(j) - 48;
			}
		}
		bfs();
		System.out.println(answer);
		System.out.println(map[tx-1][ty-1]);
	}

}

class Position{
	int x;
	int y;
	
	public Position(int x, int y) {
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
