package me.jeongseok.cote.pt;

import java.io.*;
import java.util.*;

/**
 * 문제에서 요구하는 결과는? - 그래프를 DFS/BFS로 탐색한 결과를 출력
 * 주요한 조건은? - 방문할 수 있는 정점이 여러 개인 경우는 정점 번호가 작은 것을 먼저 방문한다.
 * 입력시 주의할 점? - 입력으로 주어지는 간선은 양방향이다.
 */
public class _1260_ {

	private static int N, M, V;
	private static ArrayList<Integer> graph[];
	private static boolean visited[];

	public static void main(String[] args) throws Exception{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());

		N = Integer.parseInt(st.nextToken());
		M = Integer.parseInt(st.nextToken());
		V = Integer.parseInt(st.nextToken());

		graph = new ArrayList[N + 1];
		visited = new boolean[N + 1];

		for (int i = 1; i <= N; i++) {
			graph[i] = new ArrayList<>();
		}

		for (int i = 0; i < M; i++) {
			st = new StringTokenizer(br.readLine());

			int a = Integer.parseInt(st.nextToken());
			int b = Integer.parseInt(st.nextToken());

			// 양방향 그래프 생성
			graph[a].add(b);
			graph[b].add(a);
		}

		// 정점 번호가 작은 순으로 정렬
		for (int i = 1; i <= N; i++) {
			graph[i].sort(null);
		}

		dfs(V);

		visited = new boolean[N + 1];
		System.out.println();

		dfsUsingStack(V);

		visited = new boolean[N + 1];
		System.out.println();

		bfs(V);
	}

	private static void dfs(int node) {
		// 1. 현재 방문한 노드에 대해 방문 표시를 남긴다.
		visited[node] = true;

		// 2. 현재 방문한 노드의 정점 번호를 출력한다.
		System.out.print(node + " ");

		// 3. 현재 방문한 노드와 연결되어 있는 노드들의 정보를 반복문으로 읽어온다.
		for (int i = 0; i < graph[node].size(); i++) {
			// 4. 그 다음 방문할 정점 번호를 받아온다.
			int next = graph[node].get(i);
			// 5. 다음 방문할 정점을 아직 탐색하지 않았다면 재귀 호출하면서 탐색한다.
			if (!visited[next]) {
				dfs(next);
			}
		}
	}

	private static void dfsUsingStack(int node) {
		Stack<Integer> stack = new Stack<>();
		stack.push(node);
		visited[node] = true;

		while (!stack.isEmpty()) {
			int now = stack.pop();

			System.out.print(now + " ");

			for (int i = 0; i < graph[now].size(); i++) {
				int next = graph[now].get(i);
				if (!visited[next]) {
					stack.push(next);
					visited[next] = true;
				}
			}
		}
	}

	private static void bfs(int node) {
		// 1. BFS 탐색을 위한 큐 자료구조를 선언한다.
		Queue<Integer> queue = new LinkedList<>();
		// 2. 현재 방문한 노드를 큐에 삽입한다.
		queue.add(node);
		// 3. 현재 방문한 노드에 대해 방문 표시를 남긴다.
		visited[node] = true;

		// 4. 만약 큐가 비어있지 않다면, 현재 큐에서 먼저 들어온 노드를 꺼낸다.
		// 9. 큐에 아무것도 없을떄까지 4 ~ 5번 과정을 반복한다.
		while (!queue.isEmpty()) {
			// 5. 큐에서 꺼낸 정점의 번호를 받아온 후, 출력한다.
			int now = queue.poll();
			System.out.print(now + " ");

			// 6. 큐에서 꺼낸 노드와 연결되어 있는 노드들의 정보를 반복문으로 읽어온다.
			for (int i = 0; i < graph[now].size(); i++) {
				// 7. 그 다음 방문할 노드의 번호를 받아온다.
				int next = graph[now].get(i);

				// 8. 다음 방문할 정점을 아직 탐색하지 않았다면, 큐에 탐색하지 않은 노드를 삽입하고, 방문 표시를 남긴다.
				if (!visited[next]) {
					queue.add(next);
					visited[next] = true;
				}
			}
		}
	}

}
