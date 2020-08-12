package dynamicProgramming;

public class NExpression {
	final static int LIMIT = 8;
	static int[] nList;
	static int N; //�־��� ����
	static int number; //���;� �� ����
	
	static int min;
	public static int add(int a, int b) {
		return a + b;
	}
	
	public static int sub(int a, int b) {
		return a - b;
	}
	
	public static int mul(int a, int b) {
		return a * b;
	}
	
	public static int div(int a, int b) {
		return a / b;
	}
	
	public static void calc(int cnt, int result) { // N��밳��, ������� ���� ��
		if(cnt >= min) return; // min���� cnt Ŀ���� �ǹ̾���
		if(result == number) { 
			min = Math.min(cnt, min);
			return;
		}
		int rest = min - cnt; //��밡���� n����
		rest = (rest == 9 ? 8 : rest); //������ n�� 9�� ����ϰ� �Ǹ� ���õǱ� ������ 8�� ����
 		for(int i = 1; i < rest; i++) {
			calc(cnt+i, add(result, nList[i]));
			calc(cnt+i, sub(result, nList[i]));
			calc(cnt+i, mul(result, nList[i]));
			calc(cnt+i, div(result, nList[i]));
		}
	}
	public static void init(int n, int num) {
		N = n;
		number = num;
		nList = new int[9];
		int tmp = N; 
		for(int i = 1; i <= 8; i++) {
			nList[i] = tmp;
			tmp = tmp*10 + N;
		}
		min = 9;
	}
	
	public static int solution(int N, int number) {
		init(N, number);
        calc(0,0);
        if(min > LIMIT) return -1; // �ּҰ��� 8���� ũ�� ���� (return -1)
        return min;
    }
	
	public static void main(String[] args) {

		System.out.println(solution(5, 12)); //���� : 4
		System.out.println(solution(2, 11)); //���� : 3
		System.out.println(solution(5, 31168)); //���� : -1
	}

}
