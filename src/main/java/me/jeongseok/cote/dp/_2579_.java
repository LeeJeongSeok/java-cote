package me.jeongseok.cote.dp;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class _2579_ {

	public void init(BufferedReader br) throws IOException {

		int N = Integer.parseInt(br.readLine());

		int[] nums = new int[N + 1];
		int[] dp = new int[N + 1];

		for (int i = 1; i <= N; i++) {
			nums[i] = Integer.parseInt(br.readLine());
		}

		printMaxValue(N, nums, dp);
	}

	public void printMaxValue(int N, int[] nums, int[] dp) {
		dp[1] = nums[1];

		// 2보다 작은 수가 넘어올 수 있다.
		if (N >= 2) {
			dp[2] = nums[1] + nums[2];
		}

		for (int i = 3; i <= N; i++) {
			dp[i] = Math.max(dp[i - 2], dp[i - 3] + nums[i - 1]) + nums[i];
		}

		System.out.println(dp[N]);
	}

	public static void main(String[] args) throws IOException {
		new _2579_().init(new BufferedReader(new InputStreamReader(System.in)));
	}

}
