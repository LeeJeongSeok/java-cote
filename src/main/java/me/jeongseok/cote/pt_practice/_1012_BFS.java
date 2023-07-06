package me.jeongseok.cote.pt_practice;

import java.io.*;
import java.util.*;

public class _1012_BFS {
	static int T, M, N, K, count;
	static int dx[];
	static int dy[];
	static int map[][];
	static boolean visited[][];
	static StringBuilder sb = new StringBuilder();

	public static void main(String[] args) throws Exception{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

		T = Integer.parseInt(br.readLine());

		while (T-- > 0) {
			StringTokenizer st = new StringTokenizer(br.readLine());

			M = Integer.parseInt(st.nextToken());
			N = Integer.parseInt(st.nextToken());
			K = Integer.parseInt(st.nextToken());

			dx = new int[]{1, 0, -1, 0};
			dy = new int[]{0, 1, 0, -1};
			map = new int[N][M];
			visited = new boolean[N][M];
			count = 0;

			for (int i = 0; i < K; i++) {
				st = new StringTokenizer(br.readLine());
				int x = Integer.parseInt(st.nextToken());
				int y = Integer.parseInt(st.nextToken());

				map[y][x] = 1;
			}


			// 전체 탐색하면서 bfs 탐색을 할 수 있는 곳을 찾는다.
			for (int i = 0; i < N; i++) {
				for (int j = 0; j < M; j++) {
					if (map[i][j] == 1 && !visited[i][j]) {
						count++;
						bfs(i, j);
					}
				}
			}

			sb.append(count).append("\n");
		}

		System.out.println(sb);
	}

	private static void bfs(int x, int y) {
		Queue<Pair> queue = new LinkedList<>();
		queue.add(new Pair(x, y));
		visited[x][y] = true;

		while (!queue.isEmpty()) {
			Pair cur = queue.poll();

			for (int i = 0; i < 4; i++) {
				int nx = cur.x + dx[i];
				int ny = cur.y + dy[i];

				if (nx < 0 || nx >= N || ny < 0 || ny >= M) {
					continue;
				}

				if (visited[nx][ny] || map[nx][ny] == 0) {
					continue;
				}

				queue.add(new Pair(nx, ny));
				visited[nx][ny] = true;
			}
		}
	}
}
