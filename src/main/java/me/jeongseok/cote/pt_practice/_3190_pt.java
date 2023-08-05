package me.jeongseok.cote.pt_practice;

import java.io.*;
import java.util.*;

public class _3190_pt {
	// 사과 : 4, 뱀 : 0,1,2,3(방향에 따라), 빈 공간 : 5
	public static void main(String[] args) throws NumberFormatException, IOException {
		int[] dx = { 0, 1, 0, -1 }; // 시계방향
		int[] dy = { 1, 0, -1, 0 };
		int dir = 0;
		BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
		int N = Integer.parseInt(bf.readLine());
		int[][] board = new int[N][N]; // 보드
		int K = Integer.parseInt(bf.readLine());
		int appleindex1, appleindex2; // 사과 위치
		int time = 1; // 게임 시간
		int timeindex = 0;
		int x = 0, y = 0;
		for (int i = 0; i < board.length; i++) {
			for (int j = 0; j < board[i].length; j++) {
				board[i][j] = 5;
			}
		}
		board[x][y] = 0; // 뱀 처음 위치(오른쪽 방향)
		int length = 1; // 뱀길이

		for (int i = 0; i < K; i++) {
			StringTokenizer st = new StringTokenizer(bf.readLine());
			appleindex1 = Integer.parseInt(st.nextToken());
			appleindex2 = Integer.parseInt(st.nextToken());
			board[appleindex1 - 1][appleindex2 - 1] = 4;
		}
		int L = Integer.parseInt(bf.readLine());
		int[] Time = new int[L];
		char[] Dir = new char[L];
		for (int i = 0; i < L; i++) {
			StringTokenizer st = new StringTokenizer(bf.readLine());
			Time[i] = Integer.parseInt(st.nextToken());
			Dir[i] = st.nextToken().charAt(0);
		}

		while (true) {
			int idx = x + dx[dir];
			int idy = y + dy[dir];
			if (idx < 0 || idx >= N || idy < 0 || idy >= N) break;

			// 사과가 아닌 빈칸인 경우
			if (board[idx][idy] == 5) {
				board[idx][idy] = dir;
				int tempdir = (board[idx][idy] + 2) % 4;
				int temp1 = idx + dx[tempdir];
				int temp2 = idy + dy[tempdir];

				// 자기몸에 부딪히는 경우
				for (int i = 0; i < length-1; ++i) {
					tempdir = (board[temp1][temp2] + 2) % 4;
					temp1 += dx[tempdir];
					temp2 += dy[tempdir];
					if (i == length - 2)
						board[temp1][temp2] = 5;
				}

				if(length == 1) board[temp1][temp2] = 5;
			}

			// 사과를 먹는 경우
			else if (board[idx][idy] == 4) {
				board[idx][idy] = dir;
				length++;
			}
			else break;
			x += dx[dir];
			y += dy[dir];
			if (Time[timeindex] == time) {
				if (Dir[timeindex] == 'L') dir = (dir + 3) % 4;
				else dir = (dir + 1) % 4;
				if(timeindex < Time.length - 1) timeindex++;
			}
			time++;
		}
		System.out.println(time);

	}


}
