package me.jeongseok.cote.math;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;

public class BOJ_2581 {

	static ArrayList<Integer> list = new ArrayList<>();

	static void isPrimeNumber(int n) {
		// 1과 자기자신을 제외한 나머지 수로 나누어 떨어지지 않는 수
		boolean isPrime = true;

		if (n == 1) {
			return;
		}

		for (int i = 2; i < n; i++) {
			if (n % i == 0) {
				isPrime = false;
				break;
			}
		}

		if (isPrime) {
			list.add(n);
		}
	}

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int N = Integer.parseInt(br.readLine());
		int M = Integer.parseInt(br.readLine());

		int sum = 0;
		int min = Integer.MAX_VALUE;

		for (int i = N; i <= M; i++) {
			isPrimeNumber(i);
		}

		if (list.size() == 0) {
			System.out.println(-1);
			System.exit(0);
		}

		for (int i = 0; i < list.size(); i++) {
			int value = list.get(i);

			sum += value;

			if (value < min) {
				min = value;
			}
		}
		System.out.println(sum + "\n" + min);

	}

}
