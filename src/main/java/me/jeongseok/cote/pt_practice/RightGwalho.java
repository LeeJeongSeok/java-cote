package me.jeongseok.cote.pt_practice;

import java.util.*;

public class RightGwalho {

	public boolean solution(String s) {
		boolean answer = true;

		Stack<Character> stack = new Stack<>();

		for (int i = 0; i < s.length(); i++) {
			if (s.charAt(i) == '(') {
				stack.push('(');
			} else if (s.charAt(i) == ')') {
				if (stack.isEmpty()) {
					return false;
				}
				stack.pop();
			}
		}

		return stack.isEmpty();
	}

	public static void main(String[] args) {

	}

}
