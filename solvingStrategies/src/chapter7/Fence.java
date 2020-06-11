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
	/*** ������(Sweeping) ��� ��� ***/
	private static int recycle(int[] fence) {
		int n = fence.length;
		int height, width, size = 0;
		// fence�� "�ε���"�� ���� ����
		Stack<Integer> stack = new Stack<Integer>(); 
		
		// ���� ������ ������ ������ �ѹ� ���鼭 ���� ó��(sweep)
		for(int i = 0; i < n; i++) {
			// ������ ������� �ʰ�, i��° �潺�� ���̺��� ���ÿ� ����ִ� �ε����� �ش��ϴ� �潺�� ���̰� ū ���
			while(!stack.empty() && fence[stack.peek()] > fence[i]) {
				height = fence[stack.peek()];
				stack.pop();
				
				// �� �� ������ ������� ������  width�� i~stack.peek()�� �ǰ�, ����ִٸ� width�� i��° �潺�� ������ ������ ����ִ� �潺 ������ �ȴ�.
				if(!stack.empty()) {
					width = i - stack.peek() - 1;
				} else {
					width = i;
				}
				
				// ���� ����
				if(width * height > size) {
					size = width * height;
				}
			}
			// �׻� ���ÿ� �ε����� �ִ´�.
			stack.push(i);
		}
		
		// ������ ������ ���� �� ������ ������� ���� ���
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