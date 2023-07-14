package me.jeongseok.cote.pt;

import java.io.*;
import java.util.*;

public class _1987_ {

	static int R, C, max;
	static int dx[];
	static int dy[];
	static int alphabet[];
	static char board[][];


	public static void main(String[] args) throws Exception{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());

		R = Integer.parseInt(st.nextToken());
		C = Integer.parseInt(st.nextToken());

		board = new char[R][C];
		alphabet = new int[26];
		dx = new int[]{1, 0, -1, 0};
		dy = new int[]{0, 1, 0, -1};

		for (int i = 0; i < R; i++) {
			char[] charArray = br.readLine().toCharArray();
			for (int j = 0; j < charArray.length; j++) {
				board[i][j] = charArray[j];
			}
		}

		alphabet[board[0][0] - 65] = 1;
		dfs(0, 0, 1);


		System.out.println(max);
	}

	private static void dfs(int x, int y, int count) {
		for (int i = 0; i < 4; i++) {
			int nx = x + dx[i];
			int ny = y + dy[i];

			if (nx < 0 || nx >= R || ny < 0 || ny >= C || alphabet[board[nx][ny] - 65] == 1) {
				continue;
			}

			alphabet[board[nx][ny] - 65] = 1;
			dfs(nx, ny, count + 1);
			alphabet[board[nx][ny] - 65] = 0;
		}

		max = Math.max(max, count);
	}
}
