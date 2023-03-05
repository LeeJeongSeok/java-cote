package me.jeongseok.cote.dp;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class BOJ_9465 {

	static int[][] dp;
	static int[][] cost;

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

		int t = Integer.parseInt(br.readLine());

		for (int i = 0; i < t; i++) {
			int n = Integer.parseInt(br.readLine());

			dp = new int[2][n + 1];
			cost = new int[2][n + 1];

			for (int j = 0; j < 2; j++) {
				StringTokenizer st = new StringTokenizer(br.readLine());
				for (int k = 1; k <= n; k++) {
					cost[j][k] = Integer.parseInt(st.nextToken());
				}
			}

			dp[0][1] = cost[0][1];
			dp[1][1] = cost[1][1];

			for (int j = 2; j <= n; j++) {
				dp[0][j] = Math.max(dp[1][j-1], dp[1][j-2])+cost[0][j];
				dp[1][j] = Math.max(dp[0][j-1], dp[0][j-2])+cost[1][j];
			}

			System.out.println(Math.max(dp[0][n], dp[1][n]));
		}
	}

}
