package backtracking;

import java.io.*;

public class Q15651 {	
	static int m,n; // m = 숫자 개수, n = 한 번에 출력할 숫자 개수
	static int list[];  // 출력할 값 저장
	static BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
	
	static void dfs(int cnt) throws Exception{ //반복횟수를 인자로 받으며, 0부터 시작
		
		if(cnt == m) { // 0부터 M번까지 반복했으면 하나의 처리가 완성
                       // M보다 큰 횟수는 고려하지 않고 배제한다.
			for(int i=0;i<m;i++) { // 현재 결과 배열(list)을 출력
				bw.write(list[i]+" ");
			}
			bw.newLine();
			return; // DFS 종료 
		}
		
		for(int i =1;i<=n;i++) { // 수의 범위는 1부터 N까지이다.

			list[cnt]=i; // 현재 반복횟수에 해당하는 배열에 i값을 넣는다.
			dfs(cnt+1); // 반복횟수를 증가시킨다.
		}
	}
	public static void main(String[] args) throws Exception{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String input = br.readLine();
        String[] temp = input.split(" ");
        br.close();
        
		n = Integer.parseInt(temp[0]); 
		m = Integer.parseInt(temp[1]); 
		
		list = new int [9];
		dfs(0);
		
		bw.flush();
		bw.close();
	}
	
}