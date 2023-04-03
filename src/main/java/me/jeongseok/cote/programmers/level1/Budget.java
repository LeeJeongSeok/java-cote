package me.jeongseok.cote.programmers.level1;

import java.util.Arrays;

/**
 * 프로그래머스 - 레벨1 - 예산 풀이
 */
public class Budget {

	public int solution(int[] d, int budget) {
		int answer = 0;
		Arrays.sort(d);

		for (int j : d) {
			budget -= j;
			if (budget < 0)
				break;
			answer++;
		}
		return answer;
	}

	public static void main(String[] args) {

	}

}
