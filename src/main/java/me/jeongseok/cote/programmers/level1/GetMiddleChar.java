package me.jeongseok.cote.programmers.level1;

/**
 * 프로그래머스 - 레벨1 - 가운데 글자 가져오기
 */
public class GetMiddleChar {

	public String solution(String s) {
		return (s.length() % 2 == 0) ? String.valueOf(s.charAt((s.length() / 2 - 1))) + String.valueOf(s.charAt(s.length() / 2)) : String.valueOf(s.charAt(s.length() / 2));
	}

	public static void main(String[] args) {
		System.out.println(new GetMiddleChar().solution("abcde"));
		System.out.println(new GetMiddleChar().solution("qwer"));
	}
}
