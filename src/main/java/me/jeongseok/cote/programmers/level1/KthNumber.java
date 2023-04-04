package me.jeongseok.cote.programmers.level1;

import java.util.ArrayList;
import java.util.Collections;

/**
 * 프로그래머스 - 레벨1 - K번째수
 */
public class KthNumber {

	public int[] solution(int[] array, int[][] commands) {
		int[] answer = new int[commands.length];

		for (int i = 0; i < commands.length; i++) {
			ArrayList<Integer> list = new ArrayList<>();
			for (int j = commands[i][0] - 1; j <= commands[i][1] - 1; j++) {
				list.add(array[j]);
			}
			Collections.sort(list);
			answer[i] = list.get(commands[i][2] - 1);
		}
		return answer;
	}

	public static void main(String[] args) {
		new KthNumber().solution(new int[]{1, 5, 2, 6, 3, 7, 4}, new int[][]{{2, 5, 3}});
	}

}
