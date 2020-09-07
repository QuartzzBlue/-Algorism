package chapter6;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Clocksync{
	
    static int[] time = new int[16];
    static int[][] switchs = {
        {0, 1, 2},              // SWITCH 0
        {3, 7, 9, 11},          // SWITCH 1
        {4, 10, 14, 15},        // SWITCH 2
        {0, 4, 5, 6, 7},        // SWITCH 3
        {6, 7, 8, 10, 12},      // SWITCH 4
        {0, 2, 14, 15},         // SWITCH 5
        {3, 14, 15},            // SWITCH 6
        {4, 5, 7, 14, 15},      // SWITCH 7
        {1, 2, 3, 4, 5},        // SWITCH 8
        {3, 4, 5, 9, 13}        // SWITCH 9
    };
    
    
    private static int op(int c, int s){
        int cnt = (4 - time[c]) % 4; //c가 0이 되기 위해 눌러야 하는 횟수
        if(cnt != 0)
            for(int j = 0; j < switchs[s].length; j++){
                time[switchs[s][j]]=(time[switchs[s][j]]+cnt)%4;
            }
        return cnt;
    }
    
    private static int solve(){
        int ans = 0;
        if(time[8]!=time[12] || time[14]!=time[15]) return -1;
        ans += op(8,4);
        ans += op(11,1);
        if(time[9]!=time[13]) return -1;
        ans += op(13,9);
        ans += op(6,3);
        ans += op(10,2);
        ans += op(7,7);
        ans += op(5,8);
        if(time[4]!=0) return -1;
        ans += op(1,0);
        ans += op(3,6);
        ans += op(2,5);
        if(time[0] != time[2] || time[0] != time[14]) return -1;
        return ans;
    }

    public static void main(String[] args) throws Exception{
    	BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    	StringTokenizer st = null;
        int n = Integer.parseInt(br.readLine());
        for(int i = 0; i < n; i++){
        	st = new StringTokenizer(br.readLine());
        	for(int j = 0; j < 16; j++){ //0,1,2,3 (12시,3시,6시,9시)
                time[j]=( Integer.parseInt(st.nextToken()) / 3 ) % 4;
            }
            int answer = solve();
            System.out.println(answer);
        }
    }
    
}
