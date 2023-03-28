package me.jeongseok.cote.programmers.level1;

/**
 * 프로그래머스 레벨1 - 하샤드 수
 */
public class HarshadNumber {

	public boolean solution(int x) {


		// 1. 자릿수의 합을 구하는 로직
		int sum = 0;
		int temp = x;

		while (true) {
			// x가 0이면 탈출
			if (temp == 0) {
				break;
			}
			// 그렇지 않으면 자릿수별로 나눈 후 sum에 더함
			sum += temp % 10;
			temp = temp / 10;
		}

		// 2. 자릿수의 합을 기준으로 나눠떨어지는가 판별
		return (x % sum == 0) ? true : false;
	}

	public static void main(String[] args) {
		System.out.println(new HarshadNumber().solution(10)); // true
		System.out.println(new HarshadNumber().solution(12)); // true
		System.out.println(new HarshadNumber().solution(11)); // false
		System.out.println(new HarshadNumber().solution(13)); // false
	}
}
