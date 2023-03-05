package me.jeongseok.cote.io;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

/**
 * *        *
 * **      **
 * ***    ***
 * ****  ****
 * **********
 * ****  ****
 * ***    ***
 * **      **
 * *        *
 *
 * 첫째 줄 부터 2 * n - 1 번째 줄까지 출력
 */
public class BOJ_2445 {

	public static void main(String[] args) throws IOException {

		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

		int n = Integer.parseInt(br.readLine());

		// 상단
		for (int i = 1; i <= n; i++) {

			// 별찍고
			for (int j = 0; j < i; j++) {
				System.out.print("*");
			}

			// 공백찍고
			for (int j = 0; j < 2 * (n - i); j++) {
				System.out.print(" ");
			}

			// 역순 별 찍고
			for (int j = 0; j < i; j++) {
				System.out.print("*");
			}
			System.out.println();
		}

		// 하단
		for (int i = 1; i <= n - 1; i++) {

			// 별찍고
			for (int j = 0; j < n - i; j++) {
				System.out.print("*");
			}

			// 공백찍고
			for (int j = 0; j < 2 * i; j++) {
				System.out.print(" ");
			}

			// 역순 별 찍고
			for (int j = 0; j < n - i; j++) {
				System.out.print("*");
			}
			System.out.println();
		}

	}

}
