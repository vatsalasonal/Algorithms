import java.util.Scanner;

public class Counting_Bits338 {

	public static void main(String[] args) {
		
		Scanner sc = new Scanner(System.in);
		System.out.println("Enter the num value : ");
		int num = sc.nextInt();
		int[] totalOnes = countingBits(num);
		for (int i=0; i < totalOnes.length; i++) {
			System.out.println("The elements are : "+totalOnes[i]);
		}
		System.out.println("The total number of ones is : "+totalOnes.length);

	}

	public static int[] countingBits(int num) {
		int[] arr = new int[num+1];
		int power = 1;
		int x = 1;
		for (int i=1; i <= num; i++) {
			if (i == power) {
				arr[i] = 1;
				power = power * 2;
				x = 1;
			} else {
				arr[i] = arr[x] + 1;
				x++;
			}
		}
		return arr;
	}

}
