import java.util.Scanner;

public class Unique_Paths62 {

	public static void main(String[] args) {
		
		Scanner sc = new Scanner(System.in);
		System.out.println("Enter the row value : ");
		int m = sc.nextInt();
		System.out.println("Enter the column value : ");
		int n = sc.nextInt();
		int arr[][] = new int[m][n];
		int paths = uniquePaths(arr, m-1, n-1);
		System.out.println("The paths is : "+paths);
	}

	public static int uniquePaths(int[][] arr, int i, int j) {
		if (i < 0 || j < 0) {
			return 0;
		}
		if (i==0 || j==0) {
			arr[i][j] = 1;
			return 1;
		}
		if (arr[i][j] != -1) {
			return arr[i][j];
		}
		arr[i][j] =  uniquePaths(arr, i, j-1) + uniquePaths(arr, i-1, j);
		
		return arr[i][j];
	}

}
