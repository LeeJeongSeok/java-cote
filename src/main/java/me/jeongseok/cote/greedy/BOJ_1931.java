package me.jeongseok.cote.greedy;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

/**
 * 11
 * 1 4
 * 3 5
 * 0 6
 * 5 7
 * 3 8
 * 5 9
 * 6 10
 * 8 11
 * 8 12
 * 2 13
 * 12 14
 */
public class BOJ_1931 {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

		int n = Integer.parseInt(br.readLine());

		int[][] times = new int[n][2];
		int count = 0;


		for (int i = 0; i < n; i++) {
			StringTokenizer st = new StringTokenizer(br.readLine());
			times[i][0] = Integer.parseInt(st.nextToken());
			times[i][1] = Integer.parseInt(st.nextToken());
		}

		// 끝나는 시간을 기준으로 정렬
		Arrays.sort(times, (o1, o2) -> {
			// 종료시간이 같은 경우 시작시간이 빠른 순으로 정렬
			if (o1[1] == o2[1]) {
				return o1[0] - o2[0];
			}

			return o1[1] - o2[1];
		});

		int before = 0;

		for (int i = 0; i < n; i++) {
			// 바로 전에 종료된 회의 시간이 앞으로 시작될 회의 시작 시간보다 작다면 업데이트
			if (before <= times[i][0]) {
				before = times[i][1];
				count++;
			}
		}

		System.out.println(count);

	}

}
