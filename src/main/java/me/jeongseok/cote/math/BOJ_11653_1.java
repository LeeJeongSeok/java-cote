package me.jeongseok.cote.math;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;

public class BOJ_11653_1 {
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
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();

		int num = Integer.parseInt(br.readLine());
		int idx = 2;
		while (num > 1) {
			if (prime[num]) {
				sb.append(num).append("\n");
				break;
			}

			if (prime[idx] && num % idx == 0) {
				sb.append(idx).append("\n");
				num /= idx;
			} else {
				idx++;
			}
		}

		System.out.print(sb);
		br.close();
	}

}
