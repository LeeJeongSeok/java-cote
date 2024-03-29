package me.jeongseok.cote.math;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;

public class BOJ_11653_2 {
	private static final boolean[] prime = new boolean[10_000_001];

	static {
		Arrays.fill(prime, true);
		prime[0] = false;
		prime[1] = false;

		for (int i = 2; i < 10_000_001; i++) {
			if (prime[i]) {
				for (int j = i + i; j < 10_000_001; j += i) {
					prime[j] = false;
				}
			}
		}
	}

	public static void main(String[] args) throws IOException {
		long startTime = System.currentTimeMillis(); // 코드 시작 시간

		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();

		int num = Integer.parseInt(br.readLine());



		while (num > 1) {
			if (prime[num]) {
				sb.append(num).append("\n");
				break;
			}

			for (int j = 2; j <= num / 2; j++) {
				if (prime[j] && num % j == 0) {
					sb.append(j).append("\n");
					num /= j;
					break;
				}
			}
		}

		System.out.println(sb);
		br.close();

		long endTime = System.currentTimeMillis(); // 코드 끝난 시간

		System.out.println(endTime - startTime + " m/s"); // 밀리세컨드 출력

	}






}
