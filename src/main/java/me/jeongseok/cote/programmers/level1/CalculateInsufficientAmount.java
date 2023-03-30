package me.jeongseok.cote.programmers.level1;

/**
 * 프로그래머스 - 레벨1 - 부족한 금액 계산하기
 */

public class CalculateInsufficientAmount {

	public long solution(int price, int money, int count) {
		long answer = 0;

		for (int i = 1; i <= count; i++) {
			// (long) (price * i)로 할 수 없는 이유는 price 2,500이고 count 2,500인 경우 n의 제곱 형태로 구성되는데 이때 int 자료형의 범위를 초과하기 때문이다.
			answer += (long) price * i;
		}

		return (money - answer > 0) ? 0 : Math.abs(money - answer);
	}

	public static void main(String[] args) {

	}

}
