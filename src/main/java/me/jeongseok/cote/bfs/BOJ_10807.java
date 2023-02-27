package me.jeongseok.cote.bfs;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class BOJ_10807 {
	static int n;
	static int[] arr;
	static int v;
	public static void main(String[] args) throws IOException {

		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

		n = Integer.parseInt(br.readLine());
		arr = new int[n];

		int count = 0;

		StringTokenizer st = new StringTokenizer(br.readLine(), " ");

		for (int i = 0; i < n; i++) {
			arr[i] = Integer.parseInt(st.nextToken());
		}

		v = Integer.parseInt(br.readLine());

		for (int i = 0; i < arr.length; i++) {
			if (arr[i] == v) {
				count++;
			}
		}

		System.out.println(count);

	}
}
