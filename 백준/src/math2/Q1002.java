package math2;

import java.util.Scanner;
import java.util.ArrayList;

public class Q1002{

	public static void main(String[] args) {
		Scanner scan = new Scanner(System.in);
        String temp = null;
        
        temp = scan.nextLine();
        
        int testNum = Integer.parseInt(temp);
        
        int x1, x2, y1, y2, r1, r2, r;
        double len;
        ArrayList<Integer> arr = new ArrayList<Integer>();
        
        for(int i = 0; i < testNum; i++){
            x1 = scan.nextInt();
            y1 = scan.nextInt();
            r1 = scan.nextInt();
            x2 = scan.nextInt();
            y2 = scan.nextInt();
            r2 = scan.nextInt();
           
            temp = scan.nextLine();
            
            
            len = Math.sqrt(Math.pow(x2-x1, 2) + Math.pow(y2-y1, 2));
            
            if(x1 == x2 && y1 == y2){
            	if(r1 == r2) {
            		arr.add(-1);
            	}else{
            		arr.add(0);
            	}
            }else if(Math.abs(r2-r1) > len || len> r1+r2) {
            	arr.add(0);
            }else if(len == r1+r2 || Math.abs(r2-r1) == len) {
            	arr.add(1);
            }else {
            	arr.add(2);
            }
        }
        
        for(int i = 0; i < testNum; i++){
        	System.out.println(arr.get(i));
        	
        }
        return;
	}

}

