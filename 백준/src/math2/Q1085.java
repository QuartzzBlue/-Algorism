package math2;

import java.util.Scanner;
import java.util.ArrayList;
import java.util.Collections;

public class Q1085{

	public static void main(String[] args) {
		Scanner scan = new Scanner(System.in);
        int a = scan.nextInt();
        int b = scan.nextInt();
        int x = scan.nextInt();
        int y = scan.nextInt();
        
        ArrayList<Integer> length = new ArrayList<Integer>();
        length.add(a);
        length.add(b);
        length.add(x-a);
        length.add(y-b);
        
        System.out.println(Collections.min(length));
        
        scan.close();
	}

}

