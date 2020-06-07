package devMathching2020Backend;

import java.util.*;
public class Q1 {
    
	public int solution(String p, String s) {
        int answer = 0;
        
		for(int i = 0; i < p.length(); i++){
            int a = Integer.parseInt(p.charAt(i)+"");
            int b = Integer.parseInt(s.charAt(i)+"");
            int temp = Math.abs(a-b);
            if(temp > 5){
                answer += (10 - temp);
            }else{
                answer += temp;
            }
        }
		return answer;
	}
}
