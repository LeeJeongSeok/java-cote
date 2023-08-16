package me.jeongseok.cote.pt_practice;

import java.io.*;

public class _11727_ {

	static int N;
	static int[] dp = new int[1001];

	public static void main(String[] args) throws Exception{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		N = Integer.parseInt(br.readLine());

		// 길이가 n일때 몇 개의 타일이 들어가냐를 설정함
		dp[1] = 1;
		dp[2] = 3; // 2 * 1 타일 2개 + 2 * 2 타일 1개 = 총 타일 3개

		for (int i = 3; i < 1001; i++) {
			dp[i] = (dp[i - 1] + 2 * dp[i - 2]) % 10007;
		}

		System.out.println(dp[N]);
	}

}
