package me.jeongseok.cote.dp;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class BOJ_1003 {

	static int[][] dp = new int[41][2];

	public static void main(String[] args) throws IOException {

		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

		for (int i = 0; i < 41; i++) {
			for (int j = 0; j < 2; j++) {
				dp[i][j] = -1;
			}
		}

		// 앞 인덱스가 n임
		// 뒤 인덱스가 0을 호출한 경우와 1를 호출한 경우를 판별
		dp[0][0] = 1;
		dp[0][1] = 0;
		dp[1][0] = 0;
		dp[1][1] = 1;

		int t = Integer.parseInt(br.readLine());

		for (int i = 0; i < t; i++) {
			int n = Integer.parseInt(br.readLine());
			fibo(n);
			System.out.println(dp[n][0] + " " + dp[n][1]);
		}

	}

	public static int[] fibo(int n) {
		if (dp[n][0] == -1 || dp[n][1] == -1) { // n에 대해 탐색 X

			dp[n][0] = fibo(n-1)[0] + fibo(n-2)[0];
			dp[n][1] = fibo(n-1)[1] + fibo(n-2)[1];

		}
		return dp[n];
	}

}
