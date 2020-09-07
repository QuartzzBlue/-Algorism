package baekjoon;

import java.util.Arrays;
import java.util.Scanner;

public class Q10817 {

	public static void main(String[] args) {
		Scanner scan = new Scanner(System.in);
        int[] input = new int[3];
        
        for(int i = 0; i < 3; i++){
            input[i] = scan.nextInt();
        }
        
        Arrays.sort(input);
      
        System.out.println(input[1]);
        scan.close();
        scan = null;
	}

}
