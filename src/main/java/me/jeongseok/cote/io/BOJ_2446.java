package me.jeongseok.cote.io;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

/**
 * *********
 *  *******
 *   *****
 *    ***
 *     *
 *    ***
 *   *****
 *  *******
 * *********
 */
public class BOJ_2446 {

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

		int n = Integer.parseInt(br.readLine());

		// 상단 삼각형
		for (int i = 0; i < n - 1; i++) {

			// 공백 출력
			for (int j = 0; j < i; j++) {
				System.out.print(" ");
			}

			// 별 출력
			for (int j = 0; j < 2 * (n - i) - 1; j++) {
				System.out.print("*");
			}
			System.out.println();
		}


		// 하단 삼각형
		for (int i = 1; i <= n; i++) {
			// 공백 출력
			for (int j = 0; j < n - i; j++) {
				System.out.print(" ");
			}

			// 별 출력
			for (int j = 0; j < 2 * i - 1; j++) {
				System.out.print("*");
			}
			System.out.println();
		}
	}

}
