import java.util.Scanner;

public class Perfect_Squares279II {

	public static void main(String[] args) {
	
		Scanner sc = new Scanner(System.in);
		System.out.println("Enter the n value : ");
		int n = sc.nextInt();
		int total = numSquares(n);
		System.out.println("The total is : "+total);

	}

	public static int numSquares(int n) {
		if (n <= 3) {
			return n;
		}
		int x = n;
		for (int i=1; i <= n; i++) {
			int sq = i * i;
			if (sq > n) {
				break;
			}
			x = Math.min(x, 1 + numSquares(n - sq));
			
		}
		return x;
	}

}
