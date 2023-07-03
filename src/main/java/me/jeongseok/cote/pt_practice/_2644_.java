package me.jeongseok.cote.pt_practice;

/**
 * 입력으로 주어진 두 사람의 촌수를 계산해야함
 * 아빠 형제들과 나의 사이가 3촌이면 반대로 나와 아빠 형제들의 사이는 3촌으로 동일하다. 그렇기 떄문에 주어진 두 사람의 촌수는 순서와 상관없다. (양방향)
 *
 * 1. 주어진 입력 값들을 다 저장한다.
 * 2. dfs 탐색을 실시한다. 이때 파라미터 값으로 찾으려는 두 사람의 노드번호를 넣는다.
 * 3. dfs 탐색을 할 때마다 촌수를 하나씩 늘려준다
 * 4. 그 다음 촌수로 넘어왔을 때 찾으려는 두 사람의 관계가 같다면 촌수를 출력한다.
 *
 */

import java.util.*;
import java.io.*;

public class _2644_ {

	// 촌수를 계산해야 하는 두 사람은 a, b로 칭하고, 나머지 변수들은 문제에 나와있는대로 지정함
	// 추가적으로 촌수를 하나씩 늘릴 count 변수 선언
	static int n, a, b, m, x, y, answer;
	static ArrayList<Integer> graph[];
	static int dist[];
	static boolean visited[];

	public static void main(String[] args) throws Exception{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

		n = Integer.parseInt(br.readLine());

		StringTokenizer st = new StringTokenizer(br.readLine());
		a = Integer.parseInt(st.nextToken());
		b = Integer.parseInt(st.nextToken());

		m = Integer.parseInt(br.readLine());

		graph = new ArrayList[n + 1];
		visited = new boolean[n + 1];
		dist = new int[n + 1];
		answer = -1;

		for (int i = 1; i <= n; i++) {
			graph[i] = new ArrayList<>();
		}

		for (int i = 0; i < m; i++) {
			st = new StringTokenizer(br.readLine());
			x = Integer.parseInt(st.nextToken());
			y = Integer.parseInt(st.nextToken());

			graph[x].add(y);
			graph[y].add(x);
		}

		dfs(a, 0);

		System.out.println(answer);
	}

	// 거리를 계산할 땐 매개변수로 depth 값을 넘겨주고
	// 방문한 순서를 매길 땐, 전역변수로 두자.
	private static void dfs(int node, int cnt) {
		visited[node] = true;

		for (Integer next : graph[node]) {
			if (!visited[next]) {
				if (next == b) {
					answer = cnt + 1;
					return;
				}
				dfs(next, cnt + 1);
			}
		}
	}
}
