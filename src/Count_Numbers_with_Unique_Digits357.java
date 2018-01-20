
public class Count_Numbers_with_Unique_Digits357 {

	public static void main(String[] args) {
		
		int n = 1;
		int[] arr = new int[n+1];
		arr[0] = 1;
		int totalCount = findTotalCount(n, arr);
		System.out.println("The total count is : "+totalCount);

	}

	public static int findTotalCount(int n, int[] arr) {
		if (n == 0) {
			return arr[n];
		}
		arr[1] = 9;
		int sum = arr[0] + arr[1];
		for (int i=2; i <= n; i++) {
			arr[i] = arr[i-1] * (10 - i + 1);
			sum = sum + arr[i];
		}
		return sum;
	}

}
