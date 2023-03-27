package me.jeongseok.cote.programmers.level1;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.stream.IntStream;

/**
 * 프로그래머스 레벨1 - 자연수 뒤집어 배열로 만들기
 */
public class MakeArray {

	public int[] solution(int n) {
		ArrayList<Integer> list = new ArrayList<>();

		while (true) {
			if (n == 0) break;

			list.add(n % 10);
			n = n / 10;
		}

		return list.stream().mapToInt(i -> i).toArray();
	}

	public static void main(String[] args) {
		MakeArray makeArray = new MakeArray();
		System.out.println();
	}

}
