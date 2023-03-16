package me.jeongseok.cote.recursion;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class BOJ_11729 {

	static StringBuilder sb = new StringBuilder();

	static void rec_func(int count, int from, int by, int to) {
		if (count == 1) {
			sb.append(from).append(" ").append(to).append("\n");
		} else {
			rec_func(count - 1, from, to, by);
			sb.append(from).append(" ").append(to).append("\n");
			rec_func(count - 1, by, from, to);
		}

	}

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int n = Integer.parseInt(br.readLine());

		sb.append((int) (Math.pow(2, n) - 1)).append('\n');

		rec_func(n, 1, 2, 3);

		System.out.println(sb.toString());

	}

}
