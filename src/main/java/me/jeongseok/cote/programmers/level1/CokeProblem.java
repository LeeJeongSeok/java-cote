package me.jeongseok.cote.programmers.level1;

/**
 * 프로그래머스 - 레벨1 - 콜라 문제
 */

public class CokeProblem {

	public int solution(int a, int b, int n) {
		int answer = 0;

		while (n / a > 0) {
			answer += (n / a) * b;
			n = (n / a) * b + n % a;
		}

		return answer;
	}

	public static void main(String[] args) {
		System.out.println(new CokeProblem().solution(3, 1, 20));
	}

}
