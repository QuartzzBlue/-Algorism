package math1;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.StringTokenizer;


public class Q10250 {

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		StringTokenizer st = null;
		
		int t = Integer.parseInt(br.readLine());
		int floor, num, nthCustomer;
		int setNum, setFloor;
		
		StringBuffer sb = new StringBuffer();
		
		for(int i = 0; i < t; i++) {
			String line = br.readLine();
			st = new StringTokenizer(line);
			floor = Integer.parseInt(st.nextToken());
			num = Integer.parseInt(st.nextToken());
			nthCustomer = Integer.parseInt(st.nextToken());
			
			//먼저 호수를 1로 설정하고
			setNum = 1;
			//손님 수가 층 수보다 작아질 때까지 while문을 돌림
			while(nthCustomer > floor) {
				nthCustomer -= floor;
				setNum++;
			}
			setFloor = nthCustomer;
				
			//출력
			sb.append(setFloor);
			if(setNum < 10) {
				sb.append(0);
			}
			sb.append(setNum);
			bw.write(sb+"\n");
			sb.delete(0, sb.length());
		}
		bw.flush();
		br.close();
		bw.close();
	}	
}