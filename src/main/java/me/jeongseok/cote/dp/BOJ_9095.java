package me.jeongseok.cote.dp;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class BOJ_9095 {

	public static void main(String[] args) throws IOException {

		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

		int[] dp = new int[11];

		dp[1] = 1;
		dp[2] = 2;
		dp[3] = 4;
		dp[4] = 7;

		for (int i = 5; i < dp.length; i++) {
			dp[i] = dp[i-1] + dp[i-2] + dp[i-3];
		}

		int t = Integer.parseInt(br.readLine());

		for (int i = 0; i < t; i++) {
			int n = Integer.parseInt(br.readLine());
			System.out.println(dp[n]);
		}
	}

}
