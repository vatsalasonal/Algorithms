import java.util.Scanner;
import java.util.Stack;

public class Longest_Valid_Parentheses32 {

	public static void main(String[] args) {
		
		Scanner sc = new Scanner(System.in);
		System.out.println("Enter the value of string : ");
		String s = sc.nextLine();
		int i = 1;
		int length = findlongestValidParentheses(s);
		System.out.println("The length is : "+length);

	}

	public static int findlongestValidParentheses (String s) {
		Stack<Integer> stack = new Stack<Integer>();
		stack.push(-1);
		int cur = 0, len = 0;
		char[] ch = s.toCharArray();
		for (int i=0; i < s.length(); i++) {
			if (s.charAt(i) == '(') {
				stack.push(i);
			} else {
				stack.pop();
				if (!stack.empty()) {
					cur = i - stack.peek();
					len = Math.max(len, cur);
				} else {
					stack.push(i);
				}
			}
		}
		
		return len;
	}

}
