package me.jeongseok.cote.pt_practice;

import java.io.*;
import java.util.*;

public class _2467_ {

	static int N, temp;
	static int arr[];
	static int answer[];

	public static void main(String[] args) throws Exception{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

		N = Integer.parseInt(br.readLine());
		arr = new int[N];
		answer = new int[2];

		StringTokenizer st = new StringTokenizer(br.readLine());
		for (int i = 0; i < N; i++) {
			arr[i] = Integer.parseInt(st.nextToken());
		}

		if (arr[0] < 0) {
			temp = Integer.MIN_VALUE;
		} else {
			temp = Integer.MAX_VALUE;
		}

		// binarySearch 시작
		for (int i = 1; i < N; i++) {
			binarySearch(arr[i - 1], i, arr.length - 1);
		}

		System.out.println(answer[0] + " " + answer[1]);
	}

	private static int[] binarySearch(int start, int left, int right) {
		while (left <= right) {
			int mid = (left + right) / 2;

			int value = start + arr[mid];

			if (value == 0) {
				answer[0] = start;
				answer[1] = arr[mid];
			} else if (value < 0) {
				if (value > temp) {
					temp = value;
					answer[0] = start;
					answer[1] = arr[mid];
				}
				left = mid + 1;
			} else if (arr[mid] > 0) {
				if (value < temp) {
					temp = value;
					answer[0] = start;
					answer[1] = arr[mid];
				}
				right = mid - 1;
			}
		}

		return answer;
	}

}
