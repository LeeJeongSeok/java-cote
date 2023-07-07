package me.jeongseok.cote.pt_practice;

/**
 * 수빈이는 1초 후에 현재 위치에서 -1, +1, *2 중 1곳으로 이동할 수 있다.
 * 수빈이와 동생의 위치가 주어지면, 수빈이가 동생을 찾을 수 있는 가장 빠른 시간을 구하는 문제이다.
 *
 * 입력으로는 수빈이의 위치와 동생의 위치를 받는다.
 * 처리에 필요한 변수들은 입력으로 들어온 최대치 길이에 대한 1차원 거리 배열, 동일한 길이의 1차원 방문 배열, BFS 탐색을 위한 큐가 필요하다.
 * 처리한 후 최종적으로 입력으로 받은 동생의 위치 인덱스값을 반환하면 종료이다.
 *
 * 주의할점은 수빈이와, 동생이 같은지점에 있을 수 있다는 것과 둘다 0이 들어올 수 있다는 것이다. 이 점만 주의해서 풀자
 */
import java.io.*;
import java.util.*;
public class _1697_ {

	static int N, K;
	static int dist[];
	static boolean visited[];
	static Queue<Integer> queue = new LinkedList<>();

	public static void main(String[] args) throws Exception{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());

		N = Integer.parseInt(st.nextToken());
		K = Integer.parseInt(st.nextToken());

		dist = new int[100_001];
		visited = new boolean[100_001];

		bfs(N);
		System.out.println(dist[K]);
	}

	private static void bfs(int start) {
		queue.add(start);
		visited[start] = true;
		dist[start] = 0;

		while (!queue.isEmpty()) {
			int cur = queue.poll();

			int x1 = cur - 1;
			int x2 = cur + 1;
			int x3 = cur * 2;

			// visited를 먼저 비교하면 안됨, 그 이유는 x1, x2, x3 값이 범위를 벗어날 수 있기 때문에 우선적으로 범위값을 체크한 후 방문을 체크한다.
			// 순서를 뒤바꿔서 비교하면 index 에러 만남
			if (x1 >= 0 && !visited[x1]) {
				queue.add(x1);
				visited[x1] = true;
				dist[x1] = dist[cur] + 1;
			}

			if (x2 <= 100_000 && !visited[x2]) {
				queue.add(x2);
				visited[x2] = true;
				dist[x2] = dist[cur] + 1;
			}

			if (x3 <= 100_000 && !visited[x3]) {
				queue.add(x3);
				visited[x3] = true;
				dist[x3] = dist[cur] + 1;
			}
		}
	}

}
