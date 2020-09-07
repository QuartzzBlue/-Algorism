package bruteForce;

import java.util.Scanner;

public class Q1436 {

   public static void main(String[] args) throws Exception {
      Scanner scan = new Scanner(System.in);
      int n = scan.nextInt();
      scan.close();
      StringBuilder sb = new StringBuilder();
      int count = 1;
      int num = 666;
      
      while(count != n) {
         num++;
         sb.append(String.valueOf(num));
         if(sb.indexOf("666") != -1) {
            count++;
         }
         sb.delete(0, sb.length());
         
      }      
      System.out.println(num);
      return;
   }
}
