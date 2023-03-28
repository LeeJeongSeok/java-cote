package me.jeongseok.cote.programmers.level1;

/**
 * 1-1. 입력된 수가 짝수라면 2로 나눕니다.
 * 1-2. 입력된 수가 홀수라면 3을 곱하고 1을 더합니다.
 * 2. 결과로 나온 수에 같은 작업을 1이 될 때까지 반복합니다.
 */
public class Collatz {
	public int solution(long num) {
		int answer = 0;

		if (num > 1) {
			while (true) {
				// while문의 종료조건
				if (num == 1) {
					break;
				}
				if (num % 2 == 0) {
					num = num / 2;
					answer++;
				} else if (num % 2 != 0) {
					num = num * 3 + 1;
					answer++;
				}
			}
		}
		return (answer >= 500) ? -1 : answer;
	}

	public static void main(String[] args) {
		System.out.println(new Collatz().solution(6));
		System.out.println(new Collatz().solution(16));
		System.out.println(new Collatz().solution(626331));
	}
}
