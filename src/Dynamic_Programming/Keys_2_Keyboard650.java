import java.util.Scanner;

public class Keys_2_Keyboard650 {

	public static void main(String[] args) {
		
		Scanner sc = new Scanner(System.in);
		System.out.println("Enter the value of n : ");
		int n = sc.nextInt();
		int steps = findSteps(n);
		System.out.println("The number of steps are : "+steps);

	}

	public static int findSteps (int n) {
		if (n == 1) {
			return 0;
		}
		int a = 2, c = 2, x = a;
		while (x != n) {
			if (n % a == 0) {
				int num = a;
				c = c + 2;
				a = x + a;
				x = a;
				if (n % a != 0) {
					a = num;
					c--;
				}
			}
			if (n % a != 0) {
				a = a + 1;
				x = a;
				c++;
			}
		}
		return c;
	}

}
