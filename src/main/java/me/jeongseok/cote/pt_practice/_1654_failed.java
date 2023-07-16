package me.jeongseok.cote.pt_practice;

import java.io.*;
import java.util.*;

public class _1654_failed {

	static int K, N, result;
	static int max = Integer.MIN_VALUE;
	static int arr[];

	public static void main(String[] args) throws Exception{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());

		K = Integer.parseInt(st.nextToken());
		N = Integer.parseInt(st.nextToken());
		arr = new int[K];

		for (int i = 0; i < K; i++) {
			arr[i] = Integer.parseInt(br.readLine());
			max = Math.max(max, arr[i]);
		}

		binarySearch(arr, N, 0, max);
		System.out.println(result);
	}

	private static void binarySearch(int[] arr, int target, int start, int end) {
		while (start <= end) {
			int total = 0;

			int mid = (start + end) / 2;

			for (int i = 0; i < K; i++) {
				if (arr[i] > mid) {
					total += arr[i] / mid;
				}
			}

			if (total < target) {
				end = mid - 1;
			} else  {
				result = mid;
				start = mid + 1;
			}
		}
	}

}
