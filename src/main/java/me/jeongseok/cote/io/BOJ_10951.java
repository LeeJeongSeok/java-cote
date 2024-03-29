package me.jeongseok.cote.io;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class BOJ_10951 {

	public static void main(String[] args) throws IOException {

		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		String input = "";

		while ((input = br.readLine()) != null) {
			StringTokenizer st = new StringTokenizer(input);

			if (st.hasMoreTokens()) {
				int a = Integer.parseInt(st.nextToken());
				int b = Integer.parseInt(st.nextToken());

				System.out.println(a + b);
			} else {
				break;
			}
		}
	}
}
