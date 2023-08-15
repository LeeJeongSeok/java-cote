package me.jeongseok.cote.pt_practice;

import java.io.*;
import java.util.*;
public class _15686_ {

	static int N, M, result;
	static int[][] city;
	static ArrayList<Pair> chickenHome;

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

//		if (countChickenHome() == M) {
//			saveChickenHome();
//			result = calculateChickenDistance();
//		} else {
//			destoryChickenHome(0);
//		}

		destoryChickenHome(0);

		System.out.println(result);
	}

	// 입력받은 도시맵에서 치킨집 수를 카운팅
	private static int countChickenHome() {
		int count = 0;

		for (int i = 0; i < N; i++) {
			for (int j = 0; j < N; j++) {
				if (city[i][j] == CHICKEN_HOME) {
					count++;
				}
			}
		}

		return count;
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
					if (city[i][j] == 2) {
						city[i][j] = 3;
						destoryChickenHome(count + 1);
						city[i][j] = 2;
					}
				}
			}
		}
	}

	// 남아 있는 치킨집의 좌표를 저장한다.
	private static void saveChickenHome() {
		chickenHome = new ArrayList<>();

		for (int i = 0; i < N; i++) {
			for (int j = 0; j < N; j++) {
				if (city[i][j] == LIVING_CHICKEN_HOME) {
					chickenHome.add(new Pair(i, j));
				}
			}
		}
	}

	private static int calculateChickenDistance() {

		int total = 0;

		for (int i = 0; i < N; i++) {
			for (int j = 0; j < N; j++) {
				if (city[i][j] == HOME) {
					int temp = Integer.MAX_VALUE;

					for (int k = 0; k < chickenHome.size(); k++) {
						temp = Math.min(temp, Math.abs(i - chickenHome.get(k).x) + Math.abs(j - chickenHome.get(k).y));
					}
					total += temp;
				}
			}
		}

		return total;
	}

}
