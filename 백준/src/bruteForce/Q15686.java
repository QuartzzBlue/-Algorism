package bruteForce;
//
//import java.io.*;
//import java.util.ArrayList;
//import java.util.StringTokenizer;
//
//public class Q15686{
//
//	
//	static ArrayList<Integer> getChickenDistance(int[][] house, int[][] chicken, int h, int c) {
//		int dist = 0;
//		ArrayList<Integer> ans = new ArrayList<Integer>();
//		
//		for(int j = 0; j < h; j++) {
//			int[] temp = {100, 0};
//			for(int i = 0; i < c; i++) {
//				temp[1] = Math.abs(chicken[i][0] - house[j][0]) + Math.abs(chicken[i][1] - house[j][1]);
//				if(temp[0] > temp[1]) {
//					temp[0] = temp[1];
//				}
//			}
//			dist += temp[0];
//		}
//		return dist;
//	}
//	
//	
//	public static void main(String[] args) throws Exception {
//		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
//		StringTokenizer st = new StringTokenizer(br.readLine());
//		int n = Integer.parseInt(st.nextToken());
//		int m = Integer.parseInt(st.nextToken());
//		
//		int [][] house = new int [2*n+1][3];
//		int [][] chicken = new int [14][3];
//		int h_length = 0;
//		int c_length = 0;
//		int temp;
//		
//		
//		//�Է�
//		for(int i = 1; i <= n; i++) {
//			st = new StringTokenizer(br.readLine());
//			for(int j = 1; j <= n; j++) {	
//				temp = Integer.parseInt(st.nextToken());
//				if(temp == 1) {
//					house[h_length][0] = i;
//					house[h_length++][1] = j;
//				}else if(temp == 2) {
//					chicken[c_length][0] = i;
//					chicken[c_length++][1] = i;
//				}
//			}
//		}
//		h_length++;
//		c_length++;
//		
//		
//		for(int i = 0; i < c_length; i++) {
//			
//		}
//		
//		
//	}
//
//}

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayList;
 
class Q15686 {
    static int N;
    static int M;
    static int[][] arr;
    static ArrayList<Dot> chicken;
    static ArrayList<Dot> person;
    static int[] output;
    static boolean[] visited;
    static int result;
 
    public static void main(String[] args) throws Exception {
 
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
 
        String[] str = br.readLine().split(" ");
        N = Integer.parseInt(str[0]);
        M = Integer.parseInt(str[1]);
        arr = new int[N][N];
        result = Integer.MAX_VALUE;
        chicken = new ArrayList<Dot>();
        person = new ArrayList<Dot>();
 
        for (int i = 0; i < N; i++) {
            str = br.readLine().split(" ");
            for (int j = 0; j < N; j++) {
                arr[i][j] = Integer.parseInt(str[j]);
                if (arr[i][j] == 1) {
                    //1�϶��� ��� list�� �߰�
                    person.add(new Dot(i, j));
                } else if (arr[i][j] == 2) {
                    //2�϶��� ġŲ list�� �߰�
                    chicken.add(new Dot(i, j));
                }
            }
        }
        //-------�Էº�-------//
        
        //ġŲ �� ������ ���� �迭 visited, output
        visited = new boolean[chicken.size()];
        output = new int[chicken.size()];
        
        //ġŲ �� ����
        for (int i = 0; i < chicken.size(); i++) {
            visited[i] = true;
            ChickenSelection(i, 0);
            visited[i] = false;
        }
        System.out.println(result);
    }
    
    //ġŲ�� ������ ���� �Լ�
    public static void ChickenSelection(int start, int depth) {
        output[depth] = start + 1;
        
        for (int i = start; i < chicken.size(); i++) {
            if (visited[i])
                continue;
            visited[i] = true;
            ChickenSelection(i, depth + 1);
            visited[i] = false;
        }
        //ġŲ���� ���õǾ��� ���
        //(ġŲ���� �ִ� M�� �̹Ƿ� depth�� M-1 �� �Ǿ���Ѵ�. 0���� ���������ϱ�)
        if (depth == M - 1) {
            int sum = 0;
            int currentM = 0;
            //����� ���� �ִ� ġŲ���� ����� ���� �ּҰ��� �����Ѵ�.
            //person �Ѹ� ��� Chicken ���� �����Ͽ� �ּҰ��� ���Ѵ�.
            for (int i = 0; i < person.size(); i++) {
                int min = Integer.MAX_VALUE;
                for (int j = 0; j < M; j++) {
                    currentM = Calc(person.get(i), chicken.get(output[j] - 1));
                    min = Math.min(min, currentM);
                }
                //�ּҰ��� ��� ���Ѵ�.
                sum = sum + min;
            }
            //ġŲ�� ����� ������ �ٸ� �ּҰŸ��� ���� ���� �ּҰŸ��� �����Ѵ�.
            result = Math.min(result, sum);
        }
    }
    
    //��ġ �Ÿ� ��� �Լ�
    public static int Calc(Dot d1, Dot d2) {
        return Math.abs(d1.x - d2.x) + Math.abs(d1.y - d2.y);
    }
}
 
class Dot {
    int x;
    int y;
 
    Dot(int x, int y) {
        this.x = x;
        this.y = y;
    }
}
