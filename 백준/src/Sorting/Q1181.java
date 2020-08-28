package Sorting;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Comparator;

public class Q1181 {

	public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        
        int N = Integer.parseInt(br.readLine());
        String[] words = new String[N];
        
        for (int i = 0; i < N; i++) {
            words[i] = br.readLine();

        }
 
        Arrays.sort(words, new Comparator<String>(){
        	
        	@Override
        	public int compare(String x, String y) {
        		
        		if(x.length() == y.length()) {
        			return Integer.compare(x.compareTo(y), y.compareTo(x));
        		}
        		return Integer.compare(x.length(), y.length());
        	}
        });
 
        for (int i = 0; i < N; i++) {
        	if(i < N-1 && words[i+1].equals(words[i])) {
        		continue;
        	}
            bw.write(words[i] + "\n");
        }
        bw.flush();
        
        br.close();
        bw.close();
    }
 
}
