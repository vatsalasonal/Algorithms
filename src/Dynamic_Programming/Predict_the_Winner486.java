import java.util.Scanner;

public class Predict_the_Winner486 {

	public static void main(String[] args) {
		
		Scanner sc = new Scanner(System.in);
		int[] arr = {3606449,6,5,9,452429,7,9580316,9857582,8514433,9,6,6614512,753594,5474165,4,2697293,8,7,1};
		int p1= 0, p2 = 0;
		boolean isP1Winner = findWinner(p1, p2, arr);
		System.out.println("The p1 is winner or not : "+isP1Winner);

	}

	public static boolean findWinner(int p1, int p2, int[] arr) {
		boolean set = false;
		int i = 0, j = arr.length-1;
		int v = 0, flag = 1;
		int fp, lp = 0;
		while (i <= j) {
			if (i == j) {
				if(set) {
					p2 = p2 + arr[i];
				} else {
					p1 = p1 + arr[i];
				}
				break;
			} 
			if (i != j) {
				if (!set) {
					fp = arr[i] + arr[j-1] + p1;
					lp = arr[j] + arr[i+1] + p1;
					if (fp == lp) {
						if (arr[i] >= arr[j]) {
							v = arr[i];
							i++;
						} else {
							v = arr[j];
							j--;
						}
					} else if (fp > lp) {
						v = arr[i];
						i++;
					} else if (fp < lp) {
						v = arr[j];
						j--;
					}
					p1 = p1 + v;
					flag = 0;
				} else if (set) {
					fp = arr[i] + arr[j-1] + p2;
					lp = arr[j] + arr[i+1] + p2;
					if (fp == lp) {
						if (arr[i] >= arr[j]) {
							v = arr[i];
							i++;
						} else {
							v = arr[j];
							j--;
						}
					} else if (fp > lp) {
						v = arr[i];
						i++;
					} else if (fp < lp) {
						v = arr[j];
						j--;
					}
					p2 = p2 + v;
					flag = 1;
				}
			}
			if (flag == 0) {
				set = true;
			} else {
				set = false;
			}
		}
		System.out.println("The p1 is : "+p1);
		System.out.println("The p2 is : "+p2);
		if (p1 >= p2) {
			set = true;
		} else {
			set = false;
		}
		
		return set;
	}

}
