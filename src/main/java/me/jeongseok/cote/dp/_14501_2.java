package me.jeongseok.cote.dp;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class _14501_2 {

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

		int N = Integer.parseInt(br.readLine());

		int[] T = new int[1000];
		int[] P = new int[1000];

		// T[i]일 까지 일한 급여를 저장하는 배열
		int[] dp = new int[1000];

		for (int i = 1; i <= N; i++) {
			StringTokenizer st = new StringTokenizer(br.readLine());
			T[i] = Integer.parseInt(st.nextToken());
			P[i] = Integer.parseInt(st.nextToken());
		}

		for (int i = N; i > 0; i--) {
			int day = i + T[i];

			if (day > N + 1) {
				dp[i] = 0;
			} else {
				// dp[i + 1]는 dp[i]일을 하지 않았을 때 지금까지 일한 금액의 최대치
				// dp[day] + p[i] dp[i]일날 일을 했고, 그 보상을 받는 날에 지금까지 일한 최대치와 현재 일한 날의 최대치를 더함
				dp[i] = Math.max(dp[i + 1], dp[day] + P[i]);
			}
		}

		System.out.println(dp[1]);
	}

}
