package math2;

import java.io.*;
import java.util.ArrayList;
import java.util.Collections;

public class Q1929 {
	
//	static int getPrimeNum(int min, int max) {
//		boolean[] check = new boolean[max+1];
//		int count = 0;
//		
//		for(int i = 2; i <= max; i++) {
//			if(i >= min && check[i] == false) {
//				count++;
//			}
//			for(int j = i*2; j <= max; j += i) {
//				check[j] = true;
//			}
//		}
//		return count;
//	}

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		ArrayList<Integer> input = new ArrayList<Integer>();
		int maxNum;
		int inputNum;
		int count;
		
		while(true) {
			if((inputNum=Integer.parseInt(br.readLine())) == 0) {
				break;
			}
			input.add(inputNum);
		}		
		maxNum = Collections.max(input);
		
		boolean[] check = new boolean[(maxNum*2)+1];
		
		for(int i = 2; i <= maxNum*2; i++) {

			for(int j = i*2; j <= maxNum*2; j += i) {
				check[j] = true;
			}
		}
		
		for(int n = 0; n < input.size(); n++) {
			count = 0;
			int num = input.get(n);
			for(int i = num + 1; i <= 2*num; i++) {
				if(check[i] == false) {
					count++;
				}
			}
			bw.write(count+"\n");
		}
		bw.flush();
	
		br.close();
		bw.close();
	}	
}
