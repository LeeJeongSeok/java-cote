package me.jeongseok.cote.programmers.level1;

/**
 * 프로그래머스 - 레벨1 - 이상한 문자 만들기
 */

public class WeirdCharacterGenerator {

	public String solution(String s) {

		// for문에서 연산에 횟수를 줄이기 위해 입력으로 들어온 문자열을 대문자로 치환
		// 이때 소문자로 치환해도 상관 없음
		s = s.toUpperCase();

		// 결과를 담을 StringBuilder 타입의 변수 선언
		StringBuilder sb = new StringBuilder();

		// 단어의 인덱스값을 저장하는 변수
		int idx = 0;

		for (int i = 0; i < s.length(); i++) {

			// 공백이 아닌 경우
			if (s.charAt(i) != ' ') {

				// 홀수인 경우 소문자로 치환시켜준다.
				// 작업이 끝나면 해당 단어의 인덱스 값을 증가시킨다.
				if (idx % 2 == 1) {
					sb.append((char) (s.charAt(i) + 32));
					idx++;
				} else {
					// 짝수인 경우 해당 문자열을 그대로 넣어준다.
					// 작업이 끝나면 해당 단어의 인덱스 값을 증가시킨다.
					sb.append(s.charAt(i));
					idx++;
				}
			} else { // 공백인 경우
				idx = 0; // 다음에 만날 단어의 인덱스를 저장하기 위해 지금까지 저장하고 있던 idx값을 초기화 시켜준다.
				sb.append(" "); // 결과를 담을 변수에 공백을 그대로 넣어준다.
			}
		}

		return sb.toString();
	}

	public static void main(String[] args) {
		System.out.println(new WeirdCharacterGenerator().solution(" try  hello worl d "));
	}
}
