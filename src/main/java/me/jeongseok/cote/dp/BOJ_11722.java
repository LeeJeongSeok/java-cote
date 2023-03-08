package me.jeongseok.cote.dp;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class BOJ_11722 {

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

		int t = Integer.parseInt(br.readLine());

		int[] input = new int[t];
		int[] dp = new int[t];

		StringTokenizer st = new StringTokenizer(br.readLine()," ");

		for(int i = 0; i < t; i++) {
			input[i] = Integer.parseInt(st.nextToken());
		}

		for(int i = 0; i < t; i++) {
			dp[i] = 1;
			for(int j = 0; j < i; j++) {
				if(input[j] > input[i]) {
					dp[i] = Math.max(dp[i], dp[j] + 1);
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
