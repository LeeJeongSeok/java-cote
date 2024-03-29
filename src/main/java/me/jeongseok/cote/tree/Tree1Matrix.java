package me.jeongseok.cote.tree;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;

/**
 *
 *
 * 루트가 1인 완전 이진 트리, 포화 이진 트리를 1차원 배열에 저장후 각 인덱스의 부모 노드를 출력하는 프로그램
	입력 : 첫 번째 줄에 트리의 노드 개수 n이 주어진다.
	출력 : 각 인덱스의 부모 노드를 출력한다.
	예제 :  6

           1
		 /   \
		2     3
       / \   /
      3   4 5

 * 포화 이진 트리이거나 완전 이진 트리이기 때문에 1차원 배열 n+1만큼 번호 순서대로 저장하면된다. (0부터라면 n까지만)
 */

public class Tree1Matrix {

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int n = Integer.parseInt(br.readLine());
		int[] parent = new int[n + 1];

		for (int i = 2; i <= n; i++) {
			parent[i] = i / 2;
		}

		System.out.println(Arrays.toString(parent));
	}

}
