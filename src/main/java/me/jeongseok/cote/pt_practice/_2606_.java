package me.jeongseok.cote.pt_practice;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.StringTokenizer;

/**
 * 한 컴퓨터가 웜 바이러스에 걸리면 그 컴퓨터와 네트워크 상에 연결되어 있는 모든 컴퓨터는 웜 바이러스에 걸림
 * 네트워크에 연결되어 있지 않은 컴퓨터는 웜 바이러스에 걸리지 않는다.
 *
 * 1번 컴퓨터가 웜 바이러스에 걸렸다.
 * 1번 컴퓨터를 통해 웜 바이러스에 걸리게 되는 컴퓨터의 수를 출력하는 프로그램을 만들자
 *
 * 입력으로 주어지는 값은 첫줄에 컴퓨터 수와 두번째 줄에는 네트워크 상에서 직접 연결되어 있는 컴퓨터의 쌍의 수가 나타난다. (즉 간선 정보인듯하다)
 * 이어서 컴퓨터 쌍의 수 만큼 네트워크 상에서 연결되어 있는 컴퓨터 쌍의 번호들이 주어진다.
 *
 * 입력정보를 다 받고, 그래프를 그린 후, dfs 탐색을 통해 문제의 결과를 도출해보자
 */
public class _2606_ {

	private static int computers, result;
	private static int pair;
	private static ArrayList<Integer> graph[];
	private static boolean visited[];
	public static void main(String[] args) throws Exception{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

		computers = Integer.parseInt(br.readLine());
		pair = Integer.parseInt(br.readLine());
		graph = new ArrayList[computers + 1];
		visited = new boolean[computers + 1];

		for (int i = 1; i <= computers; i++) {
			graph[i] = new ArrayList<>();
		}

		for (int i = 0; i < pair; i++) {
			StringTokenizer st = new StringTokenizer(br.readLine());

			int a = Integer.parseInt(st.nextToken());
			int b = Integer.parseInt(st.nextToken());

			graph[a].add(b);
			graph[b].add(a);
		}

		dfs(1);

		System.out.println(result);
	}

	private static void dfs(int node) {
		visited[node] = true;

		for (int i = 0; i < graph[node].size(); i++) {
			int next = graph[node].get(i);
			if (!visited[next]) {
				result++;
				dfs(next);
			}
		}
	}
}
