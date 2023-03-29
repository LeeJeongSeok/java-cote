package me.jeongseok.cote.programmers.level1;

/**
 * 프로그래머스 - 레벨1 - 문자열 기본 다루기
 */
public class BasicStringManipulation {

	public boolean solution(String s) {
		boolean answer = true;

		for (int i = 0; i < s.length(); i++) {
			if (!(s.charAt(i) >= 48 && s.charAt(i) <= 57)) {
				answer = false;
			}
		}
		return answer;
	}

	public static void main(String[] args) {

	}

}
