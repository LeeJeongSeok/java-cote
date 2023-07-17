package me.jeongseok.cote.pt_practice;

import java.io.*;
import java.util.*;

public class _1654_success {
	static int K, N;
	static long result;
	static int arr[];

	public static void main(String[] args) throws Exception{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());

		K = Integer.parseInt(st.nextToken());
		N = Integer.parseInt(st.nextToken());
		arr = new int[K];

		for (int i = 0; i < K; i++) {
			arr[i] = Integer.parseInt(br.readLine());
		}

		Arrays.sort(arr);

		binarySearch(arr, N, 1, arr[K - 1]);
		System.out.println(result);
	}

	private static void binarySearch(int[] arr, int target, long start, long end) {
		while (start <= end) {
			long total = 0;

			long mid = (start + end) / 2;

			for (int i = 0; i < K; i++) {
				total += (arr[i] / mid);
			}

			if (total < target) {
				end = mid - 1;
			} else  {
				result = Math.max(result, mid);
				start = mid + 1;
			}
		}
	}
}
