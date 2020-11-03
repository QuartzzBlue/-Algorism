package test;

/* fa수 2020 하반기  Q3 풀이 */
public class Q3_fa_soo {
	static int[][] parking;
	static int[] dp; // 하위 노드 수
	static int answer = 0;
	
	static public int solution(int depth, int node) {
		if(parking[node][0] == -1 && parking[node][1] == -1) { //제일 바텀 노드
			dp[node] = 0;
		} else {
			for(int i = 0; i < 2; i++) {
				if(parking[node][i] != -1) {
					// 해당 노드의 하위 노드 수 구하기
					dp[node] += solution(depth+1, parking[node][i]) + 1;
				}
			}
		}
		// 경우의 수 = 전체 노드 수 - 깊이(지나온 노드 수) - 하위 노드 수 - 해당 노드
		answer += parking.length - depth - dp[node] - 1;
		return dp[node];
	}

	public static void main(String[] args) {
		int[][] input = {{1,2}, {3,4}, {-1,-1}, {-1,-1}, {-1,-1}};
		// result = 4
//		int[][] input = {{1,2}, {3,4}, {5,6}, {-1,7}, {8,9}, {-1,-1}, {-1,-1}, {-1,-1}, {-1,-1}, {-1,-1}};
		// result = 26

		parking = input;
		dp = new int[parking.length];
		solution(0, 0);
		
		System.out.println(answer/2);
	}
}
