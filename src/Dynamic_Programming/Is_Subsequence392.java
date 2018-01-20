import java.util.Scanner;

public class Is_Subsequence392 {

	public static void main(String[] args) {
		
		Scanner sc = new Scanner(System.in);
		System.out.println("Enter the first string value : ");
		String s1 = sc.nextLine();
		System.out.println("Enter the second string value : ");
		String s2 = sc.nextLine();
		int l1 = s1.length()-1;
		int l2 = s2.length()-1;
		boolean set = false;
		boolean isSequence = findStringIsSequence(s1, s2, l1, l2, set);
		boolean isSequence1 = findStringInIterativeApproach(s1, s2, l1, l2);
		System.out.println("The strings are in sequence : "+isSequence);
		System.out.println("The for loop approach : "+isSequence1);

	}

	public static boolean findStringInIterativeApproach(String s1, String s2, int l1, int l2) {
		if (s1.isEmpty()) {
			return true;
		}
		while (l1 != -1 && l2 != -1) {
			if (s1.charAt(l1) == s2.charAt(l2)) {
				l1 = l1 - 1;
			}
			l2 = l2 - 1;
			if (l1 == -1) {
				return true;
			}
		}
		return false;
	}

	public static boolean findStringIsSequence(String s1, String s2, int l1, int l2, boolean set) {
		if (l1 == -1) {
			return true;
		}
		if (l2 == -1) {
			return false;
		}
		if (s1.charAt(l1) == s2.charAt(l2)) {
			set = findStringIsSequence(s1, s2, l1-1, l2-1, set);
		} else {
			set = findStringIsSequence(s1, s2, l1, l2-1, set);
		}
		return set;
	}

}
