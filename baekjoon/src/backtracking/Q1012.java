package backtracking;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.StringTokenizer;

public class Q1012 {
	static int xlen = 0;
	static int ylen = 0;
	static int[][] ground = null;
	static boolean[][] visited = null;
	static int[] count = null;
	
	public static void bfs(int x, int y) {
		int[] dx = {0,1,0,-1}; //위 오른쪽 아래 위
		int[] dy = {-1,0,1,0};
		
		visited[x][y] = true;
		
		for(int i = 0; i < 4; i++) {
			if(x+dx[i] >= 0 && x+dx[i] < xlen && y+dy[i] >= 0 && y+dy[i] < ylen) {
				if(visited[x+dx[i]][y+dy[i]] == false && ground[x+dx[i]][y+dy[i]] == 1) {
					bfs(x+dx[i],y+dy[i]);
				}
			}
		}
	}
	
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		StringTokenizer st = null;
		int t = Integer.parseInt(br.readLine());
		count = new int[t];
		for(int i = 0; i < t; i++) {
			st = new StringTokenizer(br.readLine(), " ");
			xlen = Integer.parseInt(st.nextToken());
			ylen = Integer.parseInt(st.nextToken());
			ground = new int[xlen][ylen];
			visited = new boolean[xlen][ylen];
			
			int n = Integer.parseInt(st.nextToken());
			for(int j = 0; j < n; j++) {
				
				st = new StringTokenizer(br.readLine(), " ");
				int x = Integer.parseInt(st.nextToken());
				int y = Integer.parseInt(st.nextToken());
				ground[x][y] = 1;
			}
			
			for(int x = 0; x < xlen; x++) {
				for(int y = 0; y < ylen; y++) {
					if(ground[x][y] == 1 && visited[x][y] == false) {
						bfs(x,y);
						count[i]++;
					}
				}
			}
			bw.write(count[i]+"\n");
		}
		bw.flush();
		br.close();
		bw.close();
	}
}
