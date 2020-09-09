package bfs;

import java.io.BufferedReader;

import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.PriorityQueue;
import java.util.StringTokenizer;

/*
 * Q1753 최단경로
 * 
 * 1. 메모리초과 -> 해결 link배열 byte로
 * 2. 시간초과 ->
 * 3. 다시 메모리초과^^... -> 
 */
public class Q1753 {
	public static void main(String[] args) throws Exception{
		final byte MAX_VALUE = 11;
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		int nodeCnt = Integer.parseInt(st.nextToken());
		int linkCnt = Integer.parseInt(st.nextToken());
		int startNode = Integer.parseInt(br.readLine());
		
//		byte[][] link = new byte[nodeCnt+1][nodeCnt+1];
		List<List<Node>> link = new ArrayList<List<Node>>();
		for(int i = 0; i <= nodeCnt; i++) {
			link.add(new ArrayList<Node>());
		}
		int[] dist =  new int[nodeCnt+1];
		boolean[] visited = new boolean[nodeCnt+1];
		
		for(int i = 0; i < linkCnt; i++) {
			st = new StringTokenizer(br.readLine());
			int sNode = Integer.parseInt(st.nextToken());
			int eNode = Integer.parseInt(st.nextToken());
			int weight = Integer.parseInt(st.nextToken());
			
			link.get(sNode).add(new Node(eNode, weight));
//			link[sNode][eNode] = weight;
		}
		Arrays.fill(dist, Integer.MAX_VALUE);
		
		dist[startNode] = 0;
		
		//bfs
//		PriorityQueue<Integer> q = new PriorityQueue<Integer>(); 
//		q.add(startNode);
		PriorityQueue<Node> q = new PriorityQueue<>(); 
		q.add(new Node(startNode, 0));
		
		while(!q.isEmpty()) {
//			int cNode = q.poll();
			int cNode = q.poll().getNodeIdx();
			
			if(visited[cNode] == true) continue;
			visited[cNode] = true;
			
			for(Node n : link.get(cNode)) {
				int nNode = n.getNodeIdx();
				int weight = n.getWeight();
				if(dist[nNode] > dist[cNode] + weight) {
					dist[nNode] = dist[cNode] + weight;
					q.add(new Node(nNode, dist[nNode]));
				}
			}
			
//			for(int n = 1; n <= nodeCnt; n++) {
////				if(link[cNode][n] != 0) { //간선이 존재하는 경우
////					dist[n] = Math.min(dist[n], dist[cNode]+link[cNode][n]);
////					q.add(n);
////				}
//				if(dist[n] <= dist[cNode]+link.get(cNode)link[cNode][n]) {
//					dist[n] = dist[cNode]+link[cNode][n];
//					q.add(n);
//				}
//
//			}
		}
		
		
		for(int n = 1; n <= nodeCnt; n++) {
			String ans = (visited[n] == true ? dist[n]+"" : "INF");
			System.out.println(ans);
		}
		
		br.close();
		
	}
}

class Node implements Comparable<Node>{
	private int nodeIdx;
	private int weight;
	
	public Node() {}
	
	public Node(int nNode, int weight) {
		this.nodeIdx = nNode;
		this.weight = weight;
	}
	

	public int getNodeIdx() {
		return nodeIdx;
	}

	public void setNodeIdx(int nodeIdx) {
		this.nodeIdx = nodeIdx;
	}

	public int getWeight() {
		return weight;
	}

	public void setWeight(int weight) {
		this.weight = weight;
	}

	@Override
	public int compareTo(Node n) {
		return this.weight - n.weight;
	}
	
	
}
