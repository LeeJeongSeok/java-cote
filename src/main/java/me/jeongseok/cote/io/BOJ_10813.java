package me.jeongseok.cote.io;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class BOJ_10813 {

	static int N, M;
	static int[] buckets;
	static StringBuilder sb = new StringBuilder();

	static void swapBall(int start, int end) {
		int temp = buckets[start];
		buckets[start] = buckets[end];
		buckets[end] = temp;
	}

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine(), " ");

		N = Integer.parseInt(st.nextToken());
		M = Integer.parseInt(st.nextToken());

		// 바구니 초기화
		buckets = new int[N + 1];
		for (int i = 1; i <= N; i++) {
			buckets[i] = i;
		}

		for (int i = 0; i < M; i++) {
			st = new StringTokenizer(br.readLine(), " ");

			int start = Integer.parseInt(st.nextToken());
			int end = Integer.parseInt(st.nextToken());

			swapBall(start, end);
		}
		printBallNumber();
	}

	static void printBallNumber() {
		for (int i = 1; i <= N; i++) {
			sb.append(buckets[i]).append(" ");
		}

		System.out.println(sb.toString());
	}

}
