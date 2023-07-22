package me.jeongseok.cote;

import java.util.Arrays;

// 문자열 밀기
public class Test2 {
	public static int solution(String A, String B) {

		int answer = 0;

		while (true) {

			if (answer > A.length()) {
				return -1;
			}

			char[] newArray = new char[A.length()];
			for (int i = 0; i < A.length(); i++) {
				newArray[(i + answer) % A.length()] = A.charAt(i);
			}

			if (B.equals(new String(newArray))) {
				return answer;
			}

			answer++;
		}
	}

	public static void main(String[] args) {
		System.out.println(solution("hello", "ohell"));
		System.out.println(solution("apple", "elppa"));
		System.out.println(solution("atat", "tata"));
		System.out.println(solution("abc", "abc"));
	}
}
