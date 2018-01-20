import java.util.Arrays;

public class Maximal_Square221 {

	public static void main(String[] args) {
	
		int max = Integer.MIN_VALUE;
		
		char[][] matrix = {
							{'1', '0', '1', '0', '0'},
							{'1', '0', '1', '1', '1'},
							{'1', '1', '1', '1', '1'},
							{'1', '0', '0', '1', '0'}
							
		};
		int[][]newArray = new int[matrix.length][matrix[0].length];
		for (int x=0; x < newArray.length; x++) {
			for (int y=0; y < newArray[0].length; y++) {
				newArray[x][y] = (int)(matrix[x][y] - '0');
			}
		}
		int[][] arr = new int[matrix.length][matrix[0].length];
		for (int i=0; i < arr.length; i++) {
			for (int j=0; j < arr[0].length; j++) {
				arr[i][j] = -1;
			}
		}
		int row = matrix.length - 1;
		int col = matrix.length - 1;
		int[][] arrArea = findArea(newArray, arr, row, col, max);
		for (int z=0; z < arrArea.length; z++) {
			for (int z1=0; z1 < arrArea[0].length; z1++) {
				if (arrArea[z][z1] >= max) {
					max = arrArea[z][z1];
				}
			}
		}
		System.out.println("The max is : "+max*max);
			
		
	}

	public static int[][] findArea(int[][] newArray, int[][] arr, int row, int col, int max) {
		if (row < 0 || col < 0) {
			return null;
		}
		if (row == 0 || col == 0) {
			arr[row][col] = newArray[row][col];
		}
		if (arr[row][col] != -1) {
			arr[row][col] = arr[row][col];
		}
		if (newArray[row][col] == 0) {
			arr[row][col] = 0;
			arr[row][col-1] = findMaximalSquare(newArray, arr, row, col - 1);
			arr[row-1][col] = findMaximalSquare(newArray, arr, row - 1, col);
		}
		if (newArray[row][col] == 1) {
			arr[row][col] = Math.min(Math.min(findMaximalSquare(newArray, arr, row, col-1), findMaximalSquare(newArray, arr, row-1, col-1)), 
					findMaximalSquare(newArray, arr, row-1, col)) + 1;
		}
		
		return arr;
	}

	public static int findMaximalSquare(int[][] newArray, int[][] arr, int row, int col) {
		if (newArray == null) {
			return 0;
		}
		if (row == 0 || col == 0) {
			arr[row][col] = newArray[row][col];
			return arr[row][col];
		}
		if (arr[row][col] != -1) {
			return arr[row][col];
		}
		if (newArray[row][col] == 0) {
			arr[row][col] = 0;
			arr[row][col-1] = findMaximalSquare(newArray, arr, row, col - 1);
			arr[row-1][col] = findMaximalSquare(newArray, arr, row - 1, col);
		}
		if (newArray[row][col] == 1) {
			arr[row][col] = Math.min(Math.min(findMaximalSquare(newArray, arr, row, col-1), findMaximalSquare(newArray, arr, row-1, col-1)), 
					findMaximalSquare(newArray, arr, row-1, col)) + 1;
		}
		
		return arr[row][col];
	}

}
