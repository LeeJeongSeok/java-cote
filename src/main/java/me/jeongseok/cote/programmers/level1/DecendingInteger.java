package me.jeongseok.cote.programmers.level1;

import java.util.Arrays;

/**
 * 프로그래머스 - 레벨1 - 정수 내림차순으로 배치하기
 *
 * 118372	873211
 *
 * 문자 형태로 변환 후, 자릿수 하나씩 비교 후 swap
 */
public class DecendingInteger {

	public long solution(long n) {
		char[] chars = new StringBuilder(String.valueOf(n)).toString().toCharArray();

		for (int i = 0; i < chars.length; i++) {
			for (int j = i; j < chars.length; j++) {
				if (chars[i] < chars[j]) {
					char c = chars[i];
					chars[i] = chars[j];
					chars[j] = c;
				}
			}
		}

		return Long.parseLong(new String(chars));
	}

	public static void main(String[] args) {
		System.out.println(new DecendingInteger().solution(118372));
	}

}
