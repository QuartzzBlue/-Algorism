package bruteForce;

//import java.util.Scanner;
//
//public class Q1038 {
//	static int CNT;
//	static int N;
//	static long I;	//숫자
//	static int NTH = 1; //자리수
//	
//	static boolean calculateNum(long num) {
//		if(num/10 == 0) {
//			return true;
//		}
////		System.out.println("**" + NTH);
////		System.out.println(I);
//		if(((num/10)%10) - (num%10) > 0) {
//			NTH *= 10;
//			return calculateNum(num/10);
//			
//		}else if(((num/10)%10) - (num%10) == 0){
//			I += NTH*10;
//			I = I/NTH;
//			I *= NTH;
//			return false;
//		}else {
//			return false;
//		}
//	}
//
//	public static void main(String[] args) throws Exception{
//		Scanner scan = new Scanner(System.in);
//		N = scan.nextInt();
//		scan.close();
//		if(N == 0) {
//			System.out.println(0);
//		}else if(N < 10) {
//			System.out.println(N);
//		}
//		
//		CNT = 9;
//		I = 10;
//		while(true) {
//			NTH = 1;
//			if(calculateNum(I)) {
//				CNT++;	
//			}
//			if(CNT == N) break;
//			I++;
//			
//			
//		}
//		
//		System.out.println(I);
//	}
//
//}

import java.util.*;

public class Q1038 {
	public static ArrayList getDownNumber(long num, int digit, ArrayList downNumList) {
			
		if(digit > 10) { //재귀는 9번까지
			return downNumList;
		}
		
		downNumList.add(num);
		
		for(int i=0; i<10; i++) {
			if(num%10 > i) {
				getDownNumber((num*10) + i, digit+1, downNumList);
			}
		}
		
		return downNumList;
	}
	
	public static void main(String[] args) {
		
		// 입력 받기 
		Scanner scanner = new Scanner(System.in);
		String input = scanner.nextLine();
		int idx = Integer.parseInt(input);
		scanner.close();
		
		// 감소하는 수 리스트 만들기 
		ArrayList<Integer> downNumList = new ArrayList<>();
		
		for(int num=0; num<10; num++) { //num은 맨 앞자리 수, digit은 재귀 횟수
			 getDownNumber(num, 1, downNumList);
		}
		
		// 정렬
		Collections.sort(downNumList);
		
		if(idx > downNumList.size()-1) {
			System.out.println(-1);
		}
		else {
			System.out.println(downNumList.get(idx));
		}
	}
}