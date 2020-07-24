package chapter8;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;

/*
 * �޸������̼� ��� �� ȿ������ ���ΰ�...
 */

public class WildCard {
	static String pattern;
	static String file;
	static ArrayList<String> fileList;
	static int[][] cache;
	static BufferedWriter bw;
	
	public void solve() throws Exception{
		cache = new int[101][101];
		ArrayList<String> matchingFiles = new ArrayList<String>();
		
		for(int i = 0; i < fileList.size(); i++) {
			for(int[] arr : cache) Arrays.fill(arr, -1); //ĳ�� �ʱ�ȭ
			file = fileList.get(i);
			if(match(0, 0) == 1) matchingFiles.add(file);
		}
		
		// ���� ���� �� ���� write
		Collections.sort(matchingFiles);
		for(int i = 0; i < matchingFiles.size(); i++) {
			bw.append(matchingFiles.get(i));
			bw.newLine();
		}
	}
	
	public int match(int pIdx, int fIdx) { //���� �ε��� , ���� �ε���
		if(cache[pIdx][fIdx] != -1) return cache[pIdx][fIdx]; //ĳ�� ��ġ�� ���
		
		/** �ε����� ���̸� ����� �ʰ� ���� �ε����� �ش��ϴ� ĳ���Ͱ� ?�ų� �����̸� �ε����� �ش��ϴ� ĳ���Ϳ� ������ �� **/
		if (pIdx < pattern.length() && fIdx < file.length() && (pattern.charAt(pIdx) == '?' || pattern.charAt(pIdx) == file.charAt(fIdx))) {
			return cache[pIdx][fIdx] = match(pIdx+1, fIdx+1);
		} 
		// while�� ��� ��͸� ������� �� �� �ð� ���⵵�� �پ����? ��뽺
		
		/** ���� �ε��� ���� �� ���� �ε����� ������ 1 ��ȯ , �ƴ϶�� 0 ��ȯ **/
		if(pIdx == pattern.length()) 
			return cache[pIdx][fIdx] = (fIdx == file.length()) ? 1 : 0;
		
		/**
		 *  ���� �ε����� �ش��ϴ� ĳ���Ͱ� '*' ��� 
		 * (1) ���� �ε���+1 ĳ���Ͱ� ���� ���� �ε��� ĳ���Ϳ� ���� ���  ex) r*ed vs red
		 * (2) ���� �ε����� ���̸� ����� �ʰ� ���� �ε��� ĳ���Ϳ� ���� �ε���+1 ĳ���Ͱ� ���� ��� ex) r*ed vs rrrsdfred
		 **/
		if(pattern.charAt(pIdx) == '*') {
			if(match(pIdx+1, fIdx) == 1 || (fIdx < file.length() && match(pIdx, fIdx+1) == 1))
				return cache[pIdx][fIdx] = 1;
		}
		
		return cache[pIdx][fIdx] = 0; //��ġ���� �ʴ� ��� 0 ��ȯ
	}
	
	public static void main(String[] args) throws Exception{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		bw = new BufferedWriter(new OutputStreamWriter(System.out));
		
		fileList = new ArrayList<String>();
		int N = Integer.parseInt(br.readLine());
		
		for(int i = 0; i < N; i++) {
			pattern = br.readLine();
			int fileNum = Integer.parseInt(br.readLine());
			for(int j = 0; j < fileNum; j++) {
				fileList.add(br.readLine());
			}
//			System.out.println(files.toString());
			new WildCard().solve();
			fileList.clear();
		}
		
		bw.flush();
		br.close();
		bw.close();
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
