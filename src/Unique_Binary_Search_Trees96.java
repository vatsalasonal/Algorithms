import java.util.Arrays;
import java.util.Scanner;

public class Unique_Binary_Search_Trees96 {

	public static void main(String[] args) {
		
		Scanner sc = new Scanner(System.in);
		System.out.println("Enter the n value : ");
		int n = sc.nextInt();
		int[] arr = new int[n+1];
		Arrays.fill(arr, -1);
		arr[0] = 1;
		int totalTree = findTotalNumTree(n, arr);
		System.out.println("The total number of tree is : "+totalTree);

	}

	public static int findTotalNumTree(int n, int[] arr) {
		if (n == 0) {
			return 1;
		}
		if (arr[n] != -1) {
			return arr[n];
		}
		int sum = 0;
		for (int i=n; i > 0; i--) {
			sum = sum + findTotalNumTree(i - 1, arr) * findTotalNumTree(n - i, arr);
		}
		arr[n] = sum;
		
		return arr[n];
	}

}
