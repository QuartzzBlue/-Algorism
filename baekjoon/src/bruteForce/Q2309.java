package bruteForce;

import java.io.*;
import java.util.ArrayList;
import java.util.Collections;

public class Q2309{
	
	
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		ArrayList <Integer> height = new ArrayList<Integer>();
		int sum = 0;
		for(int i = 0; i < 9; i++) {
			height.add(Integer.parseInt(br.readLine()));
			sum += height.get(i);
			
		}
        br.close();
        Collections.sort(height);
        
        for(int i = 0; i < 9; i++) {
        	for(int j = i+1; j < 9; j++) {
        		
        		if(sum - (height.get(i) + height.get(j)) == 100) {
        			
        			for(int k = 0; k < 9; k++) {
        				if(k != i && k != j) {
        					System.out.println(height.get(k));
        				}
        			}
        			return;
        			
        		}
        	}
        }
        
        
	}

}

