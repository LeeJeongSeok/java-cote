package me.jeongseok.cote;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Comparator;
import java.util.PriorityQueue;
import java.util.StringTokenizer;

class Node {
	int v;
	int cost;

	public Node(int v, int cost) {
		this.v = v;
		this.cost = cost;
	}
}

public class Test {

	static ArrayList<Node>[] graph;
	static int[] dist;
	static boolean[] visited;

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());

		int V = Integer.parseInt(st.nextToken());
		int E = Integer.parseInt(st.nextToken());
		int K = Integer.parseInt(br.readLine());

		graph = new ArrayList[V + 1];
		dist = new int[V + 1];
		visited = new boolean[V + 1];

		for (int i = 1; i <= V; i++) {
			graph[i] = new ArrayList<>();
			dist[i] = Integer.MAX_VALUE; //최대값으로 초기화, 최단거리를 찾기 위함.
		}

		for (int i = 0; i < E; i++) {
			st = new StringTokenizer(br.readLine());

			int u = Integer.parseInt(st.nextToken());
			int v = Integer.parseInt(st.nextToken());
			int w = Integer.parseInt(st.nextToken());

			graph[u].add(new Node(v, w));
		}

		dijkstra(K);

		for (int i = 1; i <= V; i++) {
			if (dist[i] == Integer.MAX_VALUE) {
				System.out.println("INF");
			} else {
				System.out.println(dist[i]);
			}
		}
	}

	private static void dijkstra(int start) {
		PriorityQueue<Node> pq = new PriorityQueue<>(Comparator.comparingInt(o -> o.cost));

		pq.add(new Node(start, 0));
		dist[start] = 0;

		while (!pq.isEmpty()) {
			Node current = pq.poll();

			if (!visited[current.v]) {
				visited[current.v] = true;
			}

			for (Node next : graph[current.v]) {
				if (!visited[next.v] && dist[next.v] > next.cost + current.cost) {
					dist[next.v] = next.cost + current.cost;
					pq.add(new Node(next.v, dist[next.v]));
				}
			}
		}
	}

}
