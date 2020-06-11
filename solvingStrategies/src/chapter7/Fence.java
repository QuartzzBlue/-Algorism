package chapter7;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Stack;
import java.util.StringTokenizer;

public class Fence {
	/*** 스위핑(Sweeping) 기법 사용 ***/
	private static int recycle(int[] fence) {
		int n = fence.length;
		int height, width, size = 0;
		// fence의 "인덱스"를 넣을 스택
		Stack<Integer> stack = new Stack<Integer>(); 
		
		// 왼쪽 끝에서 오른쪽 끝까지 한번 쓸면서 연산 처리(sweep)
		for(int i = 0; i < n; i++) {
			// 스택이 비어있지 않고, i번째 펜스의 높이보다 스택에 들어있는 인덱스에 해당하는 펜스의 높이가 큰 경우
			while(!stack.empty() && fence[stack.peek()] > fence[i]) {
				height = fence[stack.peek()];
				stack.pop();
				
				// 이 때 스택이 비어있지 않으면  width는 i~stack.peek()가 되고, 비어있다면 width는 i번째 펜스를 제외한 스택이 들어있던 펜스 개수가 된다.
				if(!stack.empty()) {
					width = i - stack.peek() - 1;
				} else {
					width = i;
				}
				
				// 넓이 갱신
				if(width * height > size) {
					size = width * height;
				}
			}
			// 항상 스택에 인덱스를 넣는다.
			stack.push(i);
		}
		
		// 오른쪽 끝까지 왔을 때 스택이 비어있지 않은 경우
		while(!stack.empty()) {
			height = fence[stack.peek()];
			stack.pop();
			
			if(!stack.empty()) {
				width = n - stack.peek() - 1;
			} else {
				width = n;
			}
			
			if(width * height > size) {
				size = width * height;
			}
			
		}
		
		return size;
	}
	
	
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		int[] fences; 
		int N = Integer.parseInt(br.readLine());
		
		for(int i = 0; i < N; i++) {
			int num = Integer.parseInt(br.readLine());
			StringTokenizer st = new StringTokenizer(br.readLine());
			fences = new int[num];
			
			for(int j = 0; j < num; j++) {
				fences[j] = Integer.parseInt(st.nextToken());
			}
			
			bw.write(recycle(fences)+"");
			bw.newLine();
		}
		bw.flush();
		br.close();
		bw.close();
	}
}

/* INPUT
3
7
7 1 5 9 6 7 3
7
1 4 4 4 4 1 1
4
1 8 2 2
*/

/* OUTPUT
20
16
8
*/