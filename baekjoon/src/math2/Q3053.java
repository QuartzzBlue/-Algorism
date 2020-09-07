package math2;

import java.util.Scanner;

public class Q3053{

	public static void main(String[] args) {
		Scanner scan = new Scanner(System.in);
		int r = scan.nextInt();
        
        double euclide = r * r * Math.PI;
        double taxi = r * r * 2;
        System.out.println(String.format("%.6f", euclide)+"\n"+String.format("%.6f",taxi));
       
		scan.close();

	}
}
