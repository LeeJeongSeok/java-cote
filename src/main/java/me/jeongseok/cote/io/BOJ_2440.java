package me.jeongseok.cote.io;

import java.io.IOException;
import java.util.Scanner;

/**
 * *****
 * ****
 * ***
 * **
 * *
 */

public class BOJ_2440 {
	public static void main(String[] args) throws IOException {
		Scanner sc = new Scanner(System.in);

		int n = sc.nextInt();

		for (int i = 0; i < n; i++) {
			for (int j = 1; j <= n - i; j++) {
				System.out.print("*");
			}
			System.out.println();
		}

	}
}
