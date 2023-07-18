package me.jeongseok.cote.pt;

import java.io.*;
import java.util.*;

public class _2110_ {
	static int N, C, result;
	static int arr[];

	public static void main(String[] args) throws Exception{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());

		N = Integer.parseInt(st.nextToken());
		C = Integer.parseInt(st.nextToken());
		arr = new int[N];

		for (int i = 0; i < N; i++) {
			arr[i] = Integer.parseInt(br.readLine());
		}

		Arrays.sort(arr);

		binarySearch(arr, C, 1, arr[N - 1] - arr[0]);
		System.out.println(result);
	}

	private static void binarySearch(int[] arr, int target, int left, int right) {
		while (left <= right) {
			int count = 1;
			int mid = (left + right) / 2;

			int start = arr[0];

			for (int i = 0; i < arr.length; i++) {
				int dist = arr[i] - start;

				if (dist >= mid) {
					count++;
					start = arr[i];
				}
			}

			if (count >= target) {
				result = mid;
				left = mid + 1;
			} else {
				right = mid - 1;
			}
		}

	}
}
