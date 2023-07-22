package me.jeongseok.cote;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class _9461_ {


	public static void main(String[] args) throws IOException {

		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int T = Integer.parseInt(br.readLine());

		long[] dp = new long[101];

		dp[1] = 1;
		dp[2] = 1;

		for (int i = 3; i <= 100; i++) {
			dp[i] = dp[i - 2] + dp[i - 3];
			System.out.println(i + " : " + dp[i]);
		}


		while (T-- > 0) {
			int N = Integer.parseInt(br.readLine());

			System.out.println(dp[N]);
		}

	}

}
