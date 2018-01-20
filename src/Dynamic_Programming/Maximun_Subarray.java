import java.util.Scanner;

public class Maximun_Subarray {

	public static void main(String[] args) {
		
		Scanner sc = new Scanner(System.in);
		int a[] = {1};
		int sum = a[0], countSum = a[0];
		for (int i=0; i < a.length; i++) {
			sum = Math.max(a[i], sum+a[i]);
			countSum = Math.max(sum, countSum);
		}
		System.out.println("The countSum is : "+countSum);
	}

}
