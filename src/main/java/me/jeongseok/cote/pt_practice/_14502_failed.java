package me.jeongseok.cote.pt_practice;

/**
 * 벽을 어떻게 세우느냐
 * 벽을 세울 수 있는 조건은 빈 칸일때만 가능
 * 벽을 어떻게 세울 것인가?
 * 전체 로직은 1. 벽을 먼저 세우고 2. 바이러스를 퍼트리고 3. 안전영역의 수를 카운팅한다.
 *
 * 1번 벽을 세우는 과정에서 막혔음 나머지 2,3 과정은 충분히 구현할 수 있었음
 * 하지만 결과는 다름..이유를 잘 모르겠다..
 */

import java.io.*;
import java.util.*;
public class _14502_failed {
	static int N, M, result;
	static int dx[];
	static int dy[];
	static int map[][];
	static int virusMap[][];
	static boolean visited[][];
	static Queue<Pair> queue = new LinkedList<>();

	public static void main(String[] args) throws Exception{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());

		N = Integer.parseInt(st.nextToken());
		M = Integer.parseInt(st.nextToken());

		dx = new int[]{1, 0, -1, 0};
		dy = new int[]{0, 1, 0, -1};
		map = new int[N][M];
		visited = new boolean[N][M];
		virusMap = new int[N][M];

		for (int i = 0; i < N; i++) {
			st = new StringTokenizer(br.readLine());
			for (int j = 0; j < M; j++) {
				int value = Integer.parseInt(st.nextToken());
				map[i][j] = virusMap[i][j] = value;

				// 미리 바이러스의 좌표값을 저장한다.
				if (value == 2) {
					queue.add(new Pair(i, j));
					visited[i][j] = true;
				}
			}
		}

		createWall(1);
		countSafeArea();
		System.out.println(result);
	}

	// 1. 벽을 세운다. (완탐 생각하지 못했음)
	private static void createWall(int wall) {
		if (wall == 3) {
			spreadVirus();
			return;
		} else {
			for (int i = 0; i < N; i++) {
				for (int j = 0; j < M; j++) {
					if (map[i][j] == 0) {
						map[i][j] = 1;
						createWall(wall + 1);
						map[i][j] = 0;
					}
				}
			}
		}
	}

	// 2. 바이러스를 뿌린다.
	private static void spreadVirus() {
		while (!queue.isEmpty()) {
			Pair cur = queue.poll();

			for (int i = 0; i < 4; i++) {
				int nx = cur.x + dx[i];
				int ny = cur.y + dy[i];

				if (nx < 0 || nx >= N || ny < 0 || ny >= M) {
					continue;
				}

				if (visited[nx][ny] || virusMap[nx][ny] == 1) {
					continue;
				}

				queue.add(new Pair(nx, ny));
				visited[nx][ny] = true;
			}
		}
	}

	// 3. 안전영역을 세운다.
	private static void countSafeArea() {
		int count = 0;

		for (int i = 0; i < N; i++) {
			for (int j = 0; j < M; j++) {
				if (virusMap[i][j] == 0) {
					count++;
				}
			}
		}

		result = Math.max(result, count);
	}
}
