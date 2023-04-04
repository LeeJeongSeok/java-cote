package me.jeongseok.cote.programmers.level1;

import java.util.ArrayList;

/**
 * 프로그래머스 - 레벨1 - 크기가 작은 부분 문자열
 */
public class SmallSubstring {
	public int solution(String t, String p) {
		int answer = 0;
		StringBuilder sb = new StringBuilder();
		ArrayList<String> list = new ArrayList<>();

		for (int i = 0; i <= t.length() - p.length(); i++) {
			for (int j = i; j < i + p.length(); j++) {
				sb.append(t.charAt(j));
			}
			list.add(sb.toString());
			sb.delete(0, sb.length());
		}

		for (String s : list) {
			if (Long.parseLong(p) >= Long.parseLong(s)) {
				answer++;
			}
		}
		return answer;
	}

	public static void main(String[] args) {
		new SmallSubstring().solution("3141592", "271");
	}
}
