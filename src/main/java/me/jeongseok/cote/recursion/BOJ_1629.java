package me.jeongseok.cote.recursion;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class BOJ_1629 {

	static long A,B,C;

	static long calculate(long a, long b) {
		if (b == 1) {
			return a % C;
		} else {
			long temp = calculate(a, b / 2);

			if (b % 2 == 1) {
				return (temp * temp % C) * a % C;
			}
			return temp * temp % C;
		}
	}

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine(), " ");

		A = Long.parseLong(st.nextToken());
		B = Long.parseLong(st.nextToken());
		C = Long.parseLong(st.nextToken());

		System.out.println(calculate(A, B));
	}

}
