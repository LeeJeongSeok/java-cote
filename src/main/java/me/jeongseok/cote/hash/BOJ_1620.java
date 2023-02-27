package me.jeongseok.cote.hash;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.HashMap;
import java.util.Map;
import java.util.StringTokenizer;

public class BOJ_1620 {

	public static boolean isDigit(String str) {
		for (int i = 0; i < str.length(); i++) {
			if (!Character.isDigit(str.charAt(i))) {
				return false;
			}
		}
		return true;
	}

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine(), " ");
		StringBuilder sb = new StringBuilder();

		int n = Integer.parseInt(st.nextToken());
		int m = Integer.parseInt(st.nextToken());

		Map<Integer, String> index = new HashMap<>();
		Map<String, Integer> name = new HashMap<>();

		for (int i = 1; i <= n; i++) {
			String input = br.readLine();
			index.put(i, input);
			name.put(input, i);
		}

		for (int i = 1; i <= m; i++) {
			String input = br.readLine();
			if (isDigit(input)) {
				sb.append(index.get(Integer.parseInt(input))).append("\n");
			} else {
				sb.append(name.get(input)).append("\n");
			}
		}

		System.out.println(sb.toString());

	}
}
