package me.jeongseok.cote.programmers.level1;

/**
 * 프로그래머스 - 레벨1 - 소수 만들기
 */
public class GeneratePrimeNumbers {

	public boolean isPrimeNumber(int n) {
		for (int i = 2; i < n; i++) {
			if (n % i == 0) {
				return false;
			}
		}
		return true;
	}

	public int solution(int[] nums) {
		int answer = 0;

		for (int i = 0; i < nums.length; i++) {
			for (int j = i + 1; j < nums.length; j++) {
				for (int k = j + 1; k < nums.length; k++) {
					if (isPrimeNumber(nums[i] + nums[j] + nums[k])) {
						answer++;
					}
				}
			}
		}

		return answer;
	}

	public static void main(String[] args) {

	}
}
