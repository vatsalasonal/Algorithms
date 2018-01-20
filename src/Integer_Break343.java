import java.util.HashMap;
import java.util.Scanner;

public class Integer_Break343 {

	public static void main(String[] args) {
		
		Scanner sc = new Scanner(System.in);
		System.out.println("Enter the x value : ");
		int x = sc.nextInt();
		//System.out.println("Enter the n value : ");
	//	int n = sc.nextInt();
		System.out.println("Enter the value of main n : ");
		int num = sc.nextInt();
		//HashMap<Integer, Integer> map = new HashMap<Integer, Integer>();
		int breakNumber = findBreakNumber(x, num);
		/*int pow = findPower(x, breakNum, map, res);
		int power = findPower(x, breakNum);*/
		System.out.println("The break number is : "+breakNumber);
	}

	public static int findBreakNumber(int x, int num) {
		int breakNum = num / x;
		int res = 0;
		HashMap<Integer, Integer> map = new HashMap<Integer, Integer>();
		int pow = findPower(x, breakNum, map, res);
		return 0;
	}

	public static int findPower(int x, int n) {
		if (n == 0) {
			return 1;
		}
		int num = findPower(x, n/2);
		
		if (n % 2 == 0) {
			return num * num;
		} else {
			return x * num * num;
		}
	}

	public static int findPower(int x, int n, HashMap<Integer, Integer> map, int res) {
		if (n == 0) {
			map.put(n, x);
			return 1;
		}
		if (map.containsKey(n)) {
			return map.get(n);
		}
		if (n % 2 == 0) {
			res = findPower(x, n/2, map, res) * findPower(x, n/2, map, res);
			map.put(n, res);
		} else {
			res = x * findPower(x, n/2, map, res) * findPower(x, n/2, map, res);
			map.put(n, res);
		}
		return res;
	}

}
