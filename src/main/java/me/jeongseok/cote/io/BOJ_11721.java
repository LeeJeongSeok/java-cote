package me.jeongseok.cote.io;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class BOJ_11721 {

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

		String[] input = br.readLine().split("");

		for (int i = 0; i < input.length; i++) {
			System.out.print(input[i]);

			if (i % 10 == 9) {
				System.out.println();
			}
		}
	}
}
