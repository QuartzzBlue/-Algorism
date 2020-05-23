package Sorting;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Comparator;

public class Q10814 {

	public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        
        int N = Integer.parseInt(br.readLine());
        int[] num = new int[10001];
        
        for(int i = 0; i < N; i++) {
        	num[Integer.parseInt(br.readLine())]++;
        }
        
        for(int i = 1; i < 10001; i++) {
        	if(num[i] > 0) {
        		for(int j = 0; j < num[i]; j++) {
        			bw.write(i+"\n");
        		}
        	}
        }
        
        bw.flush();
        
        br.close();
        bw.close();
    }
 
}
