package me.jeongseok.cote.programmers.level1;

/**
 * 프로그래머스 레벨1 - 자릿수 더하기
 */
public class DigitAdd {

	public int solution(int n) {
		int sum = 0;

		while (true) {
			if (n == 0) break;

			sum += n % 10;
			n = n / 10;
		}

		return sum;
	}

	public static void main(String[] args) {
		DigitAdd digitAdd = new DigitAdd();
		System.out.println(digitAdd.solution(123));
	}
}
