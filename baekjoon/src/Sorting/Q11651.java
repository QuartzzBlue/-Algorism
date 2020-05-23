package Sorting;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.Arrays;
import java.util.Comparator;

public class Q11651 {
 
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        
        int N = Integer.parseInt(br.readLine());
        
        int[][] arr = new int[N][2];
        String[] str = new String[2];
        
        for (int i = 0; i < N; i++) {
            str = br.readLine().split(" ");
            arr[i][0] =Integer.parseInt(str[0]);
            arr[i][1] = Integer.parseInt(str[1]);
        }
 
        Arrays.sort(arr, new Comparator<int[]>() {
        	
            @Override
            public int compare(int[] x, int[] y) {
                if (x[1] == y[1]) {
                    return Integer.compare(x[0], y[0]);
                }
                return Integer.compare(x[1], y[1]);
            }
 
        });
 
        for (int i = 0; i < N; i++) {
            bw.write(arr[i][0] + " " + arr[i][1] + "\n");
        }
        bw.flush();
        
        br.close();
        bw.close();
    }
 
}
