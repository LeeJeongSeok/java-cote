package me.jeongseok.cote.samsung;

import java.io.*;
import java.util.*;
public class _14503_ {

	static int N, M;
	static int r, c, d, count;
	static int dx[];
	static int dy[];
	static int map[][];

	public static void main(String[] args) throws Exception{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());

		N = Integer.parseInt(st.nextToken());
		M = Integer.parseInt(st.nextToken());
		map = new int[N][M];
		count = 1;

		// 북, 동, 남 서
		dx = new int[]{-1, 0, 1, 0};
		dy = new int[]{0, 1, 0, -1};

		st = new StringTokenizer(br.readLine());
		r = Integer.parseInt(st.nextToken());
		c = Integer.parseInt(st.nextToken());
		d = Integer.parseInt(st.nextToken());

		for (int i = 0; i < N; i++) {
			st = new StringTokenizer(br.readLine());
			for (int j = 0; j < M; j++) {
				map[i][j] = Integer.parseInt(st.nextToken());
			}
		}

		dfs(r, c, d);
		System.out.println(count);
	}

	private static void dfs(int curR, int curC, int direction) {
		// 1. 현재 위치를 청소한다.
		map[curR][curC] = 2;

		// 2. 현재 위치에서 현재 방향 기준으로, 왼쪽방향부터 차례대로 탐색
		for (int i = 0; i < 4; i++) {
			direction = (direction + 3) % 4;
			int nextR = curR + dx[direction];
			int nextC = curC + dy[direction];

			if (nextR >= 0 && nextR < N && nextC >= 0 && nextC < M && map[nextR][nextC] == 0) {
				// 2-1. 왼쪽 방향에 아직 청소하지 않은 공간이 있는 경우, 그 방향으로 회전 후 한칸 전진
				count++;
				dfs(nextR, nextC, direction);
				return;
			}
		}

		// 3. 네 방향 모두 청소가 되어 있거나, 벽인 경우, 바라보는 방향을 유지한 채 후진
		int backD = (direction + 2) % 4;
		int backR = curR + dx[backD];
		int backC = curC + dy[backD];

		if (backR >= 0 && backR < N && backC >= 0 && backC < M && map[backR][backC] != 1) {
			dfs(backR, backC, direction);
		}
	}
}
