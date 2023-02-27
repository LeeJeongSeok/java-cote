package me.jeongseok.cote.bruteforce;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class BOJ_2231 {

	public static void main(String[] args) throws IOException {

		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

		int n = Integer.parseInt(br.readLine());

		int result = 0;

		for (int i = 0; i < n; i++) {
			int sum = 0;
			int number = i;


			while (number != 0) {
				sum += number % 10;
				number /= 10;
			}

			if (sum + i == n) {
				result = i;
				break;
			}
		}

		System.out.println(result);
	}

}
