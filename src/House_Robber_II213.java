import java.util.Arrays;

public class House_Robber_II213 {

	public static void main(String[] args) {
		
		int[] a = {5, 3, 4, 11, 2};
		int[] arr = new int[a.length];
		Arrays.fill(arr, -1);
		int n = a.length - 1;
		int robAmount = findRobAmount(a, arr, n);
		System.out.println("The rob amount is : "+robAmount);

	}

	public static int findRobAmount(int[] a, int[] arr, int n) {
		if (n < 0) {
			return 0;
		}
		if (n == 0) {
			if (arr[n] == -1) {
				arr[n] = a[n];
				return 0;
			}
			return arr[n];
		}
		if (arr[n] != -1) {
			return arr[n];
		}
			arr[n] = Math.max(a[n] + findRobAmount(a, arr, n-1), findRobAmount(a, arr, n-1));
			
		return arr[n];
	}

}
