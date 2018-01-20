import java.util.Scanner;

public class Edit_Distance72 {

	public static void main(String[] args) {
		
		Scanner sc = new Scanner(System.in);
		System.out.println("Enter the s1 string value : ");
		String s1 = sc.nextLine();
		System.out.println("Enter the s2 string value : ");
		String s2 = sc.nextLine();
		s1 = " " + s1;
		s2 = " " + s2;
		int[][] arr = new int[s1.length()][s2.length()];
		for (int i=0; i < arr.length; i++) {
			for (int j=0; j < arr[0].length; j++) {
				arr[i][j] = -1;
			}
		}
		int totalOperation = minDistancePath(s1, s2, arr, arr.length-1, arr[0].length-1);
		System.out.println("The total number of operation is : "+totalOperation);
	}

	public static int minDistancePath(String s1, String s2, int[][] arr, int i, int j) {
		if (i < 0 || j < 0) {
			return 0;
		}
		if (i == 0 || j == 0) {
			int max = Math.max(i,  j);
			arr[i][j] = max;
			return max;
		}
		if ((s1.charAt(i) == s2.charAt(j))) {
			arr[i][j] = minDistancePath(s1, s2, arr, i-1, j-1);
		}
		if (arr[i][j] != -1) {
			return arr[i][j];
		}
		arr[i][j] = 1 + Math.min(Math.min(minDistancePath(s1, s2, arr, i, j-1), minDistancePath(s1, s2, arr, i-1, j-1)), 
				minDistancePath(s1, s2, arr, i-1, j));
		
		return arr[i][j];
	}

}
