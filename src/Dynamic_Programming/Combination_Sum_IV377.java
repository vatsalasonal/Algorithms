import java.util.Arrays;
import java.util.HashMap;

public class Combination_Sum_IV377 {

	public static void main(String[] args) {
		
		int[] nums = {-1, 1};
		int target = 1;
		HashMap<Integer, Integer> map = new HashMap<Integer, Integer>();
		int[] arr = new int[target+1];
		Arrays.fill(arr, -1);
		map.put(0, 1);
		arr[0] = -1;
		int totalCombination = findCombination(nums, target, arr);
		System.out.println("The total number of combination is : "+totalCombination);
		

	}

	public static int findCombination(int[] nums, int target, int[] arr) {
		if (target == 0) {
			return 1;
		}
		if (arr[target] != -1) {
			System.out.println("The target is : "+arr[target]);
			return arr[target];
		}
		int x = 0;
		for (int i=0; i < nums.length; i++) {
			if (nums[i] < 0) {
				return 0;
			}
			if (target >= nums[i]) {
				x = x + findCombination(nums, target-nums[i], arr);
			}
		}
		arr[target] = x;
		
		return x;
	}

}
