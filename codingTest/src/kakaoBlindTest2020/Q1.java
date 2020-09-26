package kakaoBlindTest2020;

public class Q1 {
	
	public static String makePossibleID (String new_id) {
		String tmp_id = new_id.toLowerCase();
		tmp_id = tmp_id.replaceAll("^a-z0-9_-.", "");
		return tmp_id;
	}
	
	public static void main(String[] args) {
		String new_id = "...!@BaT#*..y.abcdefghijklm";
//		String new_id = "z-+.^.";
		System.out.println(makePossibleID(new_id));
	}
}
