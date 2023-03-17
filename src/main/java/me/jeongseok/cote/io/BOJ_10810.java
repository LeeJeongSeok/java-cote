package me.jeongseok.cote.io;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

/**
 * 5 4
 * 1 2 3
 * 3 4 4
 * 1 4 1
 * 2 2 2
 *
 *
 * 1 2 1 1 0
 */
public class BOJ_10810 {

	static int N, M;
	static int[] buckets;
	static StringBuilder sb = new StringBuilder();

	static void insertBall(int start, int end, int ballNumber) {
		for (int i = start; i <= end; i++) {
			buckets[i] = ballNumber;
		}
	}

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine(), " ");

		N = Integer.parseInt(st.nextToken());
		M = Integer.parseInt(st.nextToken());
		buckets = new int[N + 1];

		for (int i = 0; i < M; i++) {
			st = new StringTokenizer(br.readLine(), " ");

			int start = Integer.parseInt(st.nextToken());
			int end = Integer.parseInt(st.nextToken());
			int ballNumber = Integer.parseInt(st.nextToken());

			insertBall(start, end, ballNumber);
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
