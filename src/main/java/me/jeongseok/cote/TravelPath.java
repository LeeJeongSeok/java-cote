package me.jeongseok.cote;

import java.util.*;

public class TravelPath {

	static boolean[] visited;

	public String[] solution(String[][] tickets) {
		String[] answer = {};

		// 같은 경로가 있을 수 있으니 정렬 먼저, 알파벳 기준 오름차순 정렬
		Arrays.sort(tickets, (str1, str2) -> {
			if(str1[0].equals(str2[0])){
				return str1[1].compareTo(str2[1]);
			} else{
				return str1[0].compareTo(str2[0]);
			}
		});


		// visited 배열 생성
		boolean[] visited = new boolean[tickets.length];
		Stack<String> stack = new Stack();


		for (int i = 0; i < tickets.length; i++) {

			if (visited[i]) {
				continue;
			}

			stack.push(tickets[i][0]);
			visited[i] = true;

			while (!stack.isEmpty()) {
				String cur = stack.pop();

				for (int j = 0; j < tickets[i].length; j++) {

					if (visited[j]) {
						continue;
					}

					visited[j] = true;
					stack.push(tickets[i][j]);
				}
			}
		}
		return answer;
	}

	public static void main(String[] args) {

	}

}
