import java.util.Scanner;

public class Perfect_Squares279 {

	public static void main(String[] args) {
		
		Scanner sc = new Scanner(System.in);
		System.out.println("Enter the n value : ");
		int n = sc.nextInt();
		int[] arr = new int[n+1];
		for (int i=0; i < arr.length; i++) {
			if (i <= 3) {
				arr[i] = i;
			}
			arr[i] = -1;
		}
		int sum = findSquares(n, arr);
		System.out.println("Ths sum is : "+sum);

	}

	public static int findSquares(int n, int[] arr) {
		if (n <= 3) {
			return n;
		}
		if(arr[n] != -1) {
			return arr[n];
		}
		int x = n;
		for (int i=1; i <= n; i++) {
			int sq = i * i;
			if (sq > n) {
				arr[n] = x;
				break;
			}
			x = Math.min(x, 1 + findSquares((n - sq), arr));
			
		}
		return x;
	}

}
