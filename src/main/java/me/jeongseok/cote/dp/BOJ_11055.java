package me.jeongseok.cote.dp;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class BOJ_11055 {

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

		int t = Integer.parseInt(br.readLine());

		int[] input = new int[t + 1];
		int[] dp = new int[t + 1];

		StringTokenizer st = new StringTokenizer(br.readLine()," ");

		for(int i = 1; i <= t; i++) {
			input[i] = Integer.parseInt(st.nextToken());
		}

		dp[1] = input[1];

		for(int i = 2; i <= t; i++) {
			dp[i] = input[i];
			for(int j = 1; j < i; j++) {
				if(input[j] < input[i]) {
					dp[i] = Math.max(dp[j] + input[i], dp[i]);
				}
			}
		}


		int max = -1;
		for(int i = 0; i < t; i++) {
			if (dp[i] > max) {
				max = dp[i];
			}
		}
		System.out.println(max);
	}

}
