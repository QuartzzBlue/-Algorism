package math1;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

/****** 달팽이는 올라가고 싶다 ******/
public class Q1011 {

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		int a = Integer.parseInt(st.nextToken());
		int b = Integer.parseInt(st.nextToken());
		int v = Integer.parseInt(st.nextToken());
		
		//밤에 b만큼의 거리를 미끄러지므로 미리 v에서 b를 뺀 상태로 (a-b)를 나눈다.
		int days = ((v-b) / (a-b));
		//만약, 나눈 값이 딱 나누어 떨어지지 않고 나머지가 남는다면 하루를 추가한다.
		if((a-b)*days != v-b) {
			days++;
		}
		
		
		System.out.println(days);
		br.close();
	}	
}