package math1;

import java.io.BufferedReader;
import java.io.InputStreamReader;

public class Q2292 {

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		int num = Integer.parseInt(br.readLine());
		int i = 1;
		int ans = 1;
		
		while(true) {
			if(i >= num) {
				System.out.println(ans);
				br.close();
				return;
			}
			i += 6*ans;
			ans++;
			
		}
		
	}

}
