package bruteForce;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.StringTokenizer;

public class Q2798 {

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		ArrayList<Integer> cards = new ArrayList<Integer>();
		int n = Integer.parseInt(st.nextToken()); // qty of cards
		int m = Integer.parseInt(st.nextToken()); // the number
		int ans = 0;
		
		st = new StringTokenizer(br.readLine());
		br.close();
		
		for(int c = 0; c < n; c++) {
			cards.add(Integer.parseInt(st.nextToken()));
		}
		
		for(int i = 0; i < n-2; i++) {
			for(int j = i+1; j < n-1; j++) {
				for(int k = j+1; k < n; k++) {
					int sum = cards.get(i) + cards.get(j) + cards.get(k);
					if(sum == m) {
						System.out.println(sum);
						return;
					}else if(sum < m && sum > ans){
						ans = sum;
					}	
				}
			}
		}
		
		System.out.println(ans);
		
	}

}

