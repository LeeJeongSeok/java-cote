package me.jeongseok.cote.bruteforce;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class BOJ_1436 {

	public static void main(String[] args) throws IOException {

		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

		int n = Integer.parseInt(br.readLine());

		int series = 666;
		int count = 1;

		while (count != n) {
			series++;

			if (String.valueOf(series).contains("666")) {
				count++;
			}
		}

		System.out.println(series);
	}

}
