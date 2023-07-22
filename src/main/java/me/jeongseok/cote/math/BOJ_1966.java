package me.jeongseok.cote.math;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

class Document {
	int idx;
	int priority;

	public Document(int idx, int priority) {
		this.idx = idx;
		this.priority = priority;
	}
}

public class BOJ_1966 {

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int T = Integer.parseInt(br.readLine());
		StringBuilder sb = new StringBuilder();

		while (T-- > 0) {
			StringTokenizer st = new StringTokenizer(br.readLine(), " ");
			int N = Integer.parseInt(st.nextToken());
			int M = Integer.parseInt(st.nextToken());
			int count = 0;

			st = new StringTokenizer(br.readLine(), " ");
			LinkedList<Document> queue = new LinkedList<>();
			for (int i = 0; i < N; i++) {
				queue.add(new Document(i, Integer.parseInt(st.nextToken())));
			}


			while (!queue.isEmpty()) {
				Document front = queue.poll();
				boolean isMax = true;

				for (int i = 0; i < queue.size(); i++) {
					if (front.priority < queue.get(i).priority) {
						queue.offer(front);
						isMax = false;
						break;
					}
				}

				if (!isMax) {
					continue;
				}

				count++;
				if (front.idx == M) {
					break;
				}
			}

			sb.append(count).append("\n");
		}

		System.out.println(sb);
	}

}
