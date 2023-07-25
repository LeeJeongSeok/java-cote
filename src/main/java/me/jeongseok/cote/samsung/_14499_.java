package me.jeongseok.cote.samsung;

/**
 * 4 2 0 0 8
 * 0 2
 * 3 4
 * 5 6
 * 7 8
 * 4 4 4 1 3 3 3 2
 */

import java.io.*;
import java.util.*;

public class _14499_ {

	static int N, M, x, y, K;
	static int map[][];
	static int dx[] = {0, 0, -1, 1};
	static int dy[] = {1, -1, 0, 0};
	static int dice[] = {0, 0, 0, 0, 0, 0};

	public static void main(String[] args) throws Exception{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());

		N = Integer.parseInt(st.nextToken());
		M = Integer.parseInt(st.nextToken());
		x = Integer.parseInt(st.nextToken());
		y = Integer.parseInt(st.nextToken());
		K = Integer.parseInt(st.nextToken());

		map = new int[N][M];

		for (int i = 0; i < N; i++) {
			st = new StringTokenizer(br.readLine());
			for (int j = 0; j < M; j++) {
				map[i][j] = Integer.parseInt(st.nextToken());
			}
		}

		// 명령어의 갯수 만큼 반복
		st = new StringTokenizer(br.readLine());
		for (int i = 0; i < K; i++) {
			int command = Integer.parseInt(st.nextToken());

			int nx = x + dx[command - 1];
			int ny = y + dy[command - 1];

			if (nx < 0 || nx >= N || ny < 0 || ny >= M) {
				continue;
			}

			x = nx;
			y = ny;

			switch (command - 1) {
				case 0:
					moveEast();
					break;
				case 1:
					moveWest();
					break;
				case 2:
					moveNorth();
					break;
				case 3:
					moveSouth();
					break;
			}

			if (map[x][y] == 0) {
				map[x][y] = dice[1];
			} else {
				dice[1] = map[x][y];
				map[x][y] = 0;
			}

			System.out.println(dice[0]);
		}
	}

	private static void moveEast() {
		int temp = dice[0];
		dice[0] = dice[4];
		dice[4] = dice[1];
		dice[1] = dice[5];
		dice[5] = temp;

	}

	private static void moveWest() {
		int temp = dice[0];
		dice[0] = dice[5];
		dice[5] = dice[1];
		dice[1] = dice[4];
		dice[4] = temp;
	}

	private static void moveNorth() {
		int temp = dice[0];
		dice[0] = dice[2];
		dice[2] = dice[1];
		dice[1] = dice[3];
		dice[3] = temp;
	}

	private static void moveSouth() {
		int temp = dice[0];
		dice[0] = dice[3];
		dice[3] = dice[1];
		dice[1] = dice[2];
		dice[2] = temp;
	}

}
