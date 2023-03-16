package me.jeongseok.cote.io;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class BOJ_25314 {

	static StringBuilder sb = new StringBuilder();

	static void solution(int n) {

		for (int i = 0; i < n / 4; i++) {
			sb.append("long").append(" ");
		}

		sb.append("int");
	}

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int n = Integer.parseInt(br.readLine());

		solution(n);
		System.out.println(sb.toString());
	}

}
