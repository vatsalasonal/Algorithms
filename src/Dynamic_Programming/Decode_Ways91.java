import java.util.ArrayList;
import java.util.HashMap;
import java.util.Scanner;

public class Decode_Ways91 {

	public static void main(String[] args) {
		
		Scanner sc = new Scanner(System.in);
		System.out.println("Enter the string : ");
		String s = sc.nextLine();
		ArrayList<Integer> list = new ArrayList<Integer>();
		HashMap<Integer, String> map = new HashMap<Integer, String>();
		map.put(1, "A");map.put(2, "B");map.put(3, "C");map.put(4, "D");
		map.put(5, "E");map.put(6, "F");map.put(7, "G");map.put(8, "H");
		map.put(9, "I");map.put(10, "J");map.put(11, "K");map.put(12, "L");
		map.put(13, "M");map.put(14, "N");map.put(15, "O");map.put(16, "P");
		map.put(17, "Q");map.put(18, "R");map.put(19, "S");map.put(20, "T");
		map.put(21, "U");map.put(22, "V");map.put(23, "W");map.put(24, "X");
		map.put(25, "Y");map.put(26, "Z");
		char ch[] = s.toCharArray();
		for (int x=0; x < ch.length; x++) {
			System.out.println("array is : "+ch[x]);
		}
		int n = 0, a = 1;
		if (map.containsKey(Integer.parseInt(String.valueOf(ch[0])))) {
			n = 1;
		}
		for (int i=1; i < ch.length; i++) {
			if (map.containsKey(Integer.parseInt(String.valueOf(ch[i])))) {
				int n1 = n;
				String str = String.valueOf(ch[i-1]) + String.valueOf(ch[i]);
				System.out.println(",,,,,,,,,,,,");
				if (map.containsKey(Integer.parseInt(str))) {
					n1++;
				}
				n1 = n1 + (a - 1);
				a = n1;
			}
		}
		System.out.println("The ways are : "+a);
		

	}

}
