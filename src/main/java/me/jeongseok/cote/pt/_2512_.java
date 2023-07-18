package me.jeongseok.cote.pt;

/**
 * 정해진 총액 이하에서 가능한 한 최대의 예산을 배정
 * 1. 모든 요청이 배정될 수 있는 경우에는 요청한 금액을 배정
 * 2. 배정이 될 수 없다면 정수 상한액으로 배정, 상한액 이하의 예산 요청액은 요청한 금액 그대로
 */

import java.io.*;
import java.util.*;
public class _2512_ {

	static int N, M, result;
	static int arr[];

	public static void main(String[] args) throws Exception{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

		N = Integer.parseInt(br.readLine());
		arr = new int[N];

		StringTokenizer st = new StringTokenizer(br.readLine());
		for (int i = 0; i < N; i++) {
			arr[i] = Integer.parseInt(st.nextToken());
		}

		M = Integer.parseInt(br.readLine());

		Arrays.sort(arr);
		binarySearch(arr, M, 1, arr[N - 1]);
		System.out.println(result);
	}

	private static void binarySearch(int[] arr, int target, int start, int end) {
		while (start <= end) {
			int temp = 0;

			int mid = (start + end) / 2;

			for (int i = 0; i < arr.length; i++) {
				if (arr[i] >= mid) { // 상한액 보다 크거나 같은 경우
					temp += mid;
				} else { // 상한액 보다 작은 경우
					temp += arr[i];
				}
			}

			if (temp <= target) {
				result = mid;
				start = mid + 1;
			} else {
				end = mid - 1;
			}
		}
	}
}
