package dfs;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class Q1260 {
	static int graph[][];
	static boolean[] visit;
	static int n, m, v; //정점, 간선, 시작노드
	
	static BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

	public static void dfs(int node) throws Exception{  //재귀 형식
		visit[node] = true; 
		bw.write(node + " "); 
		for(int nextNode = 1; nextNode < n+1; nextNode++){ 
			if(graph[node][nextNode] == 1 && visit[nextNode] == false){ //다음 정점이 있고 그 정점이 방문 내역이 없는 정점일 때
				dfs(nextNode);
			} 
		} 
	} 
	
	public static void bfs(int node)  throws Exception{  //큐 사용(선입선출)
		Queue<Integer> q = new LinkedList<Integer>(); 
		q.offer(node); 
		visit[node] = true; 
		while(!q.isEmpty()){ 
			int temp = q.poll(); //첫번째 방문한 위치는 빼주기로 한다. 
			bw.write(temp+" "); 
			for(int nextNode = 1; nextNode <= n; nextNode++){
				if(graph[temp][nextNode] == 1 && visit[nextNode] == false){ 
					q.offer(nextNode); 
					visit[nextNode] = true;
				} 
			}
		} 
	} 
	
	public static void main(String[] args) throws Exception { 
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in)); 
		StringTokenizer st = new StringTokenizer(br.readLine(), " "); 
		n = Integer.parseInt(st.nextToken());
		m = Integer.parseInt(st.nextToken());
		v = Integer.parseInt(st.nextToken());
		
		graph = new int[n+1][n+1]; 
		visit = new boolean[n+1]; 
		
//		for(int i=0; j<n+1;j++){ 
//			Arrays.fill(map[j], 0); 
//		} 
//		Arrays.fill(visit, false); 
		
		for(int i = 0; i < m; i++){ 
			st = new StringTokenizer(br.readLine()," "); 
			int a = Integer.parseInt(st.nextToken()); 
			int b = Integer.parseInt(st.nextToken()); 
			graph[a][b]=1; 
			graph[b][a]=1; 
		} 
		
		dfs(v); 
		bw.newLine();
		Arrays.fill(visit, false); 
		bfs(v); 
		
		br.close();
		
	}

}
