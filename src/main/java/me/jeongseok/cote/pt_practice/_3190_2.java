package me.jeongseok.cote.pt_practice;

import java.io.*;
import java.util.*;

public class _3190_2 {

	static int N, K, L;
	static int[][] map;
	static int[] dx = new int[]{0, 1, 0, -1};
	static int[] dy = new int[]{1, 0, -1, 0};
	static Map<Integer, String> moveInfo = new HashMap<>();
	static final int APPLE = 1;

	public static void main(String[] args) throws Exception{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

		N = Integer.parseInt(br.readLine());
		K = Integer.parseInt(br.readLine());

		map = new int[N][N];
		for (int i = 0; i < K; i++) {
			StringTokenizer st = new StringTokenizer(br.readLine());
			int x = Integer.parseInt(st.nextToken()) - 1;
			int y = Integer.parseInt(st.nextToken()) - 1;
			map[x][y] = 1;
		}

		L = Integer.parseInt(br.readLine());
		for (int i = 0; i < L; i++) {
			StringTokenizer st = new StringTokenizer(br.readLine());
			int X = Integer.parseInt(st.nextToken());
			String C = st.nextToken();
			moveInfo.put(X, C);
		}

		dummyGame();
	}

	private static void dummyGame() {
		List<int[]> snake = new LinkedList<>();
		int snakeX = 0;
		int snakeY = 0;
		int time = 0;
		int direction = 0;
		snake.add(new int[]{snakeX, snakeY});

		while (true) {

			int nx = snakeX + dx[direction];
			int ny = snakeY + dy[direction];
			time++;

			if (nx < 0 || nx >= N || ny < 0 || ny >= N) {
				System.out.println(time);
				return;
			}


			for (int i = 0; i < snake.size(); i++) {
				if (nx == snake.get(i)[0] && ny == snake.get(i)[1]) {
					System.out.println(time);
					return;
				}
			}

			if (map[nx][ny] == APPLE) {
				map[nx][ny] = 0;
				snake.add(new int[]{nx, ny});
			} else {
				snake.add(new int[]{nx, ny});
				snake.remove(0);
			}

			if (moveInfo.containsKey(time)) {
				String next_direction = moveInfo.get(time);

				if (next_direction.equals("D")) {
					direction++;

					if (direction == 4) {
						direction = 0;
					}
				} else {
					direction--;

					if (direction == -1) {
						direction = 3;
					}
				}
			}
			snakeX = nx;
			snakeY = ny;
		}
	}

}
