package me.jeongseok.cote.pt_practice;

import java.io.*;
import java.util.*;

public class _14502_ {

	static int N, M, safetyZone;
	static int dx[];
	static int dy[];
	static int virusMap[][];
	static boolean visited[][];

	public static void main(String[] args) throws Exception{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());

		N = Integer.parseInt(st.nextToken());
		M = Integer.parseInt(st.nextToken());
		dx = new int[]{1, 0, -1, 0};
		dy = new int[]{0, 1, 0, -1};

		virusMap = new int[N][M];
		visited = new boolean[N][M];

		for (int i = 0; i < N; i++) {
			st = new StringTokenizer(br.readLine(), " ");
			for (int j = 0; j < M; j++) {
				virusMap[i][j] = Integer.parseInt(st.nextToken());
			}
		} // 입력 끝

		// 벽 세우기
		createWall(0);

		// 결과 출력
		System.out.println(safetyZone);
	}

	private static void createWall(int count) {
		if (count == 3) {
			// 벽을 다 세우면 바이러스를 퍼트린다.
			spreadVirus();
		} else {
			for (int i = 0; i < N; i++) {
				for (int j = 0; j < M; j++) {
					if (virusMap[i][j] == 0) {
						virusMap[i][j] = 1;
						createWall(count + 1);
						virusMap[i][j] = 0;
					}
				}
			}
		}
	}

	private static void spreadVirus() {
		// 매번 탐색해줄때마다 방문 배열을 초기화 시켜야한다.
		visited = new boolean[N][M];

		// 배열 복사
		int[][] copyMap = new int[N][M];

		for (int i = 0; i < N; i++) {
			for (int j = 0; j < M; j++) {
				copyMap[i][j] = virusMap[i][j];
			}
		}

		// 바이러스 위치 저장
		Queue<Pair> queue = new LinkedList<>();

		for (int i = 0; i < N; i++) {
			for (int j = 0; j < M; j++) {
				if (copyMap[i][j] == 2) {
					queue.add(new Pair(i, j));
					visited[i][j] = true;
				}
			}
		}

		// 바이러스를 퍼트린다.
		while (!queue.isEmpty()) {
			Pair cur = queue.poll();

			for (int i = 0; i < 4; i++) {
				int nx = cur.x + dx[i];
				int ny = cur.y + dy[i];

				if (nx < 0 || nx >= N || ny < 0 || ny >= M) {
					continue;
				}

				if (visited[nx][ny] || copyMap[nx][ny] == 1) {
					continue;
				}

				queue.add(new Pair(nx, ny));
				visited[nx][ny] = true;
				copyMap[nx][ny] = 2;
			}
		}

		countSafetyZone(copyMap);
	}

	private static void countSafetyZone(int[][] copyMap) {
		int count = 0;

		for (int i = 0; i < N; i++) {
			for (int j = 0; j < M; j++) {
				if (copyMap[i][j] == 0) {
					count++;
				}
			}
		}

		safetyZone = Math.max(count, safetyZone);
	}
}
