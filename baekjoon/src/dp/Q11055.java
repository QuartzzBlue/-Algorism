package dp;

import java.util.Arrays;
import java.util.Scanner;
import java.util.Stack;
import java.util.StringTokenizer;

/* LIS (Longest Increasing Subsequence : ���� ���� ����) ���� ���� */
/* LIS�� �� ���ϱ� */
//https://www.youtube.com/watch?v=99ssGWhLPUE

public class Q11055 {

	public static void main(String[] args) {
		Scanner scanner = new Scanner(System.in);
		int totalLength = Integer.parseInt(scanner.nextLine());
		int[] subsequence = new int [totalLength];
		int[] maxValue = new int [totalLength];
		int[] actualSequence = new int[totalLength];
		Arrays.fill(actualSequence, -1);
		
		StringTokenizer stringTokenizer  = new StringTokenizer(scanner.nextLine());
		for(int i = 0; i < totalLength; i++) {
			subsequence[i] = Integer.parseInt(stringTokenizer.nextToken());
			maxValue[i] = subsequence[i];
		}
		scanner.close();
		
		for(int i = 1; i < totalLength; i++) {
			for(int j = 0; j < i; j++) {
				if(subsequence[i] > subsequence[j]) {
					maxValue[i] = Math.max(maxValue[i], subsequence[i] + maxValue[j]);
					actualSequence[i] = j;
				}
			}
		}
		
		
		/* �ִ� ã�� */
		int maximumValue = 0;
		for(int i = 0; i < totalLength; i++) {
			maximumValue = Math.max(maxValue[i], maximumValue);
		}
		
		System.out.println(maximumValue);
		
		/* ���� ���� ���� ã�� */
//		int idx = -1;
//		Stack<Integer> stack = new Stack<Integer>();
//		for(int i = totalLength - 1; i >= 0; i--) {
//			if(maxValue[i] == maximumValue || i == idx) {
//				idx = actualSequence[i];
//				stack.add(subsequence[i]);
//			}
//		}
//		
//		while(!stack.isEmpty()){
//			System.out.print(stack.pop() + " ");
//		}
	}

}
