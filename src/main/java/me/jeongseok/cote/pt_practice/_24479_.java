package me.jeongseok.cote.pt_practice;

import java.io.*;
import java.util.*;

public class _24479_ {

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


		// 그래프 초기화
		for (int i = 1; i <= N; i++) {
			graph[i] = new ArrayList<>();
		}

		// 그래프 입력
		for (int i = 0; i < M; i++) {
			st = new StringTokenizer(br.readLine());

			int u = Integer.parseInt(st.nextToken());
			int v = Integer.parseInt(st.nextToken());

			// 양방향 간선 체크
			graph[u].add(v);
			graph[v].add(u);
		}

		// 오름차순 정렬
		for (int i = 1; i <= N; i++) {
			graph[i].sort(null);
		}

		idx = 1;
		dfs(R);

		// 결과 출력
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
