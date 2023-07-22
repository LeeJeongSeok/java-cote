package me.jeongseok.cote.bfs_2;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

class Pair {
	int x;
	int y;

	public Pair(int x, int y) {
		this.x = x;
		this.y = y;
	}
}

public class BOJ_1926 {

	static int[][] picture;
	static boolean[][] visited;


	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());

		// init
		int N = Integer.parseInt(st.nextToken());
		int M = Integer.parseInt(st.nextToken());

		int[] dx = new int[]{-1, 0, 1, 0};
		int[] dy = new int[]{0, 1, 0, -1};

		int totalCount = 0;
		int maxArea = -1;

		picture = new int[N][M];
		visited = new boolean[N][M];

		for (int i = 0; i < N; i++) {
			st = new StringTokenizer(br.readLine());
			for (int j = 0; j < M; j++) {
				picture[i][j] = Integer.parseInt(st.nextToken());
			}
		}



		// start
		// 먼저 그림인지 아닌지 판별
		for (int i = 0; i < N; i++) {
			for (int j = 0; j < M; j++) {

				if (picture[i][j] == 0 || visited[i][j]) {
					continue;
				}

				Queue<Pair> queue = new LinkedList<>();
				queue.offer(new Pair(i, j));
				visited[i][j] = true;
				int area = 0;
				totalCount++;


				while (!queue.isEmpty()) {
					Pair cur = queue.poll();
					area++;

					for (int k = 0; k < 4; k++) {
						int nx = cur.x + dx[k];
						int ny = cur.y + dy[k];

						if (nx < 0 || nx >= N || ny < 0 || ny >= M) {
							continue;
						}

						if (visited[nx][ny] || picture[nx][ny] != 1) {
							continue;
						}

						visited[nx][ny] = true;
						queue.offer(new Pair(nx, ny));
					}
				}

				if (area > maxArea) {
					maxArea = area;
				}
			}
		}

		System.out.println(totalCount);
		System.out.println(maxArea);
	}

}
