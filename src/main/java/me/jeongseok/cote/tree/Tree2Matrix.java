package me.jeongseok.cote.tree;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

/**
 * @author Gwon Minha
 *
 * 이차원 배열로 구현한 트리의 전위, 중위, 후위 순회 결과 출력 프로그램
 * 2차원 배열 [x][0] -> 노드x의 왼쪽 자식
[x][1] -> 노드x의 오른쪽 자식값을 저장하는 방식으로 트리 입력 받음

입력 : 첫 번째 줄에 트리의 노드 개수 n이 주어진다. ( 1 ≤ n ≤ 100 )
두 번째 줄부터 트리의 정보가 주어진다. 각 줄은 3개의 숫자 a, b, c로 이루어지며,
그 의미는 노드 a의 왼쪽 자식노드가 b, 오른쪽 자식노드가 c라는 뜻이다.
자식노드가 존재하지 않을 경우에는 -1이 주어진다.

출력 : 첫 번째 줄에 전위순회, 두 번째 줄에 중위순회, 세 번째 줄에 후위순회를 한 결과를 출력한다.

예제 :

6
1 2 3
2 4 5
3 -1 6
4 -1 -1
5 -1 -1
6 -1 -1

		 1
		/ \
       2   3
      / \   \
     4   5   6
 */

public class Tree2Matrix {

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int n = Integer.parseInt(br.readLine());

	}

}
