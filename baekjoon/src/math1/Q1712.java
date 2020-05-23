package math1;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.StringTokenizer;

public class Q1712 {

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        //BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringTokenizer st = null;
            
        String line = br.readLine();
        st = new StringTokenizer(line);
        int a = Integer.parseInt(st.nextToken());
        int b = Integer.parseInt(st.nextToken());
        int price = Integer.parseInt(st.nextToken());
        
        int cost = a + b;
        int qty = 1;
        int total = price;
        
        if(b >= total){
            System.out.println(-1);
            return;
        }
        while(cost >= total){
            cost += b;
            total += price;
            qty++;
        }
        
        System.out.println(qty);
        br.close();
//        bw.close();
	}

}
