import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;

public class Triangle120 {

	public static void main(String[] args) {
		
		List<List<Integer>> tree = new ArrayList<List<Integer>>();
		tree.add(0, new ArrayList<Integer>(Arrays.asList(2)));
		tree.add(1, new ArrayList<Integer>(Arrays.asList(3,4)));
		tree.add(2, new ArrayList<Integer>(Arrays.asList(6,5,7)));
		tree.add(3, new ArrayList<Integer>(Arrays.asList(4,1,8,3)));
		int minCost = findMinTotalCost(tree);
		System.out.println("The min cost is : "+minCost);

	}

	public static int findMinTotalCost(List<List<Integer>> tree) {
		if (tree.isEmpty()) {
			return 0;
		}
		int i = 0, len = 0;
		List<List<Integer>> tree1 = new ArrayList<List<Integer>>();
		for (int x=0; x < tree.size(); x++) {
			List<Integer> list = new ArrayList<Integer>();
			for (int j=0; j < tree.get(x).size(); j++) {
				list.add(-1);
			}
			tree1.add((ArrayList<Integer>) list);
		}
		int listCost = findListCost(tree, i, len, tree1);
		
		return listCost;
	}

	public static int findListCost(List<List<Integer>> tree, int i, int len, List<List<Integer>> tree1) {
		if (len >= tree.size()) {
			return 0;
		}
		if (tree1.get(len).get(i) != -1) {
			return tree1.get(len).get(i);
		}
		List<Integer> l1 = tree.get(len);
		int x = l1.get(i) + Math.min(findListCost(tree, i, len+1, tree1), findListCost(tree, i+1, len+1, tree1));
		tree1.get(len).add(i, x);
		
		return tree1.get(len).get(i);
	}
	
}
