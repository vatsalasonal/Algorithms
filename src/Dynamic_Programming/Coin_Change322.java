import java.util.Arrays;
import java.util.Scanner;

public class Coin_Change322 {

	public static void main(String[] args) {
		
		Scanner sc = new Scanner(System.in);
		System.out.println("Enter the amount value : ");
		int amount = sc.nextInt();//6249 ans = 20  186,419,83,408
		int[] coins = {186,419,83,408};
		int[] arr = new int[amount+1];
		Arrays.fill(arr, Integer.MAX_VALUE);
		arr[0] = 0;
		int totalNumCoins = findTotalNumberCoins(coins, amount, arr);
		System.out.println("The total number of coins is : "+totalNumCoins);
	}

	public static int findTotalNumberCoins(int[] coins, int amount, int[] arr) {
		
		for (int i=1; i < arr.length; i++) {
			for (int j=0; j < coins.length; j++) {
				if (i >= coins[j]) {
					int d = i - coins[j];
					if (arr[d] == -1) {
						arr[i] = -1;
					} else {
						d = arr[d] + 1;
						arr[i] = Math.min(arr[i], d);
					}
				}
			}
			if (arr[i] == Integer.MAX_VALUE) {
				arr[i] = -1;
			}
		}
		if (arr[arr.length-1] == Integer.MAX_VALUE) {
			arr[arr.length-1] = -1;
		}
		return arr[arr.length-1];
	}

}
