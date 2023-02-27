package me.jeongseok.cote.boj;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.StringTokenizer;

class Person {
	int x;
	int y;

	public Person(int x, int y) {
		this.x = x;
		this.y = y;
	}
}
public class BOJ_7568 {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

		int n = Integer.parseInt(br.readLine());
		int[] rankArr = new int[n];
		ArrayList<Person> list = new ArrayList<>();

		for (int i = 0; i < n; i++) {
			StringTokenizer st = new StringTokenizer(br.readLine(), " ");
			int x = Integer.parseInt(st.nextToken());
			int y = Integer.parseInt(st.nextToken());

			list.add(new Person(x, y));
			rankArr[i] = 1; // 랭크 배열 초기화
		}

		// 순위 구하는 알고리즘
		for (int i = 0; i < list.size(); i++) {
			rankArr[i] = 1;
			for (int j = 0; j < list.size(); j++) {
				if (i == j) {
					continue;
				}

				if (list.get(i).x < list.get(j).x && list.get(i).y < list.get(j).y) {
					rankArr[i]++;
				}
			}
		}

		for (int i = 0; i < rankArr.length; i++) {
			System.out.print(rankArr[i] + " ");
		}
	}

}
