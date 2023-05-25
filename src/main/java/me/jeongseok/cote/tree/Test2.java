package me.jeongseok.cote.tree;

import java.util.Stack;

public class Test2 {

	public static void main(String[] args) {
		int n = 7;
		int[][] computers = new int[][]{{1, 0, 0, 0, 0, 0, 1}, {0, 1, 1, 0, 1, 0, 0}, {0, 1, 1, 1, 0, 0, 0}, {0, 0, 1, 1, 0, 0, 0}, {0, 1, 0, 0, 1, 1, 0}, {0, 0, 0, 0, 1, 1, 1}, {1, 0, 0, 0, 0, 1, 1}};
		int answer = 0;

		boolean visited[] = new boolean[n];
		Stack<Integer> stack = new Stack<>();

		// 1번 정점부터 하나씩 탐방 시작
		for (int i = 0; i < n; i++) {

			if (visited[i]) {
				continue;
			}

			visited[i] = true;
			stack.push(i);
			answer++;

			while (!stack.isEmpty()) {
				int cur = stack.pop();

				// i번째에서 갈 수 있는 곳들은 모두 방문한다.
				// 만약 만나는 정점이 있다면 그 정점을 스택에 넣고 다시 탐색함
				// 그니까 만약에 A 정점에서 B에 갈 수 있다면 스택에 넣고
				// 스택에서 B지점에서부터 탐색한다는 이야기지
				// 한번 걸리면 존나탐색한다..
				for (int j = 0; j < n; j++) {
					if (computers[cur][j] == 1 && !visited[j]) {
						stack.push(j);
						visited[j] = true;
					}
				}
			}
		}

		System.out.println(answer);
	}

}
