
public class Maximum_Product_Subarray152 {

	public static void main(String[] args) {
		
		int[] a = {2,-5,-2,-4,3};
		int totalProduct = findMaxProduct(a);
		System.out.println("The total product is : "+totalProduct);

	}

	public static int findMaxProduct(int[] a) {
		if (a.length == 0) {
			return 0;
		}
		int cur = 1, prev = 1;
		int comp = 0;
		int max = Integer.MIN_VALUE;
		for (int i=0; i < a.length; i++) {
				cur = cur * a[i];
				prev = prev * cur;
				comp = Math.max(cur, prev);
			if (max <= comp) {
				max = comp;
			}
			if (cur == 0 || prev == 0) {
				cur = 1;
				prev = 1;
			}
			cur = 1;
		}
		return max;
	}

}
