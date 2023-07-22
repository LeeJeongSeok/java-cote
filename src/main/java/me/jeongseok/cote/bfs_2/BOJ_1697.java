package me.jeongseok.cote.bfs_2;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class BOJ_1697 {

	static int[] distance = new int[100001];

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine(), " ");

		int N = Integer.parseInt(st.nextToken());
		int K = Integer.parseInt(st.nextToken());

		for (int i = 0; i <= 100000; i++) {
			distance[i] = -1;
		}

		Queue<Integer> queue = new LinkedList<>();
		queue.offer(N);
		distance[N] = 0;

		while (!queue.isEmpty()) {
			int cur = queue.poll();

			if (cur == K) {
				System.out.println(distance[cur]);
				return;
			}

			int x1 = cur - 1;
			int x2 = cur + 1;
			int x3 = cur * 2;

			if (x1 >= 0 && x1 <= 100000 && distance[x1] == -1) {
				queue.offer(x1);
				distance[x1] = distance[cur] + 1;
			}

			if (x2 >= 0 && x2 <= 100000 && distance[x2] == -1) {
				queue.offer(x2);
				distance[x2] = distance[cur] + 1;
			}

			if (x3 >= 0 && x3 <= 100000 && distance[x3] == -1) {
				queue.offer(x3);
				distance[x3] = distance[cur] + 1;
			}
		}
	}

}
