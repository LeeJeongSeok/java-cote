package me.jeongseok.cote.programmers.level1;

public class StringToInteger {

	public int solution(String s) {
		if (s.charAt(0) == '-') {
			return -1 * Integer.parseInt(s.substring(1, s.length()).toString());
		}
		return Integer.parseInt(s);
	}

	public static void main(String[] args) {
//		System.out.println(new StringToInteger().solution("1234"));
		System.out.println(new StringToInteger().solution("-1234"));
//		System.out.println(new StringToInteger().solution("+1234"));

		System.out.println(Integer.parseInt("-1234"));
	}

}
