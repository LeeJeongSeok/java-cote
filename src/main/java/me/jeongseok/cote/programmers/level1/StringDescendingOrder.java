package me.jeongseok.cote.programmers.level1;

import java.util.Arrays;
import java.util.Collections;

/**
 * 프로그래머스 - 레벨1 - 문자열 내림차순
 */
public class StringDescendingOrder {

	public String solution(String s) {
		StringBuilder sb = new StringBuilder();
		char[] c = s.toCharArray();
		Arrays.sort(c);

		for (int i = 0; i < c.length; i++) {
			sb.append(c[i]);
		}

		return sb.reverse().toString();
	}

	public static void main(String[] args) {

	}
}
