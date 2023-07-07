package me.jeongseok.cote.pt_practice;

import java.io.*;
import java.util.*;
public class _10026_ {

	static int N, redGreenBlueCount, redGreenColorWeakCount;
	static int dx[];
	static int dy[];
	static String color[];
	static String color2[];
	static String picture[][];
	static String picture2[][];
	static boolean visited[][];


	public static void main(String[] args) throws Exception{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

		N = Integer.parseInt(br.readLine());
		dx = new int[]{1, 0, -1, 0};
		dy = new int[]{0, 1, 0, -1};
		color = new String[]{"R", "G", "B"};
		color2 = new String[]{"T", "B"};
		picture = new String[N][N];
		picture2 = new String[N][N];
		visited = new boolean[N][N];

		for (int i = 0; i < N; i++) {
			String[] split = br.readLine().split("");
			for (int j = 0; j < split.length; j++) {
				picture[i][j] = split[j];
				picture2[i][j] = split[j];

				if (split[j].equals("R") || split[j].equals("G")) {
					picture2[i][j] = "T";
				}
			}
		}

		for (int i = 0; i < color.length; i++) {
			for (int j = 0; j < N; j++) {
				for (int k = 0; k < N; k++) {
					if (picture[j][k].equals(color[i]) && !visited[j][k]) {
						redGreenBlueCount++;
						bfs(picture, color[i], j, k);
					}
				}
			}
		}

		System.out.println(redGreenBlueCount);
		visited = new boolean[N][N];

		for (int i = 0; i < color2.length; i++) {
			for (int j = 0; j < N; j++) {
				for (int k = 0; k < N; k++) {
					if (picture2[j][k].equals(color2[i]) && !visited[j][k]) {
						redGreenColorWeakCount++;
						bfs(picture2, color2[i], j, k);
					}
				}
			}
		}

		System.out.println(redGreenColorWeakCount);


	}

	private static void bfs(String[][] picture, String color, int x, int y) {
		Queue<Pair> queue = new LinkedList<>();
		queue.add(new Pair(x, y));
		visited[x][y] = true;


		while (!queue.isEmpty()) {
			Pair cur = queue.poll();

			for (int i = 0; i < 4; i++) {
				int nx = cur.x + dx[i];
				int ny = cur.y + dy[i];

				if (nx < 0 || nx >= N || ny < 0 || ny >= N) {
					continue;
				}

				if (visited[nx][ny] || !Objects.equals(picture[nx][ny], color)) {
					continue;
				}

				queue.add(new Pair(nx, ny));
				visited[nx][ny] = true;
			}
		}
	}
}
