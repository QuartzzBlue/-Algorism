package chapter8;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;

/*
 * 메모이제이션 사용 왜 효과적인 것인가...
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
			for(int[] arr : cache) Arrays.fill(arr, -1); //캐시 초기화
			file = fileList.get(i);
			if(match(0, 0) == 1) matchingFiles.add(file);
		}
		
		// 정답 정렬 및 버퍼 write
		Collections.sort(matchingFiles);
		for(int i = 0; i < matchingFiles.size(); i++) {
			bw.append(matchingFiles.get(i));
			bw.newLine();
		}
	}
	
	public int match(int pIdx, int fIdx) { //패턴 인덱스 , 파일 인덱스
		if(cache[pIdx][fIdx] != -1) return cache[pIdx][fIdx]; //캐시 일치할 경우
		
		/** 인덱스가 길이를 벗어나지 않고 패턴 인덱스에 해당하는 캐릭터가 ?거나 파일이름 인덱스에 해당하는 캐릭터와 동일할 때 **/
		if (pIdx < pattern.length() && fIdx < file.length() && (pattern.charAt(pIdx) == '?' || pattern.charAt(pIdx) == file.charAt(fIdx))) {
			return cache[pIdx][fIdx] = match(pIdx+1, fIdx+1);
		} 
		// while문 대신 재귀를 사용했을 때 왜 시간 복잡도가 줄어들지? 띠용스
		
		/** 패턴 인덱스 끝날 때 파일 인덱스도 끝나면 1 반환 , 아니라면 0 반환 **/
		if(pIdx == pattern.length()) 
			return cache[pIdx][fIdx] = (fIdx == file.length()) ? 1 : 0;
		
		/**
		 *  패턴 인덱스에 해당하는 캐릭터가 '*' 라면 
		 * (1) 패턴 인덱스+1 캐릭터가 현재 파일 인덱스 캐릭터와 같은 경우  ex) r*ed vs red
		 * (2) 파일 인덱스가 길이를 벗어나지 않고 패턴 인덱스 캐릭터와 파일 인덱스+1 캐릭터가 같은 경우 ex) r*ed vs rrrsdfred
		 **/
		if(pattern.charAt(pIdx) == '*') {
			if(match(pIdx+1, fIdx) == 1 || (fIdx < file.length() && match(pIdx, fIdx+1) == 1))
				return cache[pIdx][fIdx] = 1;
		}
		
		return cache[pIdx][fIdx] = 0; //일치하지 않는 경우 0 반환
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
