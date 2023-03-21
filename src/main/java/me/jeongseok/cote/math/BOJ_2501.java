package me.jeongseok.cote.math;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class BOJ_2501 {

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine(), " ");

		int N = Integer.parseInt(st.nextToken());
		int K = Integer.parseInt(st.nextToken());

		int count = 0;
		int[] array = new int[N + 1];

		// 1. 약수의 갯수 구하기
		// 만약 약수라면 array 배열의 약수 값이 들어가고, 그렇지 않으면 -1이 들어감
		for (int i = 1; i <= N; i++) {
			if (N % i == 0) {
				array[i] = i;
				count++;
			} else {
				array[i] = -1;
			}
		}

		// 2. 만약 count가 K보다 작으면 0을 리턴
		if (count < K) {
			System.out.println(0);
			System.exit(0);

		}

		// 3. array 탐색하면서 K번째 값 리턴 (반레 5 2)
		int answer = 0;
		int findIdx = 0;
		for (int i = 1; i <= N; i++) {
			if (array[i] != -1) {
				answer++;
				findIdx = i;
			}

			if (answer == K) {
				System.out.println(array[findIdx]);
				System.exit(0);
			}
		}
	}

}
