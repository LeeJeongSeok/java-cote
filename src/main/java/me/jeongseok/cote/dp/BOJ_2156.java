package me.jeongseok.cote.dp;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class BOJ_2156 {

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

		int n = Integer.parseInt(br.readLine());

		int[] dp = new int[n + 1];
		int[] input = new int[n + 1];

		for (int i = 1; i <= n; i++) {
			input[i] = Integer.parseInt(br.readLine());
		}

		dp[1] = input[1];

		if (n > 1) {
			dp[2] = input[1] + input[2];
		}

		for (int i = 3; i <= n; i++) {
			dp[i] = Math.max(dp[i - 1], Math.max(dp[i - 2] + input[i], dp[i - 3] + input[i - 1] + input[i]));
		}

		System.out.println(dp[n]);
	}

}
