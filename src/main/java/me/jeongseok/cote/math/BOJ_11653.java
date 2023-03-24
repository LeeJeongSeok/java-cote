package me.jeongseok.cote.math;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class BOJ_11653 {

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();
		int N = Integer.parseInt(br.readLine());

		int i = 2;
		while (true) {
			if (N == 1) {
				System.out.println(sb.toString());
				break;
			}

			if (N % i == 0) {
				N = N / i;
				sb.append(i).append("\n");
			} else {
				i++;
			}
		}
	}

}
