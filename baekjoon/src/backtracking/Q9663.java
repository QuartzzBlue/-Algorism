package backtracking;
/*************************
 * N-Queen : ��Ʈ��ŷ ��ǥ ����	
 * �� ������ �ٽ���  ���� x��ǥ��!
 *************************/
 
import java.util.Scanner;
public class Q9663 {
	
	static int column[] = new int[16];	//y�� �������� x��ǥ ��ġ
	static int N;
	static int ans = 0;
	
	public static void main(String[] args) {
		Scanner scan = new Scanner(System.in);
		N = scan.nextInt();
		
		nQueen(1);	//row=1�� ������ ����
		
		System.out.println(ans);
		scan.close();
	}
	private static void nQueen(int row) {
		if(row > N) {
			ans++;
			return;
		}
		//col �ϳ��� �÷����鼭 �˻�
		for(int i = 1; i <= N; i++){ 
			column[row] = i;
			// �� ���� �� �����ϸ�
			if(isPossible(row)) {
				nQueen(row+1);
			}
		}
	}
	private static boolean isPossible(int row) {
		if(row == 1) return true;
		int col = column[row];
		for(int tRow = 1; tRow < row; tRow++) {
			int tCol = column[tRow];
			if(tCol == col) return false;
			if(Math.abs(tCol - col) == Math.abs(tRow - row)) return false;
		}
		return true;
	}
}


//import java.util.Scanner;
//public class Q9663 {
//	
//	static int path_x[] = new int[16];	//y�� �������� x��ǥ ��ġ
//	static int n;
//	static int ans;
//	
//	public static void main(String[] args) {
//		
//		Scanner scan = new Scanner(System.in);
//		n = scan.nextInt();
//		scan.close();
//		
//		for(int i=0; i<n; i++){
//			path_x[0] = i;
//			n_Queen(i,0);	//y=0�� ������ ����
//		}
//		System.out.println(ans);
//	}
//	private static void n_Queen(int x, int y) {
//		
//		for(int i=0;i<y;i++){
//	        if(path_x[i] == x || Math.abs(x - path_x[i]) == y-i)
//	        	//x��ǥ�� ���ų� �밢���� ������
//	        	 return;
//	    }
//	    if(y==n-1){	//y ������ ���� ��
//	        ans++;
//	        return;
//	    }
//	    for(int i=0;i<n;i++){   //x���� �ѹ� �� ������ ��
//	        path_x[y+1]=i;
//	        n_Queen(i,y+1);
//	    }
//	}
//}



//
//import java.util.Scanner;
//
//public class Q9663 {
//	static int n, ans;
//	static boolean[][] chess;
//	
//	public static void dfs(int cnt, int lastRow, int lastCol) {
//		if(cnt == n) {
//			ans++;
//		}
//		
//		for(int i = lastRow + 1; i < n; i++) {
//			for(int j = 0; j < n; j++) {
//				if(lastCol == j) continue;
//				if(isPossible(i,j)) {
//					dfs(cnt+1, i, j);
//				}
//			}	
////			for(int j = lastCol; j < n; j++) {
////				if(isPossible(i, j)) {
////					dfs(cnt+1, i+1, 0);
////				}else {
////					continue;
////				}
////			}
//		}
//	}
//	
//	public static boolean isPossible(int row, int col) {
//		if(chess[row][col] == true) {
//			System.out.println(row+" "+col);
//			chess = new boolean[n][n];
//			System.out.println("=======");
//			return false;
//		}else {
//			System.out.println(row+" "+col);
//			for(int i = 0; i < n; i++) {
//				for(int j = 0; j < n; j++) {
//					if(chess[i][j] == true) continue;
//					if(Math.abs(row-i) == 1 && Math.abs(col-i) == 1) {
//						chess[i][j] = true;
//					}
//				}
//			}
//			return true;
//		}
//		
//	}
//	
//	public static void main(String[] args) {
//		Scanner scan = new Scanner(System.in);
//		
//		n = scan.nextInt();
//		ans = 0;
//		chess = new boolean[n][n];
//		
//		dfs(0,0,0);
//		
//		System.out.println(ans);
//		scan.close();
//		
//	}
//
//}