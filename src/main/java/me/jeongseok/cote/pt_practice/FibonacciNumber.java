package me.jeongseok.cote.pt_practice;

public class FibonacciNumber {

	static int dp[] = new int[100_001];

	public int solution(int n) {

		dp[0] = 0;
		dp[1] = 1;
		dp[2] = 1;

		for (int i = 3; i <= 100_000; i++) {

			dp[i] = (dp[i - 1] + dp[i - 2]) % 1234567;
		}

		return dp[n];
	}

	public static void main(String[] args) {
		System.out.println(new FibonacciNumber().solution(3));
		System.out.println(new FibonacciNumber().solution(5));
	}

}
