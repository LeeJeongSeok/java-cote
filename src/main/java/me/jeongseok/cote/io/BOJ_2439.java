package me.jeongseok.cote.io;

import java.io.IOException;
import java.util.Scanner;

/**
 *     *
 *    **
 *   ***
 *  ****
 * *****
 */

public class BOJ_2439 {
	public static void main(String[] args) throws IOException {

		Scanner sc = new Scanner(System.in);

		int n = sc.nextInt();

		for (int i = 1; i <= n; i++) {
			// 공백
			for (int j = 0; j < n - i; j++) {
				System.out.print(" ");
			}

			// 별
			for (int j = 0; j < i; j++) {
				System.out.print("*");
			}

			System.out.println();
		}
	}
}
