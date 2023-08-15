package me.jeongseok.cote.pt_practice;

import java.io.*;
import java.util.*;
public class _15686_ {

	static int N, M, result;
	static int[][] city;
	static ArrayList<Pair> chickenHome, home;

	static final int EMPTY_HOME = 0;
	static final int HOME = 1;
	static final int CHICKEN_HOME = 2;
	static final int LIVING_CHICKEN_HOME = 3;

	public static void main(String[] args) throws Exception{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());

		N = Integer.parseInt(st.nextToken());
		M = Integer.parseInt(st.nextToken());
		city = new int[N][N];
		result = Integer.MAX_VALUE;

		for (int i = 0; i < N; i++) {
			st = new StringTokenizer(br.readLine());
			for (int j = 0; j < N; j++) {
				city[i][j] = Integer.parseInt(st.nextToken());
			}
		}

		destoryChickenHome(0);

		System.out.println(result);
	}

	// 도시에 있는 치킨집 중에서 최대 M개를 고르고, 나머지 치킨집은 모두 폐업시켜야 한다. (제대로 반영안되어있음)
	private static void destoryChickenHome(int count) {
		if (count == M) {
			// M개 만큼 폐업을 완료하면 치킨거리를 구한다.
			saveChickenHome();
			result = Math.min(result, calculateChickenDistance());
		} else {
			for (int i = 0; i < N; i++) {
				for (int j = 0; j < N; j++) {
					if (city[i][j] == CHICKEN_HOME) {
						city[i][j] = LIVING_CHICKEN_HOME;
						destoryChickenHome(count + 1);
						city[i][j] = CHICKEN_HOME;
					}
				}
			}
		}
	}

	// 남아 있는 치킨집의 좌표와 집의 좌표를 저장한다.
	private static void saveChickenHome() {
		chickenHome = new ArrayList<>();
		home = new ArrayList<>();

		for (int i = 0; i < N; i++) {
			for (int j = 0; j < N; j++) {
				if (city[i][j] == LIVING_CHICKEN_HOME) {
					chickenHome.add(new Pair(i, j));
				} else if (city[i][j] == HOME) {
					home.add(new Pair(i, j));
				}
			}
		}
	}

	private static int calculateChickenDistance() {

		int total = 0;

//		for (int i = 0; i < N; i++) {
//			for (int j = 0; j < N; j++) {
//				if (city[i][j] == HOME) {
//					int temp = Integer.MAX_VALUE;
//
//					for (int k = 0; k < chickenHome.size(); k++) {
//						temp = Math.min(temp, Math.abs(i - chickenHome.get(k).x) + Math.abs(j - chickenHome.get(k).y));
//					}
//					total += temp;
//				}
//			}
//		}

		// 한번 루프를 돌고나면 큐가 비어있기 때문에 그다음부터는 0이 출력됨
//		while (!queue.isEmpty()) {
//			Pair home = queue.poll();
//
//			int temp = Integer.MAX_VALUE;
//
//			for (int k = 0; k < chickenHome.size(); k++) {
//				temp = Math.min(temp, Math.abs(home.x - chickenHome.get(k).x) + Math.abs(home.y - chickenHome.get(k).y));
//			}
//
//			total += temp;
//		}



		for (int i = 0; i < home.size(); i++) {
			int temp = Integer.MAX_VALUE;
			for (int j = 0; j < chickenHome.size(); j++) {
				temp = Math.min(temp, Math.abs(home.get(i).x - chickenHome.get(j).x) + Math.abs(home.get(i).y - chickenHome.get(j).y));
			}
			total += temp;
		}



		return total;
	}

}
