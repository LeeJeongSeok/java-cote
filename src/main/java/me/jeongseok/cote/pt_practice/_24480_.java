package me.jeongseok.cote.pt_practice;

/**
 * 깊이 우선 탐색 1 과 다 똑같지만 정점 번호를 내림차순으로 방문한다.
 */

import java.io.*;
import java.util.*;

public class _24480_ {

	static int N, M, R, idx;
	static ArrayList<Integer> graph[];
	static boolean visited[];
	static int result[];

	public static void main(String[] args) throws Exception{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());

		N = Integer.parseInt(st.nextToken());
		M = Integer.parseInt(st.nextToken());
		R = Integer.parseInt(st.nextToken());

		graph = new ArrayList[N + 1];
		visited = new boolean[N + 1];
		result = new int[N + 1];

		for (int i = 1; i <= N; i++) {
			graph[i] = new ArrayList<>();
		}

		for (int i = 0; i < M; i++) {
			st = new StringTokenizer(br.readLine());

			int u = Integer.parseInt(st.nextToken());
			int v = Integer.parseInt(st.nextToken());

			graph[u].add(v);
			graph[v].add(u);
		}

		for (int i = 1; i <= N; i++) {
			graph[i].sort(Comparator.reverseOrder());
		}

		idx = 1;
		dfs(R);

		for (int i = 1; i <= N; i++) {
			System.out.println(result[i]);
		}
	}

	private static void dfs(int node) {
		visited[node] = true;

		result[node] = idx;
		idx++;

		for (Integer next : graph[node]) {
			if (!visited[next]) {
				dfs(next);
			}
		}
	}

}
