package me.jeongseok.cote.pt_practice;

import java.util.*;
import java.io.*;

/**
 * 5 2 1
 * 2 3 2 3 2
 * 2 3 2 3 2
 * 2 3 2 3 2
 * 2 3 2 3 2
 * 2 3 2 3 2
 * 2 1 3
 * 3 2 3
 */

public class TreeInvestment {

	static int N, M, K, result;
	static int[][] map;
	static int[] dx;
	static int[] dy;
	static List<Tree> trees;

	public static void main(String[] args) throws Exception{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());

		N = Integer.parseInt(st.nextToken());
		M = Integer.parseInt(st.nextToken());
		K = Integer.parseInt(st.nextToken());

		map = new int[N + 1][N + 1];
		dx = new int[]{-1, -1, -1, 0, 0, 1, 1, 1};
		dy = new int[]{-1, 0, 1, -1, 1, -1, 0, 1};
		trees = new ArrayList<>();

		for (int i = 0; i < N; i++) {
			st = new StringTokenizer(br.readLine());
			for (int j = 0; j < N; j++) {
				map[i][j] = Integer.parseInt(st.nextToken());
			}
		}

		for (int i = 0; i < M; i++) {
			st = new StringTokenizer(br.readLine());
			int x = Integer.parseInt(st.nextToken());
			int y = Integer.parseInt(st.nextToken());
			int age = Integer.parseInt(st.nextToken());

			trees.add(new Tree(x, y, age));
		}

		Collections.sort(trees);

		while (K-- > 0) {


			for (int i = 0; i < trees.size(); i++) {
				Tree curTree = trees.get(i);
				int endTreeAge = 0;

				// 양분보다 나이가 적을 경우
				if (map[curTree.x][curTree.y] < curTree.age) {
					curTree.age++;
					map[curTree.x][curTree.y] -= curTree.age;
				} else { // 양분보다 나이가 큰 경우 죽은 나무
					map[curTree.x][curTree.y] += curTree.age;
					endTreeAge += curTree.age;
					curTree.age = 0;

				}

				// 죽은 나무의 나이에서 나누기 2를 한 후 몫만 현재 위치에 양분이 된다.
				map[curTree.x][curTree.y] = map[curTree.x][curTree.y] / 2;

				if (map[curTree.x][curTree.y] % 5 == 0) {
					for (int j = 0; j < 8; j++) {
						int nx = curTree.x + dx[i];
						int ny = curTree.y + dy[i];

						if (nx < 0 || nx > N || ny < 0 || ny > N) {
							continue;
						}

						trees.add(new Tree(nx, ny, 1));
					}
				}
			}

			// 겨울
			for (int i = 0; i < N; i++) {
				for (int j = 0; j < M; j++) {
					map[i][j] += map[i][j];
				}
			}
		}

		for (int i = 0; i < trees.size(); i++) {
			if (trees.get(i).age != 0) {
				result++;
			}
		}

		System.out.println(result);
	}

}
