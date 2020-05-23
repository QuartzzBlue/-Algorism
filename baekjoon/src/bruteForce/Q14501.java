package bruteForce;
//
//import java.io.*;
//import java.util.StringTokenizer;
//
//public class Q14501{
//	
//	static int[][] schedule = null;
//	static int salary = 0;
//	static int RemainDays = 0;
//	
//	static void calculateSalary(){
//		
//		for(int i = 1; i <= RemainDays; i++) {
//			int temp = 0;
//			int j = i;
//			while(true) {
//				
//				if(j == RemainDays) {
//					if(j + schedule[j][0] > RemainDays && schedule[j][0] != 1) {// ��� �������� ������� �ʰ��ϴ� ���
//						break;
//					}
//					System.out.println("**"+temp);
//					temp += schedule[j][1];
//					break;
//				}else {
//					if(j + schedule[j][0] > RemainDays) {// ��� �������� ������� �ʰ��ϴ� ���
//						j += 1;
//					}else {
//						temp += schedule[j][1];
//						j += schedule[j][0];
//						System.out.println("*"+temp);
//						// ���� ��� �������� ������� �ʰ��ϴ� ���
//						if(j > RemainDays) {
//							System.out.println("**"+temp);
//							break;
//						}
//					}
//				}
//			}
//			System.out.println("****"+temp);
//			if(temp > salary) {
//				salary = temp;
//			}
//		}
//		
//	}
//	
//	public static void main(String[] args) throws Exception {
//		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
//		RemainDays = Integer.parseInt(br.readLine());
//		schedule = new int[RemainDays+1][2];  
//		for(int i = 1; i <= RemainDays; i++) {
//			StringTokenizer st = new StringTokenizer(br.readLine());
//			schedule[i][0] = Integer.parseInt(st.nextToken());
//			schedule[i][1] = Integer.parseInt(st.nextToken());
//		}
//        br.close();
//        
//        calculateSalary();
//        
//        System.out.println(salary);
//        
//	}
//
//}
//

import java.util.*;
import java.io.*;
 
class Q14501 {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;
 
        int N = Integer.parseInt(br.readLine());
        int[] T = new int[N+2];
        int[] P = new int[N+2];
        int[] dp = new int[N+2];
 
        for(int i=1; i<=N; i++) {
            st = new StringTokenizer(br.readLine());
            T[i] = Integer.parseInt(st.nextToken());
            P[i] = Integer.parseInt(st.nextToken());
        }
        
        // dp ����
        for(int i=N; i>0; i--) {
            int day = i + T[i];     // i��° ���� ���Ⱓ
 
            if(day <= N+1) 
                dp[i] = Math.max(P[i] + dp[day], dp[i+1]);
            else
                // ����� �ʰ�
                dp[i] = dp[i+1];
        }
 
         System.out.println(dp[1]);
    }
}