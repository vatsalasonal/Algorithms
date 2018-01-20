import java.util.Scanner;

public class Unique_Paths11_63 {

	public static void main(String[] args) {
		
		Scanner sc = new Scanner(System.in);
		/*System.out.println("Enter the row value : ");
		int row = sc.nextInt();
		System.out.println("Enter the col value : ");
		int col = sc.nextInt();*/
		int arr[][] =	{
							{0, 0, 0, 0},
							{0, 1, 0, 0},
							{0, 0, 0, 0},
							{0, 0, 1, 0},
							{0, 0, 0, 0}
							
						};
		System.out.println("The row is : "+arr.length);
		System.out.println("The col is : "+arr[0].length);
		int a[][] = new int[arr.length][arr[0].length];
		int pathSum = uniquePaths2(arr, a, arr.length-1, arr[0].length-1);
		System.out.println("The total number of path is : "+pathSum);
		int newPath = uniquePath(arr, arr.length-1, arr[0].length-1);
		System.out.println("The new path is : "+newPath);
	}

	public static int uniquePath(int[][] arr, int i, int j) {
		if (i < 0 || j < 0) {
			return 0;
		}
		if (!isSafe(arr, i , j)) {
			return 0;
		}
		if (i == 0 && j == 0) {
			return 1;
		}
		if (arr[i][j] != 0) {
			return arr[i][j];
		}
		arr[i][j] = uniquePath(arr, i, j-1) + uniquePath(arr, i-1, j);
		
		return arr[i][j];

	}

	public static int uniquePaths2(int[][] arr, int[][] a, int i, int j) {
		if (i < 0 || j < 0) {
			return 0;
		}
		if (!isSafe(arr, i, j)) {
			if (arr[i][j] != 0) {
				a[i][j] = 0;
			}
			return 0;
		}
		if (i == 0 && j == 0) {
			return 1;
		}
		if (a[i][j] != 0) {
			return a[i][j];
		}
		a[i][j] = uniquePaths2(arr, a, i, j-1) + uniquePaths2(arr, a, i-1, j);
		
		return a[i][j];
		
	}

	public static boolean isSafe(int[][] arr, int i, int j) {
		boolean set = true;
		if (arr[i][j] == 0) {
			set = true;
		}
		if (arr[i][j] == 1) {
			set = false;
		}
		return set;
	}

}
