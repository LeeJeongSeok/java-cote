package me.jeongseok.cote.bfs_2;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class BOJ_7576 {

	static int[][] tomato, day;

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine(), " ");

		int M = Integer.parseInt(st.nextToken());
		int N = Integer.parseInt(st.nextToken());

		int[] dx = new int[]{-1, 0, 1, 0};
		int[] dy = new int[]{0, 1, 0, -1};

		tomato = new int[N][M];
		day = new int[N][M];
		Queue<Pair> queue = new LinkedList<>();

		// init
		for (int i = 0; i < N; i++) {
			st = new StringTokenizer(br.readLine(), " ");
			for (int j = 0; j < M; j++) {
				tomato[i][j] = Integer.parseInt(st.nextToken());
			}
		}


		// start
		for (int i = 0; i < N; i++) {
			for (int j = 0; j < M; j++) {
				if (tomato[i][j] == 1) {
					queue.offer(new Pair(i, j));
				}

				if (tomato[i][j] == 0) {
					day[i][j] = -1;
				}
			}
		}

		while (!queue.isEmpty()) {
			Pair cur = queue.poll();

			for (int i = 0; i < 4; i++) {
				int nx = cur.x + dx[i];
				int ny = cur.y + dy[i];

				if (nx < 0 || nx >= N || ny < 0 || ny == M) {
					continue;
				}

				// 0과 같은 경우는 비어있는 칸 0보다 큰 경우는 이미 방문했다는 의미 (요일이 지남)
				if (day[nx][ny] > 0 || day[nx][ny] == 0) {
					continue;
				}

				tomato[nx][ny] = 1;
				day[nx][ny] = day[cur.x][cur.y] + 1;
				queue.offer(new Pair(nx, ny));
			}
		}

		int max = 0;

		for (int i = 0; i < N; i++) {
			for (int j = 0; j < M; j++) {
				if (day[i][j] == -1) {
					System.out.println(-1);
					return;
				}

				max = Math.max(max, day[i][j]);
			}
		}

		System.out.println(max);
	}

}
