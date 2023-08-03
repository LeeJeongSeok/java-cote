package me.jeongseok.cote.pt_practice;

import java.util.*;

// 스택에 차례대로 문자를 저장하면서 이전에 저장된 문자와 현재 저장하려는 문자가 같으면 이전에 저장된 문자를 제거하는 방식을 사용하면 간단하게 풀 수 있습니다.

public class RemoveParis_UsingStack {

	public int solution(String s) {
		int answer = 0;

		Stack<Character> stack = new Stack<>();

		for (int i = 0; i < s.length(); i++) {
			if (stack.isEmpty()) {
				stack.push(s.charAt(i));
			} else if (stack.peek() != s.charAt(i)) {
				stack.push(s.charAt(i));
			} else {
				stack.pop();
			}
		}

		if (stack.isEmpty()) {
			answer = 1;
		}

		return answer;
	}

	public static void main(String[] args) {
		System.out.println(new RemoveParis_UsingStack().solution("baabaa"));
		System.out.println(new RemoveParis_UsingStack().solution("cdcd"));
		System.out.println(new RemoveParis_UsingStack().solution("aaaa"));
	}

}
