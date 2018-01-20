import java.util.ArrayList;
import java.util.Arrays;

public class Minimum_Path_Sum64 {

	public static void main(String[] args) {
		
		int grid[][] = 	{
							{1, 2, 3},
							{1, 0, 3},
							{2, 1, 5}
						};
		System.out.println("The row is : "+grid.length);
		System.out.println("The col is : "+grid[0].length);
		int arr[][] = new int[grid.length][grid[0].length];
		ArrayList<ArrayList<Integer>> list = new ArrayList<ArrayList<Integer>>();
		ArrayList<ArrayList<Integer>> list1 = new ArrayList<ArrayList<Integer>>();
		for (int i=0; i < grid.length; i++) {
			ArrayList<Integer> ar = new ArrayList<Integer>();
			ArrayList<Integer> ar1 = new ArrayList<Integer>();
			for (int j=0; j < grid[0].length; j++) {
				arr[i][j] = -1;
				ar.add(grid[i][j]);
			}
			list.add(ar);
		}
		int arr1[][] = new int[list.size()][list.get(0).size()];
		for (int i=0; i < arr1.length; i++) {
			for (int j=0; j < arr1[0].length; j++) {
				arr1[i][j] = -1;
			}
		}
		System.out.println("The list is : "+list);
		int minSum = minPathSum(grid, arr, grid.length-1, grid[0].length-1);
		int minSum1 = minPathSum1(list, arr1, list.size()-1, list.get(0).size()-1);
		grid = null;
		System.out.println("The minSum is : "+minSum);
		System.out.println("The minSum1 is : "+minSum1);
		
	}

	public static int minPathSum1(ArrayList<ArrayList<Integer>> list, int[][] arr, int i, int j) {
		if (i < 0 || j < 0) {
			return Integer.MAX_VALUE;
		}
		if (i == 0 && j == 0) {
			return list.get(i).get(j);
		}
		if (arr[i][j] != -1) {
			return arr[i][j];
		}
		arr[i][j] = list.get(i).get(j) + Math.min(minPathSum1(list, arr, i, j-1), minPathSum1(list, arr, i-1, j));
		
		return arr[i][j];
	}

	public static int minPathSum(int[][] grid, int[][] arr, int i, int j) {
		if (i < 0 || j < 0) {
			return Integer.MAX_VALUE;
		}
		if (i == 0 && j == 0) {
			return grid[i][j];
		}
		if (arr[i][j] != -1) {
			return arr[i][j];
		}
		arr[i][j] = grid[i][j] + Math.min(minPathSum(grid, arr, i, j-1), minPathSum(grid, arr, i-1, j));
		
		return arr[i][j];
	}

}
