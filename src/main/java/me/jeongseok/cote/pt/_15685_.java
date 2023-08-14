package me.jeongseok.cote.pt;

import java.io.*;
import java.util.*;
public class _15685_ {

	static int N;
	static int[] dx = {1, 0, -1, 0};
	static int[] dy = {0, -1, 0, 1};
//	static int[] dx = {1, 0, -1, 0};
//	static int[] dy = {0, 1, 0, -1};
	static boolean[][] visited = new boolean[101][101];
	static int answer = 0;

	public static void main(String[] args) throws Exception{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		N = Integer.parseInt(br.readLine());

		for (int i = 0; i < N; i++) {
			StringTokenizer st = new StringTokenizer(br.readLine());
			int x = Integer.parseInt(st.nextToken());
			int y = Integer.parseInt(st.nextToken());
			int d = Integer.parseInt(st.nextToken());
			int g = Integer.parseInt(st.nextToken());

			// 드래곤 커브의 정보가 주어질 때마다, 드래곤 커브를 그려야한다.
			dragonCurve(x, y, d, g);
		}

		// 정사각형의 네 꼭짓점이 모두 드래곤 커브의 일부인지 확인
		for (int i = 0; i < 100; i++) {
			for (int j = 0; j < 100; j++) {
				if(visited[i][j] && visited[i][j+1] && visited[i+1][j] && visited[i+1][j+1]){
					answer++;
				}
			}
		}

		System.out.println(answer);

	}

	/**
	 * 3
	 * 3 3 0 1
	 * 4 2 1 3
	 * 4 2 2 1
	 */
	private static void dragonCurve(int x, int y, int d, int g) {
		// 0세대부터 방향을 구해야함
		ArrayList<Integer> list = new ArrayList<>();
		list.add(d); // n세대가 들어와도 무조건 0세대부터 시작해야함

		for (int i = 1; i <= g; i++) {
			for (int j = list.size() - 1; j >= 0 ; j--) {
				list.add((list.get(j) + 1) % 4);
			}
		}

		// 구한 방향순으로 선분을 그려야함
		visited[y][x] = true;
		for (int i = 0; i < list.size(); i++) {
			x += dx[list.get(i)];
			y += dy[list.get(i)];
			visited[y][x] = true;
		}
	}

}
