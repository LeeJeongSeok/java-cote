package me.jeongseok.cote.dp;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class _14501_ {

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

		int N = Integer.parseInt(br.readLine());

		int[] T = new int[N + 2];
		int[] P = new int[N + 2];

		// T[i]일 까지 일한 급여를 저장하는 배열
		int[] dp = new int[N + 2];

		for (int i = 1; i <= N; i++) {
			StringTokenizer st = new StringTokenizer(br.readLine());
			T[i] = Integer.parseInt(st.nextToken());
			P[i] = Integer.parseInt(st.nextToken());
		}

		int currentMoney = 0;

		for (int i = 1; i < N + 2; i++) {
			// 현재 요일까지 내가 번 돈을 체크하는 건가?
			if (dp[i] > currentMoney) {
				currentMoney = dp[i];
			}

			int day = i + T[i];
			if (day < N + 2) {
				dp[day] = Math.max(dp[day], currentMoney + P[i]);
			}
		}

		System.out.println(currentMoney);
	}

}
