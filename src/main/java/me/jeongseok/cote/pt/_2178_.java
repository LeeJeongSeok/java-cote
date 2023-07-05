package me.jeongseok.cote.pt;

/**
 * 4 6
 * 101111
 * 101010
 * 101011
 * 111011
 */

import java.io.*;
import java.util.*;

class Pair {
	int x;
	int y;

	public Pair(int x, int y) {
		this.x = x;
		this.y = y;
	}
}

public class _2178_ {

	static int N, M;
	static int dx[];
	static int dy[];
	static int map[][];
	static boolean visited[][];
	static int dist[][];

	static Queue<Pair> queue = new LinkedList<>();
	public static void main(String[] args) throws Exception{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());

		N = Integer.parseInt(st.nextToken());
		M = Integer.parseInt(st.nextToken());

		map = new int[N][M];
		dist = new int[N][M];
		visited = new boolean[N][M];
		dx = new int[]{-1, 0, 1, 0};
		dy = new int[]{0, 1, 0, -1};

		for (int i = 0; i < N; i++) {
			String[] split = br.readLine().split("");
			for (int j = 0; j < split.length; j++) {
				map[i][j] = Integer.parseInt(split[j]);
			}
		}

		bfs();
		System.out.println(dist[N - 1][M - 1]);
	}

	private static void bfs() {
		queue.add(new Pair(0, 0));
		visited[0][0] = true;
		dist[0][0] = 1;

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
				dist[nx][ny] = dist[cur.x][cur.y] + 1;
			}
		}
	}

}
