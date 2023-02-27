package me.jeongseok.cote.back_traking;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class BOJ_15649 {

	static int n, m;
	static int[] arr;
	static boolean[] visited;

	public static void bt(int k) {
		if (k == m) {
			for (int i = 0; i < m; i++) {
				System.out.print(arr[i] + " ");
			}
			System.out.println();
			return;
		}

		for (int i = 1; i <= n; i++) {
			if (visited[i] == false) {
				arr[k] = i;
				visited[i] = true;
				bt(k + 1);
				visited[i] = false;
			}
		}
	}
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		String[] split = br.readLine().split(" ");

		n = Integer.parseInt(split[0]);
		m = Integer.parseInt(split[1]);

		arr = new int[10];
		visited = new boolean[10];

		bt(0);
	}
}
