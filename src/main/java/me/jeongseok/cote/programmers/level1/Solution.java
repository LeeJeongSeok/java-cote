package me.jeongseok.cote.programmers.level1;

/**
 * 프로그래머스 레벨 1 - 약수의 합
 */
public class Solution {

	static int solution(int n) {
		int sum = 0;

		for (int i = 1; i <= n; i++) {
			if (n % i == 0) {
				sum += i;
			}
		}

		return sum;
	}

	public static void main(String[] args) {
		System.out.println(solution(12));
		System.out.println(solution(5));
	}
}
