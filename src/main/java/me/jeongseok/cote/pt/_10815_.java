package me.jeongseok.cote.pt;

import java.io.*;
import java.util.*;

public class _10815_ {
	static int N, M;
	static int arrN[];
	static int arrM[];
	static StringBuilder sb = new StringBuilder();

	public static void main(String[] args) throws Exception{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

		N = Integer.parseInt(br.readLine());
		arrN = new int[N];

		StringTokenizer st = new StringTokenizer(br.readLine());
		for (int i = 0; i < N; i++) {
			arrN[i] = Integer.parseInt(st.nextToken());
		}


		M = Integer.parseInt(br.readLine());
		arrM = new int[M];

		st = new StringTokenizer(br.readLine());
		for (int i = 0; i < M; i++) {
			arrM[i] = Integer.parseInt(st.nextToken());
		}

		for (int i = 0; i < arrM.length; i++) {
			binarySearch(arrN, arrM[i], 0, arrN.length - 1);
		}

		System.out.println(sb);
	}

	private static void binarySearch(int[] arr, int target, int left, int right) {
		while (left <= right) {
			int mid = (left + right) / 2;

			if (arr[mid] == target) {
				sb.append("1").append(" ");
			} else if (arr[mid] < target) {
				left = mid + 1;
			} else if (arr[mid] > target) {
				right = mid - 1;
			}
		}
		sb.append("0").append(" ");
	}
}
