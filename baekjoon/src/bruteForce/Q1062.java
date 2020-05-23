package bruteForce;

import java.io.*;
import java.util.ArrayList;
import java.util.StringTokenizer;

public class Q1062{
	
	static ArrayList <String> WORDS = null;
	static boolean[] CHECK = new boolean[123];
	static int ANS;
	
	static void getWordsCnt(int n, int k, int start) {
		if(k < 0) return;
		
		if(k == 0) { // ���� k���� �� ����� ��
			int readableSentence = 0;
			for (int i = 0; i < n; i++) { //������ �о��
				int strLen = WORDS.get(i).length();
				int checkCnt = 0;
				
				for(int j = 0; j < strLen; j++) {
					if(CHECK[WORDS.get(i).charAt(j)]){ //i��° ������ j��° char�� ��� ���ڸ�
						checkCnt++;
					}else {
						break;
					}
				}
				if (checkCnt == strLen) { //���� ��ü�� ��� ���ڸ�
					readableSentence++;
				}
			}
			if(ANS < readableSentence) {
				ANS = readableSentence;
			}	
		}
		
		for(int i = start; i <= 'z'; i++) {
			if(!CHECK[i]) {
				CHECK[i] = true;
				getWordsCnt(n, k-1, i+1);
				CHECK[i] = false;
			}
		}	
	}
	
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		WORDS = new ArrayList<String>();
		StringTokenizer st = new StringTokenizer(br.readLine());
		int n = Integer.parseInt(st.nextToken());
		int k = Integer.parseInt(st.nextToken());
		for(int i = 0; i < n; i++) {
			String input = br.readLine();
			input = input.replaceAll("[antic]", "");
			WORDS.add(input);
		}
		
        br.close();
        
        CHECK['a'] = true;
		CHECK['n'] = true;
		CHECK['t'] = true;
		CHECK['i'] = true;
		CHECK['c'] = true;
		
        getWordsCnt(n, k-5, 'b');
        
        System.out.println(ANS);
        
        
	}

}

