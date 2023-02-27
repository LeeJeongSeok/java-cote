package me.jeongseok.cote.queue;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.Deque;
import java.util.StringTokenizer;

public class BOJ_2346 {

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();

		int n = Integer.parseInt(br.readLine());
		int[] arr = new int[n];

		// 풍선의 인덱스를 알기 위해 데큐의 타입을 배열로 선언
		Deque<int[]> deque = new ArrayDeque<>();
		StringTokenizer st = new StringTokenizer(br.readLine(), " ");

		for (int i = 0; i < n; i++) {
			arr[i] = Integer.parseInt(st.nextToken());
		}

		sb.append("1 ");
		int input = arr[0];

		// [풍선 인덱스, 풍선 번호]
		for (int i = 1; i < n; i++) {
			deque.add(new int[]{i + 1, arr[i]});
		}

		while (!deque.isEmpty()) {
			// 양수
			if (input > 0) {
				// 앞에서 뒤로
				for (int i = 1; i < input; i++) {
					deque.add(deque.poll());
				}

				int[] next = deque.poll();
				sb.append(next[0] + " ");
				input = next[1];
			}

			// 음수
			else {
				// 뒤에서 앞으로
				// input 자체가 음수로 들어오기 때문에 앞에 -를 붙혀주면 양수로 변환
				for (int i = 1; i < -input; i++) {
					deque.addFirst(deque.pollLast());
				}

				int[] next = deque.pollLast();
				sb.append(next[0] + " ");
				input = next[1];
			}
		}
		System.out.println(sb.toString());
	}

}
