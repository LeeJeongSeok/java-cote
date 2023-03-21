package me.jeongseok.cote.math;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

/**
 * 6 = 1 + 2 + 3
 * 12 is NOT perfect.
 * 28 = 1 + 2 + 4 + 7 + 14
 */
public class BOJ_9506 {

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();

		while (true) {
			int n = Integer.parseInt(br.readLine());
			int sum = 0;

			if (n == -1) {
				System.out.println(sb.toString());
				break;
			}

			// 약수 구하기
			int count = 0;
			for (int i = 1; i < n; i++) {
				if (n % i == 0) {
					count++;
					sum += i;
				}
			}

			// 구한 약수들을 더하기
			int answer = 0;
			if (sum == n) {
				sb.append(sum).append(" = ");
				for (int i = 1; i < n; i++) {
					if (n % i == 0) {
						answer++;
						if (answer < count) {
							sb.append(i).append(" + ");
						}
						if (answer == count) {
							sb.append(i);
						}
					}
				}
				sb.append("\n");
			} else {
				sb.append(n + " is NOT perfect.").append("\n");
			}
		}
	}
}
