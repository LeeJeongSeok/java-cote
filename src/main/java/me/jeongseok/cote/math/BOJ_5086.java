package me.jeongseok.cote.math;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class BOJ_5086 {

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();

		while (true) {
			StringTokenizer st = new StringTokenizer(br.readLine(), " ");

			int x = Integer.parseInt(st.nextToken());
			int y = Integer.parseInt(st.nextToken());

			if (x == 0 && y == 0) {
				System.out.println(sb.toString());
				break;
			}

			// 배수의 관계
			if (x < y) {
				if (y % x == 0) {
					sb.append("factor").append("\n");
				} else {
					sb.append("neither").append("\n");
				}
			} else if (x > y) { // 약수의 관계
				if (x % y == 0) {
					sb.append("multiple").append("\n");
				} else {
					sb.append("neither").append("\n");
				}
			}
		}
	}

}
