package me.jeongseok.cote.greedy;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class BOJ_1541 {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

		String[] divideMinus = br.readLine().split("-");
		int sum = 0;

		for (int i = 0; i < divideMinus.length; i++) {
			int temp = 0;
			String[] dividePlus = divideMinus[i].split("\\+");
			for (int j = 0; j < dividePlus.length; j++) {
				temp += Integer.parseInt(dividePlus[j]);
			}

			// 첫번째는 양수이기 때문에 더해줘야함
			if (i == 0) {
				sum += temp;
			} else {
				sum -= temp;
			}
		}

		System.out.println(sum);
	}

}
