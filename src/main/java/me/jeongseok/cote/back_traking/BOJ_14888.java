package me.jeongseok.cote.back_traking;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class BOJ_14888 {

	static int n;
	static int max = Integer.MIN_VALUE;
	static int min = Integer.MAX_VALUE;

	static int[] arr;
	static int[] operator;


	public static void backTracking(int number, int idx) {
		// 종료 조건
		if (idx == n) {
			max = Math.max(number, max);
			min = Math.min(number, min);
			return;
		}

		// 돌려버리기~!
		for (int i = 0; i < 4; i++) {
			// 2, 1, 1, 1
			if (operator[i] > 0) {

				operator[i]--;

				if (i == 0) {
					backTracking(number + arr[idx], idx + 1);
				} else if (i == 1) {
					backTracking(number - arr[idx], idx + 1);
				} else if (i == 2) {
					backTracking(number * arr[idx], idx + 1);
				} else if (i == 3) {
					backTracking(number / arr[idx], idx + 1);
				}
				operator[i]++;
			}
		}

	}

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

		n = Integer.parseInt(br.readLine());
		arr = new int[n];
		operator = new int[4];

		StringTokenizer st = new StringTokenizer(br.readLine(), " ");
		for (int i = 0; i < n; i++) {
			arr[i] = Integer.parseInt(st.nextToken());
		}

		st = new StringTokenizer(br.readLine(), " ");
		for (int i = 0; i < 4; i++) {
			operator[i] = Integer.parseInt(st.nextToken());
		}

		// 첫번째 요소를 넣고, 두번째 요소부터 연산을 시작해야함
		backTracking(arr[0], 1);

		System.out.println(max);
		System.out.println(min);
	}

}
