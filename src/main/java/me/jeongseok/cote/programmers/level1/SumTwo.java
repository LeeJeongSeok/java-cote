package me.jeongseok.cote.programmers.level1;

import java.util.TreeSet;

/**
 * 프로그래머스 - 레벨1 - 두 개 뽑아서 더하기
 */
public class SumTwo {

	public int[] solution(int[] numbers) {

		TreeSet<Integer> set = new TreeSet<>();

		for (int i = 0; i < numbers.length; i++) {
			for (int j = i + 1; j < numbers.length; j++) {
				set.add(numbers[i] + numbers[j]);
			}
		}

		return set.stream().mapToInt(i -> i).toArray();
	}
	public static void main(String[] args) {

	}

}
