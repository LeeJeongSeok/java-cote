package me.jeongseok.cote.dp;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class BOJ_2839 {

	public static void main(String[] args) throws IOException {

		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

		int n = Integer.parseInt(br.readLine());
		int count = 0;

		while (true) {
			if (n < 0) {
				System.out.println(-1);
				break;
			}

			if (n % 5 == 0) {
				System.out.println(n / 5 + count);
				break;
			}

			n = n - 3;
			count++;
		}
	}

}
