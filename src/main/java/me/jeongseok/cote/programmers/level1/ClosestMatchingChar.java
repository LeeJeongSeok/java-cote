package me.jeongseok.cote.programmers.level1;

/**
 * 프로그래머스 - 레벨1 - 가장 가까운 글자
 */
public class ClosestMatchingChar {

	public int[] solution(String s) {
		int[] answer = new int[s.length()];

		for (int i = s.length() - 1; i >= 0; i--) {
			int idx = Integer.MAX_VALUE;
			int count = 0;

			for (int j = i - 1; j >= 0; j--) {
				count++;
				if (s.charAt(i) == s.charAt(j)) {
					idx = Math.min(idx, count);
				}
			}

			if (idx == Integer.MAX_VALUE) {
				answer[i] = -1;
			} else {
				answer[i] = idx;
			}
		}
		return answer;
	}

	public static void main(String[] args) {

	}
}
