package me.jeongseok.cote.fastcampus.bruteforce_easy;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class BOJ_15651 {

	static int N, M;
	static int[] selected;
	static StringBuilder sb = new StringBuilder();

	static void rec_func(int k) {
		if (k == M + 1) { // 다 골랐다
			for (int i = 1; i <= M; i++) {
				sb.append(selected[i]).append(" ");
			}
			sb.append("\n");
		} else {
			for (int cand = 1; cand <= N; cand++) {
				// k 번째에 cand 가 올 수 있으면
				selected[k] = cand;

				// k+1 번부터 M 번까지 잘 채워주는 함수를 호출해준다.
				rec_func(k + 1);
				selected[k] = 0;
			}
		}
	}

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());

		N = Integer.parseInt(st.nextToken());
		M = Integer.parseInt(st.nextToken());

		selected = new int[M + 1];

		rec_func(1);
		System.out.println(sb.toString());

	}

}
