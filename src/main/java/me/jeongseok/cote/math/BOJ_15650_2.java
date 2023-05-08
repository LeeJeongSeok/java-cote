package me.jeongseok.cote.math;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

/**
 * n과 m 중복 없이 순서대로 출력 (조합)
 */

public class BOJ_15650_2 {

	static int N, M;
	static int[] selected;
	static boolean[] visited;
	static StringBuilder sb = new StringBuilder();

	private static void rec_func(int depth) {
		if (depth == M + 1) {
			for (int i = 1; i <= M; i++) {
				sb.append(selected[i]).append(" ");
			}
			sb.append("\n");
		} else {
			int start = selected[depth - 1];
			if (start == 0) {
				start = 1;
			}
			for (int i = start; i <= N; i++) {
				if (!visited[i]) {
					visited[i] = true;
					selected[depth] = i;
					rec_func(depth + 1);
					visited[i] = false;
				}
			}
		}
	}

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine(), " ");

		N = Integer.parseInt(st.nextToken());
		M = Integer.parseInt(st.nextToken());

		selected = new int[M + 1];
		visited = new boolean[N + 1];

		rec_func(1);

		System.out.println(sb);
	}

}
