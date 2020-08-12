package dynamicProgramming;

public class NExpression {
	final static int LIMIT = 8;
	static int[] nList;
	static int N; //주어진 숫자
	static int number; //나와야 할 숫자
	
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
	
	public static void calc(int cnt, int result) { // N사용개수, 현재까지 나온 값
		if(cnt >= min) return; // min보다 cnt 커지면 의미없음
		if(result == number) { 
			min = Math.min(cnt, min);
			return;
		}
		int rest = min - cnt; //사용가능한 n개수
		rest = (rest == 9 ? 8 : rest); //어차피 n을 9개 사용하게 되면 무시되기 때문에 8로 보정
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
        if(min > LIMIT) return -1; // 최소값이 8보다 크면 무시 (return -1)
        return min;
    }
	
	public static void main(String[] args) {

		System.out.println(solution(5, 12)); //정답 : 4
		System.out.println(solution(2, 11)); //정답 : 3
		System.out.println(solution(5, 31168)); //정답 : -1
	}

}
