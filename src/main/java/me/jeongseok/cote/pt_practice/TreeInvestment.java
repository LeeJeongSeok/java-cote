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

	static int N, M, K;
	static int[][] map, food;
	static int[] dx;
	static int[] dy;
	static List<Tree> trees;

	public static void main(String[] args) throws Exception{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());

		N = Integer.parseInt(st.nextToken());
		M = Integer.parseInt(st.nextToken());
		K = Integer.parseInt(st.nextToken());

		map = new int[N][N];
		food = new int[N][N];
		dx = new int[]{-1, -1, -1, 0, 0, 1, 1, 1};
		dy = new int[]{-1, 0, 1, -1, 1, -1, 0, 1};
		trees = new ArrayList<>();

		for (int i = 0; i < N; i++) {
			st = new StringTokenizer(br.readLine());
			for (int j = 0; j < N; j++) {
				map[i][j] = 5;
				food[i][j] = Integer.parseInt(st.nextToken());
			}
		}

		for (int i = 0; i < M; i++) {
			st = new StringTokenizer(br.readLine());
			int x = Integer.parseInt(st.nextToken()) - 1;
			int y = Integer.parseInt(st.nextToken()) - 1;
			int age = Integer.parseInt(st.nextToken());

			trees.add(new Tree(x, y, age));
		}

		// 봄, 여름, 가을, 겨울 시작
		while (K-- > 0) {

			Collections.sort(trees);

			ArrayList<Tree> deadTrees = new ArrayList<>();
			ArrayList<Tree> liveTrees = new ArrayList<>();


			// 봄
			for (int i = 0; i < trees.size(); i++) {
				Tree curTree = trees.get(i);

				// 양분보다 나이가 적을 경우
				if (curTree.age <= map[curTree.x][curTree.y]) {
					map[curTree.x][curTree.y] -= curTree.age;
					curTree.age++;
					liveTrees.add(new Tree(curTree.x, curTree.y, curTree.age));
				} else { // 양분보다 나이가 큰 경우 죽은 나무
					deadTrees.add(new Tree(curTree.x, curTree.y, curTree.age));
				}
			}

			// 여름
			for (int i = 0; i < deadTrees.size(); i++) {
				Tree deadTree = deadTrees.get(i);

				int x = deadTree.x;
				int y = deadTree.y;
				int age = deadTree.age;

				map[x][y] += (age / 2);
			}

			// 가을
			int size = liveTrees.size();
			for (int i = 0; i < size; i++) {
				Tree liveTree = liveTrees.get(i);

				if (liveTree.age % 5 == 0) {
					for (int j = 0; j < 8; j++) {
						int nx = liveTree.x + dx[j];
						int ny = liveTree.y + dy[j];

						if (nx < 0 || nx >= N || ny < 0 || ny >= N) {
							continue;
						}

						liveTrees.add(new Tree(nx, ny, 1));
					}
				}
			}

			// 겨울
			for (int i = 0; i < N; i++) {
				for (int j = 0; j < N; j++) {
					map[i][j] += food[i][j];
				}
			}

			trees = liveTrees;
		}

		System.out.println(trees.size());
	}

}
