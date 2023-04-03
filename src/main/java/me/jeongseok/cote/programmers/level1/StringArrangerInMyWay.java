package me.jeongseok.cote.programmers.level1;

import java.util.Arrays;
import java.util.Comparator;
import java.util.List;
import java.util.stream.Collectors;

/**
 * 프로그래머스 - 레벨1 - 문자열 내 마음대로 정렬하기
 */
public class StringArrangerInMyWay {

	public String[] solution(String[] strings, int n) {

		List<String> list = Arrays.stream(strings).sorted().collect(Collectors.toList());
		list.sort(new Comparator<String>() {
			@Override
			public int compare(String o1, String o2) {
				return o1.charAt(n) - o2.charAt(n);
			}
		});

		return list.toArray(new String[0]);

	}

	public static void main(String[] args) {
		System.out.println(new StringArrangerInMyWay().solution(new String[]{"sun", "bed", "car"}, 1));
		System.out.println(new StringArrangerInMyWay().solution(new String[]{"abce", "abcd", "cdx"}, 2));
	}
}
