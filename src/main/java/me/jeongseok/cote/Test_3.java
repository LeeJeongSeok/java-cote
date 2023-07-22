package me.jeongseok.cote;

import java.io.*;
import java.util.*;

/**
 * 5 6
 * 1
 * 5 1 1
 * 1 2 2
 * 1 3 3
 * 2 3 4
 * 2 4 5
 * 3 4 6
 *
 * 동작과정
 *
 *  1. 출발 노드를 설정
 *  2. 최단 거리 테이블 초기화
 *  3. 방문하지 않은 노드 중에서 최단 거리(가중치)가 가장 짧은 노드 선택
 *  4. 해당 노드를 거쳐 다른 노드로 가는 비용을 계산하여 최단 거리 테이블 갱신
 *  5. 위 과정에서 3, 4번 반복
 */

public class Test_3 {

	static int[][] graph;
	static int[] dist;
	static boolean[] visited;

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());

		int V = Integer.parseInt(st.nextToken());
		int E = Integer.parseInt(st.nextToken());
		int K = Integer.parseInt(br.readLine());

		graph = new int[V + 1][V + 1];
		dist = new int[V + 1];
		visited = new boolean[V + 1];

		for (int i = 1; i <= V; i++) {
			dist[i] = Integer.MAX_VALUE;
		}

		for (int i = 0; i < E; i++) {
			st = new StringTokenizer(br.readLine());

			int u = Integer.parseInt(st.nextToken());
			int v = Integer.parseInt(st.nextToken());
			int w = Integer.parseInt(st.nextToken());

			graph[u][v] = w;
		}

		for (int i = 1; i <= V; i++) {
			for (int j = 1; j <= V; j++) {
				System.out.print(graph[i][j] + " ");
			}
			System.out.println();
		}
	}
}
