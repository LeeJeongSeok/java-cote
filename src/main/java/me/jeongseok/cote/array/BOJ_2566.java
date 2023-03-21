package me.jeongseok.cote.array;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class BOJ_2566 {

	static StringBuilder sb = new StringBuilder();
	static int max = Integer.MIN_VALUE;
	static int x, y;

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

		int[][] array = new int[9][9];

		for (int i = 0; i < 9; i++) {
			StringTokenizer st = new StringTokenizer(br.readLine(), " ");
			for (int j = 0; j < 9; j++) {
				array[i][j] = Integer.parseInt(st.nextToken());
				// 입력과 동시에 최대 값, 좌표 값 구하기
				if (array[i][j] > max) {
					max = array[i][j];
					x = i;
					y = j;
				}
			}
		}

		sb.append(max).append("\n");
		sb.append(x + 1).append(" ").append(y + 1); // 문제에선 1행부터 시작하기 때문에 마지막에 1를 더해줘야함

		System.out.println(sb.toString());
	}

}
