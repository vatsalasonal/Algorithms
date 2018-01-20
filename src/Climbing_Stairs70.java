import java.util.Scanner;

public class Climbing_Stairs70 {

	public static void main(String[] args) {
		
		Scanner sc = new Scanner(System.in);
		System.out.println("Enter the n value : ");
		int n = sc.nextInt();
		int[] arr = new int[n+1];
		for (int i=0; i < arr.length; i++) {
			arr[i] = -1;
		}
		int totalPaths = climbStairs(arr, n);
		arr = null;
		System.out.println("The totalPaths is : "+totalPaths);

	}

	public static int climbStairs(int[] arr, int n) {
		if (n < 0) {
			return 0;
		}
		if (arr[n] != -1) {
			return arr[n];
		}
		if (n == 0) {
			return 1;
		}
		arr[n] = climbStairs(arr, n-1) + climbStairs(arr, n-2);
		
		return arr[n];
	}

}
