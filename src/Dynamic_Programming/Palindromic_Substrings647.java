import java.util.HashMap;
import java.util.Scanner;

public class Palindromic_Substrings647 {

	public static void main(String[] args) {
		
		Scanner sc = new Scanner(System.in);
		System.out.println("Enter the string value : ");
		String s = sc.nextLine();
		s = s + "0";
		int totalCount = totalCountOfSubstring(s);
		System.out.println("The total number of substring is : "+totalCount);

	}

	public static int totalCountOfSubstring(String s) {
		HashMap<String, Integer> map = new HashMap<String, Integer>();
		int v = 0;
		for (int i=0; i < s.length()-1; i++) {
			for (int j=i+1; j < s.length(); j++) {
				String str = s.substring(i, j);
				StringBuilder input1 = new StringBuilder();
				input1.append(str);
				input1 = input1.reverse();
				String rev = input1.toString();
				if (str.equals(rev)) {
					if (!map.containsKey(str)) {
						map.put(str, 1);
						v++;
					} else {
						int val = map.get(str);
						val++;
						map.put(str, val);
						v++;
					}
				}
			}
		}
		System.out.println("The map is : "+map);
		
		return v;
	}

}
