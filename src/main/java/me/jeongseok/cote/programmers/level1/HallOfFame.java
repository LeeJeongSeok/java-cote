package me.jeongseok.cote.programmers.level1;

import java.util.ArrayList;
import java.util.Collections;

/**
 * 프로그래머스 - 레벨1 - 명예의 전당 (1)
 */
public class HallOfFame {

	public int findMinValueIdx(ArrayList<Integer> list) {
		int min = Integer.MAX_VALUE;
		int idx = 0;

		for (int i = 0; i < list.size(); i++) {
			if (list.get(i) < min) {
				min = list.get(i);
				idx = i;
			}
		}

		return idx;
	}

	public int[] solution(int k, int[] score) {
		int[] answer = new int[score.length];

		ArrayList<Integer> list = new ArrayList<>();

		for (int i = 0; i < score.length; i++) {
			if (list.size() != k) {
				list.add(score[i]);
			} else {
				for (int j = 0; j < k; j++) {
					if (score[i] > list.get(j)) {
						list.remove(k - 1);
						list.add(score[i]);
						break;
					}
				}
			}

			Collections.sort(list, Collections.reverseOrder());
			answer[i] = list.get(list.size() - 1);
		}

		return answer;
	}



	public static void main(String[] args) {
		System.out.println(new HallOfFame().solution(3, new int[]{10, 100, 20, 150, 1, 100, 200}));
	}

}
