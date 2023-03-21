package me.jeongseok.cote.io;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;
import java.util.stream.IntStream;

/**
 * 1 4 6 2 3 7 10 5 8 9
 */

public class BOJ_10812 {

	static int N, M;
	static int[] buckets;
	static StringBuilder sb = new StringBuilder();

	static int[] rotateBucket(int[] buckets, int begin, int end, int mid) {
		int[] temp = new int[buckets.length];
		System.arraycopy(buckets, 0, temp, 0, buckets.length);

		System.arraycopy(buckets, mid, temp, begin, end - mid + 1);
		System.arraycopy(buckets, begin, temp, begin + end - mid + 1, mid - begin);
		System.arraycopy(buckets, end + 1, temp, end + 1, buckets.length - 1 - end);

		return temp;
	}

	public static void main(String[] args) throws IOException {
		init();

		printBuckets();
	}

	private static void init() throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine(), " ");

		N = Integer.parseInt(st.nextToken());
		M = Integer.parseInt(st.nextToken());

		buckets = IntStream.range(0, N + 1).toArray();

		for (int i = 0; i < M; i++) {
			st = new StringTokenizer(br.readLine(), " ");
			int begin = Integer.parseInt(st.nextToken());
			int end = Integer.parseInt(st.nextToken());
			int mid = Integer.parseInt(st.nextToken());

			buckets = rotateBucket(buckets, begin, end, mid);

		}
	}

	static void printBuckets() {
		for (int i = 1; i <= N; i++) {
			sb.append(buckets[i]).append(" ");
		}

		System.out.println(sb.toString());
	}

}
