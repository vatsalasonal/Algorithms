
public class Scramble_String87 {

	public static void main(String[] args) {
		
		String s1 = "great";
		String s2 = "rgeat";
		boolean isScramble = findIsStringScramble(s1, s2);
		System.out.println("The string is scramble : "+isScramble);

	}

	public static boolean findIsStringScramble(String s1, String s2) {
		String str = findScramble(s2);
		System.out.println("The str is : "+str);
		if (str == s1) {
			return true;
		}
		return false;
	}

	public static String findScramble(String s2) {
		if (s2.length() == 1) {
			return s2;
		}
		String str = findScramble(s2.substring(0, s2.length()/2)) 
						+ findScramble(s2.substring(s2.length()/2));
				
		return null;
	}

}
