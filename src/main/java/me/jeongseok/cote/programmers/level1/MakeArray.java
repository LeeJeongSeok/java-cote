package me.jeongseok.cote.programmers.level1;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.stream.IntStream;

/**
 * 프로그래머스 레벨1 - 자연수 뒤집어 배열로 만들기
 *
 *
 */
public class MakeArray {

	public int[] solution(long n) {

		String reverse = new StringBuilder(String.valueOf(n)).reverse().toString();
		int[] answer = new int[reverse.length()];

		String[] split = reverse.split("");

		for (int i = 0; i < split.length; i++) {
			answer[i] = Integer.parseInt(split[i]);
		}

		return answer;
	}

	public static void main(String[] args) {
		MakeArray makeArray = new MakeArray();
		System.out.println();
	}

}
