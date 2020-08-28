package backtracking;

import java.io.*;

public class Q15650 {	//조합 - 중복X
	static int m,n; // m = 숫자 개수, n = 한 번에 출력할 숫자 개수
	static int list[];  // 출력할 값 저장
    static int check[]; // 숫자의 방문여부를 체크 할 방문배열
	
	static void dfs(int lastValue, int cnt) { // lastValue는 dfs를 호출한 함수에서 마지막으로 list에 들어간 값
										 	  // 조합에서는 중복 값을 제거해야 하기 때문에 이전에 list에 들어간 값들보다 작은 값이 뒤에 올 수 없음
         
		if(cnt == m) { // 0부터 M번까지 반복했으면 하나의 처리가 완성
                       // M보다 큰 횟수는 고려하지 않고 배제한다.
			for(int i=0;i<m;i++) { // 현재 결과 배열(list)을 출력
				System.out.print(list[i]+" ");
			}
			System.out.println();
			return; // DFS 종료 
		}
		
		for(int i = lastValue+1; i <= n; i++) { // 이전 값보다 큰 값부터 시작
			
			if(check[i]==1){
                continue; // 이미 방문한 배열이면 건너뛴다.
            } 
			check[i]=1; // 방문하지 않았다면, 방문처리 후
			list[cnt]=i; // 현재 반복횟수에 해당하는 배열에 i값을 넣는다.
			dfs(i, cnt+1); // 반복횟수를 증가시킨다.
			check[i]=0; // dfs가 종료 후에는 다시 방문여부를 0으로 초기화한다.
			
			
		}
		
		
	
	}
	public static void main(String[] args) throws Exception{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String input = br.readLine();
        String[] temp = input.split(" ");
        br.close();
        
		n = Integer.parseInt(temp[0]); 
		m = Integer.parseInt(temp[1]); 
		
		check = new int[9];
		list = new int [9];
		dfs(0, 0); //아직 들어간 값도 없고, 반복횟수도 없음
	}
	
}