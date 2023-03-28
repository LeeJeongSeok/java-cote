package me.jeongseok.cote.programmers.level1;

import java.util.Arrays;
import java.util.stream.IntStream;

public class FindKim {

	public String solution(String[] seoul) {

		int idx = IntStream.range(0, seoul.length)
			.filter(i -> seoul[i].equals("Kim"))
			.findFirst()
			.orElse(-1);

		return "김서방은 " + idx + "에 있다.";
	}

	public static void main(String[] args) {
		System.out.println(new FindKim().solution(new String[]{"Jane", "Kim"}));
	}

}
