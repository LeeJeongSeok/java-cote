package me.jeongseok.cote.greedy;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

/**
 * 10 4200
 * 1
 * 5
 * 10
 * 50
 * 100
 * 500
 * 1000
 * 5000
 * 10000
 * 50000
 */

public class BOJ_11047 {

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());

		// n, k를 입력 받는다.
		// 동전의 가치 A 배열을 선언한다.
		// 반복을 돌면서 동전의 가치 A의 원소를 하나씩 A 배열에 집어넣는다.

		int count = 0;
		int n = Integer.parseInt(st.nextToken());
		int k = Integer.parseInt(st.nextToken());

		int[] a = new int[n];

		for (int i = 0; i < n; i++) {
			a[i] = Integer.parseInt(br.readLine());
		}

		// A의 배열을 거꾸로 순회하면서 해당 원소를 k가 A의 원소보다 작은지 판별한다.
		for (int i = n-1; i >= 0; i--) {
			if (a[i] <= k) {
				// 작은 경우 해당 원소로 k를 나눈다.
				count += k / a[i];
				k = k % a[i];
			}
		}

		System.out.println(count);
	}

}
