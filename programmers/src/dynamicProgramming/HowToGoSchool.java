package dynamicProgramming;

import java.util.Arrays;

//https://velog.io/@ajufresh/%EB%93%B1%EA%B5%A3%EA%B8%B8 참고
//div를 미리미리 나눠서 integer 최대수 안넘어가게함

public class HowToGoSchool {

	HowToGoSchool() {}

	static final int DIV = 1000000007;
	// 오른쪽, 아래
	int[] dirX = { 1, 0 };
	int[] dirY = { 0, 1 };

	int[][] cache;
	boolean[][] puddles;
	int schoolX;
	int schoolY;

	private void init(int x, int y, int[][] puddlesPos) {
		schoolX = x;
		schoolY = y;
		cache = new int[y + 1][x + 1];
		for (int[] tmp : cache) {
			Arrays.fill(tmp, 0);
		}
		cache[1][1] = 1;
		puddles = new boolean[y + 1][x + 1];
		for (int[] tmp : puddlesPos) {
			int px = tmp[0];
			int py = tmp[1];
			puddles[py][px] = true;
		}
	}

	private void calc() {
		for (int i = 1; i <= schoolY; i++) {
			for (int j = 1; j <= schoolX; j++) {
				if (puddles[i][j] == true)
					continue;
				else {
					if (i == 1)
						cache[i][j] += cache[i][j - 1];
					else
						cache[i][j] = (cache[i - 1][j] + cache[i][j - 1]) % DIV;

				}
			}
		}
	}

	public int solution(int m, int n, int[][] puddles) {
		init(m, n, puddles);
		calc();
		return cache[schoolY][schoolX];
	}

	public static void main(String[] args) {
		HowToGoSchool hs = new HowToGoSchool();
		int[][] puddles = { { 2, 2 } };
		System.out.println(hs.solution(4, 3, puddles));

	}

}

/* 정확성은 다 통과하는데 효율성 빵점나옴 ㅠㅠ

import java.util.Arrays;

class Solution {
    static final int DIV = 1000000007;
    // 오른쪽, 아래
    int[] dirX = {1, 0};
    int[] dirY = {0, 1};
    
    boolean[][] puddles;
    int schoolX;
    int schoolY;
    int ans;
    
    private void init(int x, int y, int[][] puddlesPos) {
        schoolX = x;
        schoolY = y;
        
        puddles = new boolean[x+1][y+1];
        for(int[] tmp : puddlesPos){
            int px = tmp[0];
            int py = tmp[1];
            puddles[px][py] = true;
        }
        ans = 0;
    }
    
    private boolean isPossible(int x, int y, int dir){
        if(x+dirX[dir] > schoolX || y+dirY[dir] > schoolY) return false;
        if(puddles[x+dirX[dir]][y+dirY[dir]] == true) return false;
        return true;
    }
    
    private void calc(int x, int y) {
        if(cache[x][y] == -1) cache[x][y]
        if(x == schoolX && y == schoolY) {
            ans++;
            return;
        }
        
        for(int i = 0; i < 2; i++){
            if(isPossible(x, y, i)) calc(x+dirX[i], y+dirY[i]);
        }
    }
    
    public int solution(int m, int n, int[][] puddles) {
        init(m, n, puddles);
        calc(1,1);
        return ans%DIV;
    }
}

*/