package chapter7;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;

public class Quadtree {
	static int idx;
	
	private static String reverse (String image) {
		
		String upperLeft, upperRight, lowerLeft, lowerRight;
		
		if(idx >= image.length()) return "";
		
		if(image.charAt(idx) == 'x') {
			idx++;
			upperLeft = reverse(image);
			upperRight = reverse(image);
			lowerLeft = reverse(image);
			lowerRight = reverse(image);
			
			return "x" + lowerLeft + lowerRight + upperLeft + upperRight;
			
		}else {	//idx�� ����Ű�� �ִ� ���� 'b'�Ǵ� 'w'�� ���
			return image.charAt(idx++)+"";
		}
	}
	
	public static void main(String[] args) throws Exception{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		
		int N = Integer.parseInt(br.readLine());
		
		for(int i = 0; i < N; i++) {
			idx = 0;
			String compressedImg = br.readLine().trim();
			bw.append(reverse(compressedImg));
			bw.newLine();
		}
		
		bw.flush();
		br.close();
		bw.close();
	}
}

/* Input
4
w
xbwwb
xbwxwbbwb
xxwwwbxwxwbbbwwxxxwwbbbwwwwbb
*/

/* Output
w
xwbbw
xxbwwbbbw
xxwbxwwxbbwwbwbxwbwwxwwwxbbwb
*/