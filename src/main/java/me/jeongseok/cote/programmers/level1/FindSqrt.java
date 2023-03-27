package me.jeongseok.cote.programmers.level1;

/**
 * 프로그래머스 - 레벨1 - 정수 제곱근 판별
 * 50000000000000
 */
public class FindSqrt {

	public long solution(long n) {
		long answer = -1;

		for (long i = 1; i * i<= n ; i++) {
			if (i * i == n) {
				answer = (i + 1) * (i + 1);
			}
		}

		return answer;
	}

	public static void main(String[] args) {
		FindSqrt findSqrt = new FindSqrt();
		System.out.println(findSqrt.solution(121));

		System.out.println(Math.sqrt(11));
	}

}
