package me.jeongseok.cote.bfs_2;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class BOJ_2178 {

	static int[][] maze, distance;
	static boolean[][] visited;


	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine(), " ");

		int N = Integer.parseInt(st.nextToken());
		int M = Integer.parseInt(st.nextToken());

		int[] dx = new int[]{-1, 0, 1, 0};
		int[] dy = new int[]{0, 1, 0, -1};

		maze = new int[N][M];
		distance = new int[N][M];
		visited = new boolean[N][M];

		// init
		for (int i = 0; i < N; i++) {
			String[] line = br.readLine().split("");
			for (int j = 0; j < line.length; j++) {
				maze[i][j] = Integer.parseInt(line[j]);
			}
		}


		// start
		Queue<Pair> queue = new LinkedList<>();
		queue.add(new Pair(0, 0));
		visited[0][0] = true;

		while (!queue.isEmpty()) {
			Pair cur = queue.poll();

			for (int i = 0; i < 4; i++) {
				int nx = cur.x + dx[i];
				int ny = cur.y + dy[i];

				if (nx < 0 || nx >= N || ny < 0 || ny >= M) {
					continue;
				}

				if (visited[nx][ny] || maze[nx][ny] == 0) {
					continue;
				}

				visited[nx][ny] = true;
				distance[nx][ny] = distance[cur.x][cur.y] + 1;
				queue.offer(new Pair(nx, ny));
			}

			if (cur.x == N - 1 && cur.y == M - 1) {
				System.out.println(distance[cur.x][cur.y] + 1);
				return;
			}

		}
	}

}
