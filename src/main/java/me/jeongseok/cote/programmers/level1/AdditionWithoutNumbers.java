package me.jeongseok.cote.programmers.level1;

import java.util.Arrays;
import java.util.stream.IntStream;

/**
 * 프로그래머스 - 레벨1 - 없는 숫자 더하기
 */
public class AdditionWithoutNumbers {

	public int solution(int[] numbers) {

		return Arrays.stream(IntStream.rangeClosed(0, 9).toArray()).sum() - Arrays.stream(numbers).sum();
	}

	public static void main(String[] args) {
		System.out.println(new AdditionWithoutNumbers().solution(new int[]{1,2,3,4,6,7,8,0}));
		System.out.println(new AdditionWithoutNumbers().solution(new int[]{5,8,4,0,6,7,9}));
	}

}
