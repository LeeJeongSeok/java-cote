package me.jeongseok.cote.programmers.level1;

public class SplitString {
	public int solution(String s) {
		int answer = 0;

		while (s.length() != 0) {
			char ch = s.charAt(0);

			int xCount = 1;
			int yCount = 0;

			for (int i = 1; i < s.length(); i++) {
				if (ch == s.charAt(i)) {
					xCount++;
				}
				if (ch != s.charAt(i)) {
					yCount++;
				}
				if (xCount == yCount) {
					break;
				}
			}

			s = s.substring(xCount + yCount);

			answer++;
		}

		return answer;
	}

	public static void main(String[] args) {

	}
}
