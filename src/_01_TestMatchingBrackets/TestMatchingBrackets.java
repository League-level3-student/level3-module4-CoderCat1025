package _01_TestMatchingBrackets;

import java.util.Stack;

public class TestMatchingBrackets {
	/*
	 * Use a Stack to complete the method for checking if every opening bracket
	 * has a matching closing bracket
	 */
	public static boolean doBracketsMatch(String b) {

		Stack<Character> chars = new Stack();

		for (int i = 0; i < b.length(); i++) {
			if (b.charAt(i) == '{') {
				chars.push('{');
			} else if (b.charAt(i) == '}') {
				if (!chars.isEmpty()) {
					chars.pop();
				} else {
					return false;	
				}
			}
		}
		if (chars.isEmpty()){

			return true;
		}
		return false;
	}
}