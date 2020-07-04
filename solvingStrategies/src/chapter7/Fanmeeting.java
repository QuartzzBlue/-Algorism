package chapter7;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.ArrayList;

/* Input
4
FFFMMM
MMMFFF
FFFFF
FFFFFFFFFF
FFFFM
FFFFFMMMMF
MFMFMFFFMMMFMF
MMFFFFFMFFFMFFFFFFMFFFMFFFFMFMMFFFFFFF
 */

/* output
1
6
2
2
 */

public class Fanmeeting {
	static BufferedWriter bw;
	
	public static void main(String[] args) throws Exception{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		bw = new BufferedWriter(new OutputStreamWriter(System.out));
		int caseNum = Integer.parseInt(br.readLine());
		for(int n = 0; n < caseNum; n++) {
			String members = br.readLine();
			String fans = br.readLine();
			hugs(members, fans);
		}
		
		bw.flush();
		br.close();
		bw.close();
	}

    public static void hugs(String m, String f) {
    	ArrayList<Integer> members = new ArrayList<>();
    	ArrayList<Integer> fans = new ArrayList<>();
    	
    	//남자인 경우 1, 여자인 경우 0으로 변환
        for (int i = 0; i < m.length(); i++) members.add(m.charAt(i) == 'M' ? 1 : 0);
        for (int i = 0; i < f.length(); i++) fans.add(f.charAt(i) == 'M' ? 1 : 0);
        multiply(members, fans);
        
        return;
    }

    private static void multiply(ArrayList<Integer> members, ArrayList<Integer> fans){
    	
    	ArrayList<Integer> ans = new ArrayList<>();
    	int count = 0;
    	int mNum = members.size();
		int fNum = fans.size();

		// 오른쪽 -> 왼쪽 순서대로 팬미팅 진행
		for (int j = mNum-1; j <= fNum-1; j++){
			int t = j;
			int r = 0;
			for (int i = mNum-1; i >= 0; i--) {
				r += members.get(i) * fans.get(t--);
				ans.add(r);
			}
			if(r == 0) count++;
		}
		
		try {
			bw.append(count+"");
			bw.newLine();
		} catch (IOException e) {
			e.printStackTrace();
		}
		
		return;
    }

}
