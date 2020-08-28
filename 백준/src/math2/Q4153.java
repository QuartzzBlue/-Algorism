package math2;

import java.io.*;
import java.util.*;

public class Q4153 {
	
	static boolean isRight (ArrayList<Integer> temp) {
		Collections.sort(temp);
		int c = temp.get(2);
		int a = temp.get(0);
		int b = temp.get(1);
		if(c*c == (a*a + b*b)) {
			return true;
		}
		return false;
	}

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		StringTokenizer st = null;
		ArrayList<Integer> temp = new ArrayList<Integer>();
		
		while(true) {
			st = new StringTokenizer(br.readLine());
			temp.add(Integer.parseInt(st.nextToken()));
			temp.add(Integer.parseInt(st.nextToken()));
			temp.add(Integer.parseInt(st.nextToken()));
			
			if((temp.get(0)+temp.get(1)+temp.get(2)) == 0) {
				bw.flush();
				br.close();
				bw.close();
				return;
			}
			if(isRight(temp) == true) {
				bw.write("right\n");
			}else {
				bw.write("wrong\n");
			}
			temp.clear();
		}		
	}	
}
