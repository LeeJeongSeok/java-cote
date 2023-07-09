package me.jeongseok.cote.pt_practice;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class _4963_ {

	static int w, h, count;
	static int dx[];
	static int dy[];
	static int map[][];
	static boolean visited[][];
	static StringBuilder sb = new StringBuilder();


	public static void main(String[] args) throws Exception{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

		while (true) {
			// 압력 시작
			StringTokenizer st = new StringTokenizer(br.readLine());

			w = Integer.parseInt(st.nextToken());
			h = Integer.parseInt(st.nextToken());

			if (w == 0 && h == 0) {
				System.out.println(sb);
				return;
			}

			map = new int[h][w];
			visited = new boolean[h][w];
			dx = new int[]{-1, -1, 0, 1, 1, 1, 0, -1};
			dy = new int[]{0, 1, 1, 1, 0, -1, -1, -1};
			count = 0;

			for (int i = 0; i < h; i++) {
				st = new StringTokenizer(br.readLine());
				for (int j = 0; j < w; j++) {
					map[i][j] = Integer.parseInt(st.nextToken());
				}
			}
			// 입력 종료

			// 2중 for문으로 탐색하면서 그래프 탐색이 가능한 곳을 찾는다.
			for (int i = 0; i < h; i++) {
				for (int j = 0; j < w; j++) {
					if (map[i][j] == 1 && !visited[i][j]) {
						count++;
						dfs(i, j);
					}
				}
			}
			sb.append(count).append("\n");
		}
	}

	private static void dfs(int x, int y) {
		visited[x][y] = true;

		for (int i = 0; i < 8; i++) {
			int nx = x + dx[i];
			int ny = y + dy[i];

			if (nx < 0 || nx >= h || ny < 0 || ny >= w) {
				continue;
			}

			if (map[nx][ny] == 0 || visited[nx][ny]) {
				continue;
			}

			dfs(nx, ny);
		}
	}
}
