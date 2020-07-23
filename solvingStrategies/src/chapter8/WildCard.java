package chapter8;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.ArrayList;

public class WildCard {
	static String pattern;
	static ArrayList<String> files;
	
	public void solve() {
		
	}
	
	public void match() {
		
	}
	
	public static void main(String[] args) throws Exception{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		
		files = new ArrayList<String>();
		int N = Integer.parseInt(br.readLine());
		
		for(int i = 0; i < N; i++) {
			pattern = br.readLine();
			int fileNum = Integer.parseInt(br.readLine());
			for(int j = 0; j < fileNum; j++) {
				files.add(br.readLine());
			}
//			System.out.println(files.toString());
			new WildCard().solve();
			files.clear();
		}
	}

}


/* Input

3
he?p
3
help
heap
helpp
*p*
3
help
papa
hello
*bb*
1
babbbc

*/

/* Output
heap
help
help
papa
babbbc
*/
