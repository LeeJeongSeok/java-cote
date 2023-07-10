package me.jeongseok.cote.pt;

import java.io.*;
import java.util.*;

public class _1987_ {

	static int R, C, temp;
	static int dx[];
	static int dy[];
	static String map[][];
	static boolean visited[][];
	static Set<String> set = new HashSet<>();

	public static void main(String[] args) throws Exception{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());

		R = Integer.parseInt(st.nextToken());
		C = Integer.parseInt(st.nextToken());

		dx = new int[]{1, 0, -1, 0};
		dy = new int[]{0, 1, 0, -1};
		map = new String[R][C];
		visited = new boolean[R][C];

		for (int i = 0; i < R; i++) {
			String[] split = br.readLine().split("");
			for (int j = 0; j < split.length; j++) {
				map[i][j] = split[j];
			}
		}

	}

	private static void dfs(int x, int y, int count) {
		visited[x][y] = true;

		for (int i = 0; i < 4; i++) {
			int nx = x + dx[i];
			int ny = y + dy[i];

			if (nx < 0 || nx >= R || ny < 0 || ny >= C) {
				continue;
			}

			if (visited[nx][ny] || set.contains(map[nx][ny])) {
				continue;
			}

			set.add(map[nx][ny]);
			dfs(nx, ny, count + 1);
			temp = Math.max(count, temp);
		}
	}
}
