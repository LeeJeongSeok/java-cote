package me.jeongseok.cote.dp;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class BOJ_11057 {

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

		int N = Integer.parseInt(br.readLine());

		long[][] dp = new long[N + 1][10];

		for(int i = 0; i <= 9; i++) {
			dp[1][i] = 1;
		}

		// 두 번째 자릿수부터 N까지 탐색
		for(int i = 2; i <= N; i++) {
			// i번째 자릿수의 자릿값들을 탐색 (0~9)
			for(int j = 0; j < 10; j++) {
				for (int k = 0; k <= j; k++) {
					dp[i][j] += dp[i - 1][k];
					dp[i][j] %= 10007;
				}
			}
		}

		long result = 0;

		// 각 자릿값마다의 경우의 수를 모두 더해준다.
		for(int i = 0; i < 10; i++) {
			result += dp[N][i];
		}

		System.out.println(result);
	}

}
