package backtracking;

import java.util.Scanner;


public class Q2661 {
	
//	public static int n;
//    
//    public static boolean isCheck(String s) {
//        int len = s.length();
//        int k = 2;
//        while(k <= len/2) {
//            if(s.substring(len-k, len).equals(s.substring(len-(2*k), len-k))){
//                return false;
//            }
//            k++;
//        }
//        return true;
//    }
//    
//    public static void backtrack(String s) {
//        if(s.length() == n) {
//            System.out.println(s);
//            System.exit(0);
//        }
//        for(int i=1; i<=3; i++) {
//            if(s.charAt(s.length()-1)-'0' == i) continue;
//            if(s.length()+1 < 4) {
//                backtrack(s+i);
//            }else if(isCheck(s+i)) {
//                backtrack(s+i);
//            }
//        }
//    }
//    public static void main(String[] args) {
//        Scanner scan = new Scanner(System.in);
//        n = scan.nextInt();
//        backtrack("1");
//        
//    }
	
	
	
	static int n;
	static String str = "1";
//	static boolean check = false;
	
	public static void dfs() {
//		if(check){
//            return;
//        }
        if(str.length() == n) {
			System.out.println(str);
//			check = true;
			System.exit(0);
//			return;
		}
		
		for(int i = 1; i <= 3; i++) {
			if(isGood(str+i)) {
				str += i;
				System.out.println("*"+str);
				System.out.println(str.length());
				dfs();	
			}
		}
		
	}
	public static boolean isGood(String str) {
		int len = str.length();
		for(int i = 1; i <= len/2; i++) { // i = 0일때는 아무런 효용성 없음
			String preStr = str.substring(len-i-i, len-i);
			String postStr = str.substring(len-i, len);
			if(preStr.equals(postStr)) {
				return false;
			}
		}
		return true;
	}
	
	public static void main(String[] args) throws Exception{
		Scanner sc = new Scanner(System.in);
		n = Integer.parseInt(sc.nextLine());
		dfs();
		sc.close();
		
	}
}
