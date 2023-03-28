package me.jeongseok.cote.programmers.level1;

import java.util.ArrayList;
import java.util.Arrays;

public class ElementByDivisor {
	public int[] solution(int[] arr, int divisor) {
		int[] answer = Arrays.stream(arr).filter(i -> i % divisor == 0).toArray();
		if (answer.length == 0) answer = new int[] {-1};
		Arrays.sort(answer);

		return answer;
	}

	public static void main(String[] args) {
		System.out.println(new ElementByDivisor().solution(new int[]{5, 9, 7, 10}, 5));
	}

}
