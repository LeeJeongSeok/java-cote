package me.jeongseok.cote.pt;

import java.io.*;
import java.util.*;

public class _2805_ {

	static int N, M, result;
	static int arr[];

	public static void main(String[] args) throws Exception{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());

		N = Integer.parseInt(st.nextToken());
		M = Integer.parseInt(st.nextToken());
		arr = new int[N];

		st = new StringTokenizer(br.readLine());
		for (int i = 0; i < N; i++) {
			arr[i] = Integer.parseInt(st.nextToken());
		}

		// 정렬
		Arrays.sort(arr);

		binarySearch(arr, M, 0, arr[N - 1]);
		System.out.println(result);
	}

	private static void binarySearch(int[] arr, int target, int start, int end) {
		while (start <= end) {
			long temp = 0;

			int mid = (start + end) / 2;

			for (int i = 0; i < arr.length; i++) {
				if (arr[i] > mid) { // 설정한 톱의 높이보다 크면 자른다.
					temp += arr[i] - mid;
				}
			}

			if (temp < target) {
				end = mid - 1;
			} else {
				result = mid;
				start = mid + 1;
			}
		}
	}
}
