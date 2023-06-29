package me.jeongseok.cote.pt_practice;

import java.io.*;
import java.util.*;

public class _11724_ {

	static int N, M, result;
	static ArrayList<Integer> graph[];
	static boolean visited[];

	public static void main(String[] args) throws Exception{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());

		N = Integer.parseInt(st.nextToken());
		M = Integer.parseInt(st.nextToken());
		graph = new ArrayList[N + 1];
		visited = new boolean[N + 1];

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

		// 탐색이 가능한 노드들을 찾는다.
		for (int i = 1; i <= N; i++) {
			if (!visited[i]) {
				result++;

				for (int j = 0; j < graph[i].size(); j++) {
					dfs(graph[i].get(j));
				}
			}
		}

		System.out.println(result);
	}

	private static void dfs(int node) {
		visited[node] = true;

		for (int i = 0; i < graph[node].size(); i++) {
			int next = graph[node].get(i);
			if (!visited[next]) {
				dfs(next);
			}
		}
	}

}
