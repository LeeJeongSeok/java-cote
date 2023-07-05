package me.jeongseok.cote.pt;

/**
 * 7
 * 0110100
 * 0110101
 * 1110101
 * 0000111
 * 0100000
 * 0111110
 * 0111000
 */

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Collections;
import java.util.LinkedList;
import java.util.PriorityQueue;
import java.util.Queue;

public class _2667_ {

	static int N, danji, home;
	static int dx[];
	static int dy[];
	static int map[][];
	static int dist[][];
	static boolean visied[][];
	static PriorityQueue<Integer> pq = new PriorityQueue<>();

	public static void main(String[] args) throws Exception{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

		N = Integer.parseInt(br.readLine());

		dx = new int[]{-1, 0, 1, 0};
		dy = new int[]{0, 1, 0, -1};
		map = new int[N][N];
		dist = new int[N][N];
		visied = new boolean[N][N];
		danji = 0;

		// 1. map 초기화
		for (int i = 0; i < N; i++) {
			String[] split = br.readLine().split("");
			for (int j = 0; j < split.length; j++) {
				map[i][j] = Integer.parseInt(split[j]);
			}
		}

		// 2. BFS가 시작될 수 있는 위치 찾기
		for (int i = 0; i < N; i++) {
			for (int j = 0; j < N; j++) {
				if (!visied[i][j] && map[i][j] == 1) {
					danji++;
					// 3. bfs 탐색
					bfs(i, j);
				}
			}
		}

		System.out.println(pq.size());
		while (!pq.isEmpty()) {
			System.out.println(pq.poll());
		}
	}

	private static void bfs(int x, int y) {
		Queue<Pair> queue = new LinkedList<>();
		queue.add(new Pair(x, y));
		visied[x][y] = true;
		home = 1;

		while (!queue.isEmpty()) {
			Pair cur = queue.poll();

			for (int i = 0; i < 4; i++) {
				int nx = cur.x + dx[i];
				int ny = cur.y + dy[i];

				if (nx < 0 || nx >= N || ny < 0 || ny >= N) {
					continue;
				}

				if (visied[nx][ny] || map[nx][ny] == 0) {
					continue;
				}

				queue.add(new Pair(nx, ny));
				visied[nx][ny] = true;
				dist[nx][ny] = danji;
				home++;
			}
		}

		pq.add(home);
	}
}
