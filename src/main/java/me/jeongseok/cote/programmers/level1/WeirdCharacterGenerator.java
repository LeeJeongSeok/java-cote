package me.jeongseok.cote.programmers.level1;

/**
 * 프로그래머스 - 레벨1 - 이상한 문자 만들기
 */

public class WeirdCharacterGenerator {

	public String solution(String s) {
		s = s.toUpperCase();
		StringBuilder sb = new StringBuilder();

		int idx = 0;

		for (int i = 0; i < s.length(); i++) {
			if (s.charAt(i) != ' ') {
				if (idx % 2 == 1) {
					sb.append((char) (s.charAt(i) + 32));
					idx++;
				} else {
					sb.append(s.charAt(i));
					idx++;
				}
			} else {
				idx = 0;
				sb.append(" ");
			}
		}

		return sb.toString();
	}

	public static void main(String[] args) {
		System.out.println(new WeirdCharacterGenerator().solution(" try  hello worl d "));
	}
}
