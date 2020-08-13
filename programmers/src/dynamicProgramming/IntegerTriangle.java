package dynamicProgramming;

import java.util.Arrays;

//삼각형의 높이가 1이상 500이하라는 것은 너비 또한 1 이상 500 이하 ( col <= row ) 

public class IntegerTriangle {
	int N;
	int[][] sum;
	int[][] triangle;
	
	IntegerTriangle(){}
	
	private void init(int[][] triangle) {
		N = triangle.length;
		sum = new int[N][N];
		this.triangle = triangle;
		sum[0][0] = triangle[0][0];
		
	}
	
    private void calc(int row, int col){
    	if(row == N-1 && col == N-1) return;
    	
        if(col == 0) {
        	sum[row][col] = sum[row-1][col] + triangle[row][col];
        }else if(col == row) {
        	sum[row][col] = sum[row-1][col-1] + triangle[row][col];
        }else {
        	sum[row][col] = Math.max(sum[row-1][col-1], sum[row-1][col]) + triangle[row][col];
        }
        
        if(col == row) calc(row+1, 0);
        else calc(row, col+1);
    }
    
	public int solution(int[][] triangle) {

		init(triangle);
		calc(1, 0);
		
		Arrays.sort(sum[N-1]);
        return sum[N-1][N-1];
    }
	
	public static void main(String[] args) {
		IntegerTriangle it = new IntegerTriangle();
		int[][] triangle = {{7}, {3, 8}, {8, 1, 0}, {2, 7, 4, 4}, {4, 5, 2, 6, 5}};
		
		System.out.println(it.solution(triangle)); //정답 : 30
		
	}

}
