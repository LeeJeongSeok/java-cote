package me.jeongseok.cote.pt_practice;

import java.io.*;
import java.util.*;
public class _15686_ {

	static int N, M, result;
	static int[][] city;
	static boolean[] visited;
	static ArrayList<Pair> chickenHome, home;

	static final int EMPTY_HOME = 0;
	static final int HOME = 1;
	static final int CHICKEN_HOME = 2;

	public static void main(String[] args) throws Exception{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());

		N = Integer.parseInt(st.nextToken());
		M = Integer.parseInt(st.nextToken());
		city = new int[N][N];
		chickenHome = new ArrayList<>();
		home = new ArrayList<>();
		result = Integer.MAX_VALUE;

		for (int i = 0; i < N; i++) {
			st = new StringTokenizer(br.readLine());
			for (int j = 0; j < N; j++) {
				city[i][j] = Integer.parseInt(st.nextToken());
				if (city[i][j] == HOME) {
					home.add(new Pair(i, j));
				} else if (city[i][j] == CHICKEN_HOME) {
					chickenHome.add(new Pair(i, j));
				}
			}
		}

		visited = new boolean[chickenHome.size()];

		destoryChickenHome(0, 0);

		System.out.println(result);
	}

	// 도시에 있는 치킨집 중에서 최대 M개를 고르고, 나머지 치킨집은 모두 폐업시켜야 한다. (제대로 반영안되어있음)
	private static void destoryChickenHome(int start, int count) {
		if (count == M) {
			// M개 만큼 폐업을 완료하면 치킨거리를 구한다.
			int total = 0;

			for (int i = 0; i < home.size(); i++) {
				int temp = Integer.MAX_VALUE;
				for (int j = 0; j < chickenHome.size(); j++) {
					if (visited[j]) {
						temp = Math.min(temp, Math.abs(home.get(i).x - chickenHome.get(j).x) + Math.abs(home.get(i).y - chickenHome.get(j).y));
					}
				}
				total += temp;
			}
			result = Math.min(result, total);
		} else {
			for (int i = start; i < chickenHome.size(); i++) {
				visited[i] = true;
				destoryChickenHome(i + 1, count + 1);
				visited[i] = false;
			}
		}
	}
}
