package me.jeongseok.cote.io;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

/**
 * 1 4 6 2 3 7 10 5 8 9
 */

public class BOJ_10812 {

	static int N, M, begin, end, mid;
	static int[] buckets;
	static int[] temp;
	static StringBuilder sb = new StringBuilder();

	static void copyTemp() {
		int distance = mid - begin;
		temp = new int[distance + 1];

		for (int i = 0; i < distance; i++) {
			temp[i + 1] = buckets[begin + i];
		}
	}

	static void moveMid() {
		int distance = end - mid;
		for (int i = 0; i <= distance; i++) {
			buckets[begin + i] = buckets[mid + i];
		}
	}

	static void moveTemp() {
		int start = end - mid;
		int distance = mid - begin;
		for (int i = 1; i <= distance; i++) {
			buckets[begin + start + i] = temp[i];
		}
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

		buckets = new int[N + 1];

		for (int i = 1; i <= 10; i++) {
			buckets[i] = i;
		}

		for (int i = 0; i < M; i++) {
			st = new StringTokenizer(br.readLine(), " ");
			begin = Integer.parseInt(st.nextToken());
			end = Integer.parseInt(st.nextToken());
			mid = Integer.parseInt(st.nextToken());

			copyTemp();
			moveMid();
			moveTemp();
		}
	}

	static void printBuckets() {
		for (int i = 1; i <= N; i++) {
			sb.append(buckets[i]).append(" ");
		}

		System.out.println(sb.toString());
	}

}
