package dfs;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Q1759 {
	static BufferedWriter bufferedWriter = new BufferedWriter(new OutputStreamWriter(System.out));
	static final String VOWEL = "aeiou";
	static int length, caseNum;
	static String[] alpabets;
	
	static public void getPassword(StringBuffer password, int index, int vowelNum, int consonantNum) throws IOException {
		if(password.length() == length && vowelNum >= 1 && consonantNum >= 2) {
			bufferedWriter.append(password.toString());
			bufferedWriter.newLine();
			return;
		}
		
		for(int i = index + 1; i < caseNum; i++) {
			if(VOWEL.contains(alpabets[i])) {
				getPassword(password.append(alpabets[i]), i, vowelNum + 1, consonantNum);
			}else {
				getPassword(password.append(alpabets[i]), i, vowelNum, consonantNum + 1);
			}
			password.deleteCharAt(password.length()-1);
		}
		
	}
	
	public static void main(String[] args) throws IOException{
		BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));
		
		StringTokenizer tokenizer = new StringTokenizer(bufferedReader.readLine());
		length = Integer.parseInt(tokenizer.nextToken());
		caseNum = Integer.parseInt(tokenizer.nextToken());
		
		alpabets = bufferedReader.readLine().split(" ");
		Arrays.sort(alpabets);

		getPassword(new StringBuffer(""), -1, 0, 0);
		bufferedWriter.flush();
		bufferedReader.close();
		bufferedWriter.close();
	}

}

