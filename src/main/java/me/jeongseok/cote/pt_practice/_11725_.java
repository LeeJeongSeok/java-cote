package me.jeongseok.cote.pt_practice;

import java.io.*;
import java.util.*;
public class _11725_ {

	static int N;
	static ArrayList<Integer> graph[];
	static boolean visited[];
	static int result[];

	public static void main(String[] args) throws Exception{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

		N = Integer.parseInt(br.readLine());

		graph = new ArrayList[N + 1];
		visited = new boolean[N + 1];
		result = new int[N + 1];

		for (int i = 1; i <= N; i++) {
			graph[i] = new ArrayList<>();
		}

		for (int i = 0; i < N - 1; i++) {
			StringTokenizer st = new StringTokenizer(br.readLine());

			int a = Integer.parseInt(st.nextToken());
			int b = Integer.parseInt(st.nextToken());

			graph[a].add(b);
			graph[b].add(a);
		}

		dfs(1);

		for (int i = 2; i <= N; i++) {
			System.out.println(result[i]);
		}
	}

	private static void dfs(int node) {
		visited[node] = true;

		for (Integer next : graph[node]) {
			if (!visited[next]) {
				result[next] = node;
				dfs(next);
			}
		}
	}
}
