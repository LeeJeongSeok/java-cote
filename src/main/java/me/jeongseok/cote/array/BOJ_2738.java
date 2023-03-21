package me.jeongseok.cote.array;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class BOJ_2738 {

	static int N, M;
	static int[][] input, answer;
	static StringBuilder sb = new StringBuilder();

	static void calculateMatrix() {
		for (int i = 0; i < N; i++) {
			for (int j = 0; j < M; j++) {
				answer[i][j] = input[i][j] + input[i + N][j];
			}
		}
	}

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine(), " ");

		N = Integer.parseInt(st.nextToken());
		M = Integer.parseInt(st.nextToken());

		input = new int[N * 2][M];
		answer = new int[N][M];

		// 입력
		for (int i = 0; i < N * 2; i++) {
			st = new StringTokenizer(br.readLine(), " ");
			for (int j = 0; j < M; j++) {
				input[i][j] = Integer.parseInt(st.nextToken());
			}
		}

		calculateMatrix();
		printAnswer();
	}

	static void printAnswer() {
		for (int i = 0; i < N; i++) {
			for (int j = 0; j < M; j++) {
				sb.append(answer[i][j]).append(" ");
			}
			sb.append("\n");
		}

		System.out.println(sb.toString());
	}

}
