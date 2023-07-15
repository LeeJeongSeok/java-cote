package me.jeongseok.cote.pt_practice;

/**
 * 1. N과 N개의 정수를 입력받는다.
 * 2. N개의 정수를 배열에 저장한다.
 * 3. 2번 과정에서 저장한 정수들을 오름차순으로 정렬한다.
 * 4. M과 M개의 정수를 입력받는다.
 * 5. M개의 정수를 배열에 저장한다.
 * 6. M의 크기 만큼 반복문을 순회하면서 5번 과정에서 저장한 정수들이 크기가 N인 배열에 존재하는지를 판단한다 (이분탐색 활용).
 * 7. 있으면 1를 출력 없으면 0을 출력
 */

import java.io.*;
import java.util.*;
public class _1920_ {

	static int N, M;
	static int arrN[];
	static int arrM[];

	public static void main(String[] args) throws Exception{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

		N = Integer.parseInt(br.readLine());
		arrN = new int[N];

		StringTokenizer st = new StringTokenizer(br.readLine());
		for (int i = 0; i < N; i++) {
			arrN[i] = Integer.parseInt(st.nextToken());
		}

		Arrays.sort(arrN);

		M = Integer.parseInt(br.readLine());
		arrM = new int[M];

		st = new StringTokenizer(br.readLine());
		for (int i = 0; i < M; i++) {
			arrM[i] = Integer.parseInt(st.nextToken());
		}

		for (int i = 0; i < M; i++) {
			System.out.println(binarySearch(arrN, arrM[i], 0, arrN.length - 1));
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
