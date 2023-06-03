package me.jeongseok.cote.dp;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class _1932_ {

	private void init(BufferedReader br) throws IOException {
		int N = Integer.parseInt(br.readLine());

		int[][] intTriangle = new int[N][N];
		int[][] dpTriangle = new int[N][N];

		for (int i = 0; i < N; i++) {
			StringTokenizer st = new StringTokenizer(br.readLine(), " ");
			for (int j = 0; j <= i; j++) {
				intTriangle[i][j] = Integer.parseInt(st.nextToken());
			}
		}

		startDP(N, intTriangle, dpTriangle);
	}

	private void startDP(int N, int[][] intTriangle, int[][] dpTriangle) {
		dpTriangle[0][0] = intTriangle[0][0];

		for (int i = 1; i < N; i++) {
			dpTriangle[i][0] = dpTriangle[i - 1][0] + intTriangle[i][0];
			dpTriangle[i][i] = dpTriangle[i - 1][i - 1] + intTriangle[i][i];
			for (int j = 1; j < i; j++) {
				dpTriangle[i][j] = Math.max(dpTriangle[i - 1][j - 1], dpTriangle[i - 1][j]) + intTriangle[i][j];
			}
		}

		printMaxValue(N, dpTriangle);
	}

	private void printMaxValue(int N, int[][] dpTriangle) {
		int max = -1;
		for (int i = 0; i < N; i++) {
			max = Math.max(dpTriangle[N - 1][i], max);
		}

		System.out.println(max);
	}

	public static void main(String[] args) throws IOException {
		new _1932_().init(new BufferedReader(new InputStreamReader(System.in)));
	}

}
