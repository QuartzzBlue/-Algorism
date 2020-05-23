package baekjoon;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;

public class Q1110 {

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		//BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		
        int num = Integer.parseInt(br.readLine());
        int newNum = num;
        int count = 0;
        do{
            int a = newNum / 10;
            int b = newNum % 10;
            
            int temp = (a+b) % 10;
            newNum = b*10 + temp;
            count++;
            
            System.out.println(newNum);
        }while(num != newNum);

        System.out.println(count);
//		bw.write(count);
//        bw.flush();		
	
		br.close();
//		bw.close();
	}

}
