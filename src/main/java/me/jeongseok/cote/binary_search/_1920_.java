package me.jeongseok.cote.binary_search;

import java.io.*;
import java.util.*;

public class _1920_ {

	static int N, M;
	static int A[];
	static int B[];

	public static void main(String[] args) throws Exception{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

		N = Integer.parseInt(br.readLine());
		A = new int[N];

		StringTokenizer st = new StringTokenizer(br.readLine());
		for (int i = 0; i < N; i++) {
			A[i] = Integer.parseInt(st.nextToken());
		}

		Arrays.sort(A);

		M = Integer.parseInt(br.readLine());
		B = new int[M];

		st = new StringTokenizer(br.readLine());
		for (int i = 0; i < M; i++) {
			B[i] = Integer.parseInt(st.nextToken());
		}

		for (int i = 0; i < B.length; i++) {
			System.out.println(binarySearch(A, B[i], 0, A.length - 1));
		}
	}

	private static int binarySearch(int[] arr, int target, int start, int end) {
		while (start <= end) {
			int mid = (start + end) / 2;

			if (arr[mid] == target) {
				return 1;
			} else if (arr[mid] < target) {
				start = mid + 1;
			} else if (arr[mid] > target) {
				end = mid - 1;
			}
		}
		return 0;
	}

}
