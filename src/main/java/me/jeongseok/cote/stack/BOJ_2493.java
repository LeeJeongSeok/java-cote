package me.jeongseok.cote.stack;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

/**
 * 5
 * 6 9 5 7 4
 */

public class BOJ_2493 {

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();
		int N = Integer.parseInt(br.readLine());
		int[] send = new int[N + 1];
		int[] receive = new int[N + 1];

		StringTokenizer st = new StringTokenizer(br.readLine());

		for (int i = 1; i <= N; i++) {
			int value = Integer.parseInt(st.nextToken());
			send[i] = value;
			receive[i] = value;
		}

		sb.append("0").append(" ");
		for (int i = 2; i <= N; i++) {
			boolean flag = false;
			for (int j = i - 1; j >= 1; j--) {
				if (receive[j] > send[i]) {
					sb.append(j).append(" ");
					flag = true;
					break;
				}
			}

			if (!flag) {
				sb.append("0").append(" ");
			}
		}

		System.out.println(sb);
	}

}
