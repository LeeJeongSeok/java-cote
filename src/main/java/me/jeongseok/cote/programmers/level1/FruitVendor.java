package me.jeongseok.cote.programmers.level1;

import java.util.Arrays;

public class FruitVendor {

	public int solution(int k, int m, int[] score) {
		int answer = 0;

		Arrays.sort(score);
		int[] reverseScore = new int[score.length];

		for (int i = 0; i < score.length; i++) {
			reverseScore[i] = score[score.length - 1 - i];
		}

		int idx = 0;
		while (true) {

			// list의 사이즈가 m보다 작으면 더이상 상자를 만들 수 없으니 탈출
			if (idx >= reverseScore.length || idx + m > reverseScore.length) {
				break;
			}
			// 최소값을 구하고 금액을 계산한다.
			answer += reverseScore[idx + m - 1] * m;
			idx += m;

		}

		return answer;
	}

	public static void main(String[] args) {
		System.out.println(new FruitVendor().solution(3, 4, new int[]{1, 2, 3, 1, 2, 3, 1}));
		System.out.println(new FruitVendor().solution(4, 3, new int[]{4, 1, 2, 2, 4, 4, 4, 4, 1, 2, 4, 2}));
	}

}
