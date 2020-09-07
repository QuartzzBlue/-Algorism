package math1;

import java.io.BufferedReader;
import java.io.InputStreamReader;


public class Q1193 {

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		int num = Integer.parseInt(br.readLine());
		br.close();
		
		int i = 1;
		int count = 1;
		int a, b;
		
		while(true) {
			//이번 대각선에 num이 포함되면
			if(count >= num) {
				num = count-num;
				a = 1;
				b = i;

				while(num != 0) {
						a++;
						b--;
						num--;
				}
				
				if(i%2 == 1) {
					System.out.println(a+"/"+b);
					return;
				}else {
					System.out.println(b+"/"+a);
					return;
				}
			}
			
			// 대각선의 번호
			i++;
			// 대각선에 포함된 분수의 수
			count += i;

		}
		
	}

}