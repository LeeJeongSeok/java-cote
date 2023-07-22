package me.jeongseok.cote.dfs_2;

import java.util.LinkedList;
import java.util.Queue;

public class Test {
	static boolean visit[];
	static Queue<Integer> que = new LinkedList<>();

	static public int solution(int n, int[][] computers) {
		int answer = 0;
		visit = new boolean[n];

		for(int i=0; i<n; i++) {
			if(visit[i] == false) {

				BFS(i, computers, n);
				answer++;
			}
		}

		return answer;
	} // End of main

	static void BFS(int i, int computers[][], int n) {
		que.offer(i);
		visit[i] = true;

		while( !que.isEmpty() ) {
			int value = que.poll();

			for(int j=0; j<n; j++) {
				if(visit[j] == false && computers[value][j] == 1) {
					visit[j] = true;
					que.offer(j);
				}
			}

		}

	} // End of

	public static void main(String[] args) {
		System.out.println(solution(3, new int[][]{{1, 1, 0}, {1, 1, 0}, {0, 0, 1}}));
	}

}
