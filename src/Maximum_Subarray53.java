
public class Maximum_Subarray53 {

	public static void main(String[] args) {
		
		int[] nums = {-2, -3, -4, -1, -2, -1, -5, -3};
		int largestSum = findMaxSubArray(nums);
		System.out.println("The largest max sub array is : "+largestSum);

	}

	public static int findMaxSubArray(int[] nums) {
		int max = Integer.MIN_VALUE;
		int cur = 0;
		for (int i=0; i < nums.length; i++) {
			cur = cur + nums[i];
			if (max <= cur) {
				max = cur;
			}
			if (cur < 0) {
				cur = 0;
			}
		}
		return max;
	}

}
