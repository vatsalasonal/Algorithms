import java.util.Arrays;

public class House_Robber198 {

	public static void main(String[] args) {
		
		int[] a = {6, 7, 1, 3, 8, 2, 4};
		int n = a.length - 1;
		int[] arr = new int[a.length+1];
		Arrays.fill(arr, -1);
		int robAmount = findMaxRobAmount(a, arr, n);
		System.out.println("The max amount of rob is : "+robAmount);

	}

	public static int findMaxRobAmount(int[] a, int[] arr, int n) {
		if (n < 0) {
			return 0;
		}
		if (n == 0) {
			arr[n] = a[n];
			return arr[n];
		}
		if (arr[n] != -1) {
			return arr[n];
		}
			arr[n] = Math.max(a[n] + findMaxRobAmount(a, arr, n-2), findMaxRobAmount(a, arr, n-1));
			
		return arr[n];
	}

}
