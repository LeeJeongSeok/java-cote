package me.jeongseok.cote.pt;

/**
 * 6 4
 * 0 0 0 0 0 0
 * 0 0 0 0 0 0
 * 0 0 0 0 0 0
 * 0 0 0 0 0 1
 */
import java.io.*;
import java.util.*;
public class _7576_ {

	static int M, N, notTomato, result;
	static int dx[];
	static int dy[];
	static int map[][];
	static int dist[][];
	static boolean visited[][];
	static Queue<Pair> queue = new LinkedList<>();

	public static void main(String[] args) throws Exception{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());

		M = Integer.parseInt(st.nextToken());
		N = Integer.parseInt(st.nextToken());

		dx = new int[]{1, 0, -1, 0};
		dy = new int[]{0, 1, 0, -1};
		map = new int[N][M];
		dist = new int[N][M];
		visited = new boolean[N][M];

		// 1. 토마토 입력
		for (int i = 0; i < N; i++) {
			st = new StringTokenizer(br.readLine());
			for (int j = 0; j < M; j++) {
				map[i][j] = Integer.parseInt(st.nextToken());

				// 익은 토마토와 익지 않은 토마토의 수를 맨 처음 계산
				if (map[i][j] == 0) {
					notTomato++;
				}

				if (map[i][j] == -1) {
					dist[i][j] = -1;
				}

				if (!visited[i][j] && map[i][j] == 1){
					queue.add(new Pair(i, j));
					visited[i][j] = true;
					dist[i][j] = 1;
				}
			}
		}

		bfs();

		// 만약 처음부터 모든 토마토가 익어있다면
		if (notTomato == 0) {
			System.out.println(0);
			return;
		}

		// 날짜가 지나서 익은 경우
		// 전체 토마토 개수에서, 익은 토마토의 개수만 빼면 됨
		for (int i = 0; i < N; i++) {
			for (int j = 0; j < M; j++) {
				if (dist[i][j] == 0) {
					System.out.println(-1);
					return;
				} else {
					result = Math.max(result, dist[i][j]);
				}
			}
		}

		System.out.println(result - 1);
	}



	private static void bfs() {
		while (!queue.isEmpty()) {
			Pair cur = queue.poll();

			for (int i = 0; i < 4; i++) {
				int nx = cur.x + dx[i];
				int ny = cur.y + dy[i];

				if (nx < 0 || nx >= N || ny < 0 || ny >= M) {
					continue;
				}

				if (visited[nx][ny] || map[nx][ny] == -1) {
					continue;
				}

				queue.add(new Pair(nx, ny));
				visited[nx][ny] = true;
				dist[nx][ny] = dist[cur.x][cur.y] + 1;
			}
		}
	}
}
