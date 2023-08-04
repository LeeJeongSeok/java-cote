package me.jeongseok.cote.pt_practice;

import java.io.*;
import java.util.*;

public class _3190_ {

	static int[][] map;

	// 동 남 서 북 방향
	static int[] dx = {0, 1, 0, -1};
	static int[] dy = {1, 0, -1, 0};
	static int N, K, L;
	static Map<Integer, String> move;
	static final int APPLE = 1;

	public static void main(String[] args) throws Exception{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

		N = Integer.parseInt(br.readLine());
		K = Integer.parseInt(br.readLine());
		map = new int[N][N];
		move = new HashMap<>();

		StringTokenizer st;
		for (int i = 0; i < K; i++) {
			st = new StringTokenizer(br.readLine());
			int x = Integer.parseInt(st.nextToken()) - 1;
			int y = Integer.parseInt(st.nextToken()) - 1;
			map[x][y] = APPLE;
		}

		L = Integer.parseInt(br.readLine());

		for (int i = 0; i < L; i++) {
			st = new StringTokenizer(br.readLine());
			move.put(Integer.parseInt(st.nextToken()), st.nextToken());
		}

		dummyGame();
	}

	private static void dummyGame() {
		Queue<Pair> queue = new LinkedList<>();
		queue.add(new Pair(0, 0));
		int time = 0;
		// 현재 뱀의 위치
		int cx = 0;
		int cy = 0;
		int direction = 0; // 뱀은 처음에 동쪽으로 이동한다.

		while (true) {

			int nx = cx + dx[direction];
			int ny = cy + dy[direction];
			time++;

			// 벽에 부딪히는 경우
			if (nx < 0 || nx >= N || ny < 0 || ny >= N) {
				break;
			}

			// 자기 몸에 부딪히는 경우
			// 리스트나 배열에 해당 좌표가 존재하는지 판별 -> 있다면 몸에 부딪힘, 없다면 암것도아님
			if (queue.contains(new Pair(nx, ny))) {
				break;
			}

			// 벽과 자기 몸에 안부딪히는 경우
			if (map[nx][ny] == APPLE) {
				map[nx][ny] = 0;
				queue.add(new Pair(nx, ny)); // 큐에 집어넣는 것이 뱀의 몸길이를 늘려 머리를 다음칸에 이동시키는 로직
			} else {
				// 몸길이를 줄여서 꼬리가 위치한 칸을 비워준다. 즉, 몸길이는 변하지 않는다.
				queue.add(new Pair(nx, ny)); // 머리는 늘리고
				queue.poll(); // 꼬리는 비운다. 결국 앞뒤로 -1, +1 이기 때문에 몸길이가 변하지 않는다.
			}

			// 방향 전환
			// 시간초가 증가하면서 방향 변환 정보에 해당하는 초가 존재한다면 방향을 바꿔줘야한다.
			if (move.containsKey(time)) {

				String next_direction = move.get(time);

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

			cx = nx;
			cy = ny;
		}

		System.out.println(time);

	}

}
