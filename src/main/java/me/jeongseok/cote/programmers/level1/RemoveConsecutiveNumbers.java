package me.jeongseok.cote.programmers.level1;

import java.util.ArrayList;
import java.util.Arrays;

/**
 * 프로그래머스 - 레벨1 - 같은 숫자는 싫어
 */
public class RemoveConsecutiveNumbers {

	public int[] solution(int[] arr) {

		ArrayList<Integer> list = new ArrayList<>();
		list.add(arr[0]);

		for (int i = 1; i < arr.length; i++) {
			if (list.get(list.size() - 1) != arr[i]) {
				list.add(arr[i]);
			}
		}

		return list.stream().mapToInt(i -> i).toArray();
	}

	public static void main(String[] args) {

	}

}
