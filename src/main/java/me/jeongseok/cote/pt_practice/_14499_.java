package me.jeongseok.cote.pt_practice;

import java.io.*;
import java.util.*;

public class _14499_ {

	static int N, M, x, y, K;
	static int[][] map;
	static int[] command;
	static int[] dice = new int[]{0, 0, 0, 0, 0, 0}; // 윗, 정면, 바닥, 뒷면, 왼쪽, 오른쪽
	static int[] dx = new int[]{1, 0, 0, -1}; // 남, 동, 서, 북
	static int[] dy = new int[]{0, 1, -1, 0};

	static ArrayList<Integer> result = new ArrayList<>();

	public static void main(String[] args) throws Exception{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());

		N = Integer.parseInt(st.nextToken());
		M = Integer.parseInt(st.nextToken());
		x = Integer.parseInt(st.nextToken());
		y = Integer.parseInt(st.nextToken());
		K = Integer.parseInt(st.nextToken());
		
		map = new int[N][K];
		command = new int[K];

		// 지도 값 입력
		for (int i = 0; i < N; i++) {
			String[] split = br.readLine().split(" ");
			for (int j = 0; j < split.length; j++) {
				map[i][j] = Integer.parseInt(split[j]);
			}
		}

		// 명령어 입력
		st = new StringTokenizer(br.readLine());
		for (int i = 0; i < K; i++) {
			command[i] = Integer.parseInt(st.nextToken());
		}

		playDice();
		printResult();
	}

	private static void playDice() {
		for (int i = 0; i < command.length; i++) {
			int direction = command[i] % 4;
			int nx = x + dx[direction];
			int ny = y + dy[direction];

			if (nx < 0 || nx >= N || ny < 0 || ny >= M) {
				continue;
			}

			switch (direction) {
				case 0: // 남
					int temp = dice[0];
					dice[0] = dice[3];
					dice[3] = dice[2];
					dice[2] = dice[1];
					dice[1] = temp;
					break;
				case 1: // 동
					temp = dice[0];
					dice[0] = dice[4];
					dice[4] = dice[2];
					dice[2] = dice[5];
					dice[5] = temp;
					break;
				case 2: // 서
					temp = dice[0];
					dice[0] = dice[5];
					dice[5] = dice[2];
					dice[2] = dice[4];
					dice[4] = temp;
					break;
				case 3: // 북
					temp = dice[0];
					dice[0] = dice[1];
					dice[1] = dice[2];
					dice[2] = dice[3];
					dice[3] = temp;
					break;
			}

			// 이동하는 칸이 0인 경우
			if (map[nx][ny] == 0) {
				// 주사위의 바닥면에 쓰인 수가 지도 칸에 복사 된다.
				map[nx][ny] = dice[2];
			} else { // 이동하는 칸이 0이 아닌 경우
				dice[2] = map[nx][ny];
				map[nx][ny] = 0;
			}

			x = nx;
			y = ny;
			result.add(dice[0]);
		}
	}

	private static void printResult() {
		for (int i = 0; i < result.size(); i++) {
			System.out.println(result.get(i));
		}
	}

}
