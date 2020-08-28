package String;

import java.util.ArrayList;
import java.util.Scanner;
import java.util.StringTokenizer;

public class Q1152 {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		StringTokenizer st = new StringTokenizer(sc.nextLine().trim());
		sc.close();
		
		ArrayList<String> words = new ArrayList<>();
		while(st.hasMoreTokens()) {
			String word = st.nextToken();
			if(word != " " && word != "\n") {
				words.add(word);
			}
		}
		System.out.println(words.size());
	}

}
