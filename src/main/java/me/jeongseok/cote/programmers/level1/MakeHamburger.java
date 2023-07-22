package me.jeongseok.cote.programmers.level1;

import java.util.ArrayList;
import java.util.Arrays;

public class MakeHamburger {
	public int solution(int[] ingredient) {
		int answer = 0;

		ArrayList<Integer> list = new ArrayList<>();
		int[] hamburger = new int[]{1, 2, 3, 1};
		int target = 0;
		int end = 0;


		// 재료들을 list에 Add
		for (int i = 0; i < ingredient.length; i++) {
			list.add(ingredient[i]);
		}

		for (int i = 0; i < list.size(); i++) {

			boolean isComplete = true;

			if (list.get(i) == 1) {
				target = i;
				for (int j = 0; j < hamburger.length; j++) {
					if (list.get(j + target) != hamburger[j]) {
						isComplete = false;
						break;
					}
				}

				if (isComplete) {
					answer++;

					for (int j = 0; j < 4; j++) {
						list.remove(target - 1);
					}

					target = 0;
					i = 0;
				}

			}
		}
		return answer;
	}

	public static void main(String[] args) {
//		System.out.println(new MakeHamburger().solution(new int[]{2, 1, 1, 2, 3, 1, 2, 3, 1}));
		System.out.println(new MakeHamburger().solution(new int[]{1, 3, 2, 1, 2, 1, 3, 1, 2}));
	}

}
