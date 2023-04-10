package me.jeongseok.cote.programmers.level1;

import java.util.ArrayList;
import java.util.Collections;

public class FruitVendor {

	public int solution(int k, int m, int[] score) {
		int answer = 0;

		ArrayList<Integer> list = new ArrayList<>();

		for (int i = 0; i < score.length; i++) {
			list.add(score[i]);
		}

		// 큰 점수순으로 정렬
		list.sort(Collections.reverseOrder());

		while (true) {

			// list의 사이즈가 m보다 작으면 더이상 상자를 만들 수 없으니 탈출
			if (list.size() < m) {
				break;
			}

			// 앞에서부터 m개씩 잘라서 박스로 포장한다.
			ArrayList<Integer> box = new ArrayList<>();
			for (int i = 0; i < m; i++) {
				box.add(list.get(i));
			}

			// 최소값을 구하고 금액을 계산한다.
			answer += (Collections.min(box) * m);

			for (int i = 0; i < m; i++) {
				list.remove(0);
			}

		}

		return answer;
	}

	public static void main(String[] args) {
		System.out.println(new FruitVendor().solution(3, 4, new int[]{1, 2, 3, 1, 2, 3, 1}));
		System.out.println(new FruitVendor().solution(4, 3, new int[]{4, 1, 2, 2, 4, 4, 4, 4, 1, 2, 4, 2}));
	}

}
