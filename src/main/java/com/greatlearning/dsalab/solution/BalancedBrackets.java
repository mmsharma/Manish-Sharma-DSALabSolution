package com.greatlearning.dsalab.solution;

import java.util.Scanner;
import java.util.Stack;

public class BalancedBrackets {

	public static void main(String[] s) {
		System.out.println("Please enter the bracket string to validate");
		Scanner sc = new Scanner(System.in);
		String input = sc.nextLine();
		if (isBalanced(input)) {
			System.out.println("The entered String has Balanced Brackets");
		} else {
			System.out.println("The entered Strings do not contain Balanced Brackets");
		}
		sc.close();
	}

	public static boolean isBalanced(String bracketString) {

		if (null == bracketString || bracketString.length() % 2 != 0) {
			return false;
		}

		if (bracketString.length() == 0) {
			return true;
		}

		char[] brackets = bracketString.toCharArray();

		Stack<Character> stack = new Stack<>();

		for (char bracket : brackets) {

			if ('(' == bracket || '{' == bracket || '[' == bracket) {
				stack.push(bracket);
				continue;
			} else if (stack.isEmpty() || !isMatchingBracket(bracket, stack.pop())) {
				return false;
			}
		}
		return stack.isEmpty();
	}

	private static boolean isMatchingBracket(char currentBracket, char poppedBracket) {

		if ((currentBracket == ')' && poppedBracket == '(') || (currentBracket == '}' && poppedBracket == '{')
				|| (currentBracket == ']' && poppedBracket == '[')) {
			return true;
		}

		return false;
	}

}
