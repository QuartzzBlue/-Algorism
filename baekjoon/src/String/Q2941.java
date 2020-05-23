package String;

import java.util.Scanner;

public class Q2941 {
	
	static boolean flag = true;
	static StringBuilder sb = null;
	
	public static void subString (int index, int length) {
		sb.delete(index, index+length);
		sb.insert(index, '!');
		flag = true;
	}

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		sb = new StringBuilder();
		sb.append(sc.nextLine().trim());
		sc.close();
		
		while(true) {
			if(flag == false) { break;}
			flag = false;
			if(sb.indexOf("dz=") != -1) {
				subString(sb.indexOf("dz="), 3);
			}else if(sb.indexOf("z=") != -1) {
				subString(sb.indexOf("z="), 2);
			}else if(sb.indexOf("c=") != -1) {
				subString(sb.indexOf("c="), 2);
			}else if(sb.indexOf("c-") != -1) {
				subString(sb.indexOf("c-"), 2);
			}else if(sb.indexOf("d-") != -1) {
				subString(sb.indexOf("d-"), 2);
			}else if(sb.indexOf("lj") != -1) {
				subString(sb.indexOf("lj"), 2);
			}else if(sb.indexOf("nj") != -1) {
				subString(sb.indexOf("nj"), 2);
			}else if(sb.indexOf("s=") != -1) {
				subString(sb.indexOf("s="), 2);
			}
			
		}
		System.out.println(sb.length());

	}
}
