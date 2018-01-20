import java.util.ArrayList;
import java.util.Scanner;
import java.util.TreeSet;

public class Wiggle_Subsequence376 {

	public static void main(String[] args) {
		
		Scanner sc = new Scanner(System.in);
		int[] a = {1,4,7,2,5};
		ArrayList<Integer> list = new ArrayList<Integer>();
		TreeSet<Integer> ts = new TreeSet<Integer>();
		int totalSequence = findWiggleSequence(a, list, ts);
		System.out.println("The total sequence is : "+totalSequence);

	}

	public static int findWiggleSequence(int[] a, ArrayList<Integer> list, TreeSet ts) {
		int v = 0;
		for (int i=1; i < a.length; i++) {
			int d = a[i] - a[i-1];
			if (d > 0) {
				list.add(1);
			}
			if (d < 0) {
				list.add(0);
			}
			if (list.size() >= 2) {
				if (list.get(list.size()-1)==0 && list.get(list.size()-2)==1) {
					v = list.size() + 1;
				} else if (list.get(list.size()-1)==1 && list.get(list.size()-2)==0) {
					v = list.size() + 1;
				} else {
					ts.add(v);
					list.clear();
					v = 0;
				}
			}
		}
		ts.add(v);
		System.out.println("The treeset is : "+ts);
		System.out.println("The last elemnts of treeset is : "+ts.last());
		return v;
	}

}
