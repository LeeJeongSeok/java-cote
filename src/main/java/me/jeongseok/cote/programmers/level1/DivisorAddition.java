package me.jeongseok.cote.programmers.level1;

/**
 * 프로그래머스 - 레벨1 - 약수의 개수와 덧셈
 */
public class DivisorAddition {

	// 매개변수로 들어온 숫자의 약수 개수를 구한다.
	public int getDivisorCount(int num) {
		int count = 0;

		for (int i = 1; i <= num; i++) {
			count = (num % i == 0) ? count + 1 : count;
		}

		return count;
	}

	public int solution(int left, int right) {
		int answer = 0;

		for (int i = left; i <= right; i++) {
			answer = (getDivisorCount(i) % 2 == 0) ? answer + i : answer - i;
		}

		return answer;
	}

	public static void main(String[] args) {
		System.out.println(new DivisorAddition().solution(13, 17));
		System.out.println(new DivisorAddition().solution(24, 27));
	}

}
