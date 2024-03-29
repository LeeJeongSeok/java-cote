package me.jeongseok.cote.math;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class BOJ_2981_K {
	public static void main(String[] args) throws IOException {
		// input
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int N = Integer.parseInt(br.readLine());
		StringBuilder sb = new StringBuilder();

		int[] arr = new int[N];
		for(int i = 0; i < N; i++) {
			arr[i] = Integer.parseInt(br.readLine());
		}


		// 맨처음값과 두번째값의 차이 구한다.
		int gcdValue = Math.abs(arr[0] - arr[1]);

		for (int i = 2; i < N; i++) {
			int num = Math.abs(arr[i] - arr[i - 1]);
			gcdValue = gcd(Math.max(gcdValue, num), Math.min(gcdValue, num));
		}

		for (int i = 2; i <= gcdValue; i++) {

			if(gcdValue % i == 0) {
				sb.append(i + " ");
			}
		}

		System.out.println(sb);
	}

	private static int gcd(int a, int b) {
		if(b == 0) {
			return a;
		}

		return gcd(b, a % b);
	}
}
