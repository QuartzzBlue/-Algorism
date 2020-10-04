package bfs;

import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;

/* ���ٲ��� */
// ó�� Ǯ�� �� �޸� �ʰ� ��
// visit[] �迭�� �߰��ؼ� �̹� �湮�� ���� �ߺ� �湮�� ������� �ʰ� �ߴ�.

public class Q1697 {

	static final int MAX_POINT = 100000;
	static final int MIN_POINT = 0;
	static boolean[] visit = new boolean[MAX_POINT + 1];
	
	public static void main(String[] args) {
		Scanner scanner = new Scanner(System.in);
		int startPoint = scanner.nextInt();
		int endPoint = scanner.nextInt();
		scanner.close();
		
		Queue<Integer> pointQueue = new LinkedList<Integer>();
		Queue<Integer> timeQueue = new LinkedList<Integer>();
		
		pointQueue.add(startPoint);
		timeQueue.add(0);
		
		while(!pointQueue.isEmpty()) {
			int currentPoint = pointQueue.poll();
			int requiredSecond = timeQueue.poll();
			
			if(currentPoint == endPoint) {
				System.out.println(requiredSecond);
				break;
			}
			
			if(currentPoint-1 >= MIN_POINT && visit[currentPoint-1] == false) {
				pointQueue.add(currentPoint-1);
				timeQueue.add(requiredSecond+1);
				visit[currentPoint-1] = true;
			}
			
			if(currentPoint+1 <= MAX_POINT && visit[currentPoint+1] == false) {
				pointQueue.add(currentPoint+1);
				timeQueue.add(requiredSecond+1);
				visit[currentPoint+1] = true;
			}
			
			if(currentPoint*2 <= MAX_POINT && visit[currentPoint*2] == false) {
				pointQueue.add(currentPoint*2);
				timeQueue.add(requiredSecond+1);
				visit[currentPoint*2] = true;
			}
			
		}

	}

}
