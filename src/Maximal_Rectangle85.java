import java.util.Scanner;
import java.util.Stack;

public class Maximal_Rectangle85 {

	public static void main(String[] args) {
		
		Scanner sc = new Scanner(System.in);
		//char[][] matrix = {};
		
		char[][] matrix = {
				{'1', '0', '1', '0', '0'},
				{'1', '0', '1', '1', '1'},
				{'1', '1', '1', '1', '1'},
				{'1', '0', '0', '1', '0'}
		};
		int row = matrix.length;
		int col = row == 0 ? 0 : matrix[0].length;
		//int[][] height = new int[m][n + 1];
		int[][] newArray = new int[row][col+1];
		int maxRectangle = findMaxRectangle(matrix, newArray);
		System.out.println("The maxRectangle area is : "+maxRectangle);

	}


	public static int makeNewArray(char[][] matrix) {
		int[][] newArray = new int[matrix.length][matrix[0].length];
		int totalArea = findMaxRectangle(matrix, newArray);
		return totalArea;
	}


	public static int findMaxRectangle(char[][] matrix, int[][] newArray) {
		int maxArea = 0;
		for (int i=0; i < matrix.length; i++) {
			for (int j=0; j < matrix[0].length; j++) {
				if (i == 0) {
					newArray[i][j] =  matrix[i][j] - '0';
				} else {
					if (matrix[i][j] == '0') {
						newArray[i][j] = 0;
					} else {
						newArray[i][j] = newArray[i-1][j] + (matrix[i][j] - '0');
					}
				}
			}
			int area = findArea(newArray[i]);
			maxArea = Math.max(maxArea, area);
		}
		return maxArea;
	}

	public static int findArea(int[] a) {
		Stack<Integer> stack = new Stack<Integer>();
		int i = 0;
		int area = 0, maxArea = 0;
		
		while (i < a.length) {
			if ((stack.empty()) || (a[stack.peek()] <= a[i])) {
				stack.push(i);
				i++;
			} else {
				int st_top = stack.pop();
				if (stack.empty()) {
					area = a[st_top] * (i);
				} else {
					area = a[st_top] * (i - stack.peek() - 1);
				}
				if (maxArea < area) {
					maxArea = area;
				}
			}
		}
		
		while (!stack.empty()) {
			int st_top = stack.pop();
			if (stack.empty()) {
				area = a[st_top] * (i);
			} else {
				area = a[st_top] * (i - stack.peek() - 1);
			}
			if (maxArea < area) {
				maxArea = area;
			}
		}
		return maxArea;
	}

}
