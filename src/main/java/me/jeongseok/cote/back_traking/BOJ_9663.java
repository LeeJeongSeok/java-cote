package me.jeongseok.cote.back_traking;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class BOJ_9663 {

	static int count = 0;
	static int n;
	static boolean[] visited1 = new boolean[40];
	static boolean[] visited2 = new boolean[40];
	static boolean[] visited3 = new boolean[40];

	public static void chess(int current) {
		if (current == n) {
			count++;
			return;
		}

		for (int i = 0; i < n; i++) {
			if (visited1[i] || visited2[i + current] || visited3[current - i + n - 1]) {
				continue;
			}

			visited1[i] = true;
			visited2[i + current] = true;
			visited3[current - i + n - 1] = true;
			chess(current + 1);
			visited1[i] = false;
			visited2[i + current] = false;
			visited3[current - i + n -1] = false;
		}
	}

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

		n = Integer.parseInt(br.readLine());

		chess(0);
		System.out.println(count);
	}

}
