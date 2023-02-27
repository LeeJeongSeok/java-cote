package me.jeongseok.cote.dp;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class BOJ_9461 {

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();

		long[] dp = new long[101];

		dp[1] = 1;
		dp[2] = 1;
		dp[3] = 1;

		for (int i = 4; i < 101; i++) {
			dp[i] = dp[i - 2] + dp[i - 3];
		}

		int t = Integer.parseInt(br.readLine());

		while (t-- > 0) {
			int n = Integer.parseInt(br.readLine());
			sb.append(dp[n]).append("\n");
		}

		System.out.print(sb.toString());

	}
}
