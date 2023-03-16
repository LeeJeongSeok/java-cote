package me.jeongseok.cote.recursion;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.Inet4Address;

public class BOJ_2447 {

	static StringBuilder sb = new StringBuilder();
	static int n;

	static void star(int n, int count) {
		if ((int) Math.pow(3, count) == n) {
			return;
		} else {
			sb.append("***").append("\n").append("* *").append("\n").append("***");
			star(3, count + 1);
		}
	}

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

		n = Integer.parseInt(br.readLine());
		star(n, 1);

		System.out.println(sb.toString());
	}

}
