package me.jeongseok.cote.programmers.level1;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.stream.IntStream;

/**
 * 프로그래머스 - 레벨1 - 제일 작은 수 제거하기
 */
public class RemoveMinValue {

	public int[] solution(int[] arr) {

		if (arr.length == 1) {
			return new int[]{-1};
		}

		ArrayList<Integer> list = new ArrayList<>();

		// 제일 작은 수와 대응되는 인덱스 찾기
		int min = Integer.MAX_VALUE;
		int idx = 0;

		for (int i = 0; i < arr.length; i++) {
			if (arr[i] < min) {
				min = arr[i];
				idx = i;
			}
		}

		// 제일 작은 수를 제외한 새로운 리스트
		for (int i = 0; i < arr.length; i++) {
			if (i == idx) {
				continue;
			}
			list.add(i);
		}

		return list.stream().mapToInt(i -> i).toArray();
	}

	public static void main(String[] args) {
//		System.out.println(new RemoveMinValue().solution());
	}

}
