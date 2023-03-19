package me.jeongseok.cote.string;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

/**
 * 3
 * ACDKJFOWIEGHE
 * O
 * AB
 */
public class BOJ_9086 {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();
		int T = Integer.parseInt(br.readLine());

		for (int i = 0; i < T; i++) {
			String input = br.readLine();
			if (input.length() == 1) {
				sb.append(input).append(input).append("\n");
			} else {
				sb.append(input.charAt(0)).append(input.charAt(input.length() - 1)).append("\n");
			}
		}

		System.out.println(sb.toString());
	}
}
