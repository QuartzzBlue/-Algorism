package test;

/* fa�� 2020 �Ϲݱ�  Q3 Ǯ�� */
public class Q3_fa_soo {
	static int[][] parking;
	static int[] dp; // ���� ��� ��
	static int answer = 0;
	
	static public int solution(int depth, int node) {
		if(parking[node][0] == -1 && parking[node][1] == -1) { //���� ���� ���
			dp[node] = 0;
		} else {
			for(int i = 0; i < 2; i++) {
				if(parking[node][i] != -1) {
					// �ش� ����� ���� ��� �� ���ϱ�
					dp[node] += solution(depth+1, parking[node][i]) + 1;
				}
			}
		}
		// ����� �� = ��ü ��� �� - ����(������ ��� ��) - ���� ��� �� - �ش� ���
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
