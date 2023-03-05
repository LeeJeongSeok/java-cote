package me.jeongseok.cote.io;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

/**
 * 첫째 줄부터 2×N-1번째 줄까지 차례대로 별을 출력한다.
 *   *
 *  **
 * ***
 *  **
 *   *
 */
public class BOJ_2522 {

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

		int n = Integer.parseInt(br.readLine());

		for (int i = 1; i <= n; i++) {

			// 공백 찍고
			for (int j = 0; j < n - i; j++) {
				System.out.print(" ");
			}
			// 별 찍고
			for (int j = 0; j < i; j++) {
				System.out.print("*");
			}
			System.out.println();
		}


		for (int i = 1; i <= n - 1; i++) {

			// 공백 찍고
			for (int j = 0; j < i; j++) {
				System.out.print(" ");
			}
			// 별 찍고
			for (int j = 0; j < n - i; j++) {
				System.out.print("*");
			}
			System.out.println();
		}

	}

}
