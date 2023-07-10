package me.jeongseok.cote.pt;

import java.io.*;
import java.util.*;
public class _2468_ {

	static int N, result, count;
	static int dx[];
	static int dy[];
	static int map[][];
	static int dist[][];
	static boolean visited[][];

	public static void main(String[] args) throws Exception{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

		N = Integer.parseInt(br.readLine());

		dx = new int[]{1, 0, -1, 0};
		dy = new int[]{0, 1, 0, -1};
		map = new int[N][N];
		dist = new int[N][N];
		result = -1;

		for (int i = 0; i < N; i++) {
			StringTokenizer st = new StringTokenizer(br.readLine());
			for (int j = 0; j < N; j++) {
				map[i][j] = Integer.parseInt(st.nextToken());
			}
		}

		// 1~100 높이를 설정하면서 안전지대의 최대값을 찾는다.
		for (int i = 0; i <= 100; i++) {
			count = 0;
			visited = new boolean[N][N];

			// 높이 i이하인 지역은 dist배열에서 1로 변경
			for (int j = 0; j < N; j++) {
				for (int k = 0; k < N; k++) {
					if (map[j][k] <= i) {
						dist[j][k] = 1;
					}
				}
			}

			// 그래프 탐색이 가능한 곳을 찾는다.
			for (int j = 0; j < N; j++) {
				for (int k = 0; k < N; k++) {
					if (dist[j][k] == 0 && !visited[j][k]) {
						count++;
						dfs(j, k);
					}
				}
			}
			result = Math.max(result, count);
		}

		System.out.println((result == 1) ? 1 : result);
	}

	private static void dfs(int x, int y) {
		visited[x][y] = true;

		for (int i = 0; i < 4; i++) {
			int nx = x + dx[i];
			int ny = y + dy[i];

			if (nx < 0 || nx >= N || ny < 0 || ny >= N) {
				continue;
			}

			if (visited[nx][ny] || dist[nx][ny] == 1) {
				continue;
			}

			dfs(nx, ny);
		}
	}

}
