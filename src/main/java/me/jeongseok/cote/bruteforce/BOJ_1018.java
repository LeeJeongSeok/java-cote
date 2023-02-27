package me.jeongseok.cote.bruteforce;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.StringTokenizer;

public class BOJ_1018 {

	static String[][] chess;
	static ArrayList<Integer> list;
	static int min = 64;

	static int[] dx = new int[]{1, 0, -1, 0};
	static int[] dy = new int[]{0, 1, 0, -1};

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine(), " ");

		int N = Integer.parseInt(st.nextToken());
		int M = Integer.parseInt(st.nextToken());
		chess = new String[N][M];

		list = new ArrayList<>();

		for (int i = 0; i < N; i++) {
			String str = br.readLine();
			for (int j = 0; j < M; j++) {
				chess[i][j] = String.valueOf(str.charAt(j));
			}
		}

		// 4중 for문
		for (int i = 0; i < N - 7; i++) {
			for (int j = 0; j < M - 7; j++) {
				find(i, j);
			}
		}

		System.out.println(min);
	}

	public static void find(int n, int m) {
		// 시작점 to 시작점 + 8
		int count = 0;

		int start = n + 8;
		int end = m + 8;

		String first = chess[n][m];

		for (int i = n; i < start; i++) {
			for (int j = m; j < end; j++) {
				if ((i + j) % 2 == 0) { // 색이 같아야하는 경우
					if (!chess[i][j].equals(first)) {
						count++;
					}
				} else {
					if (chess[i][j].equals(first)) {
						count++;
					}
				}
			}
		}

		count = Math.min(count, 64 - count);
		min = Math.min(min, count);
	}

}
