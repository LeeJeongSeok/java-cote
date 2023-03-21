package me.jeongseok.cote.array;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class BOJ_10798 {

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();
		String[][] input = new String[5][15];

		// String 자료형을 초기화없이 선언해버리면 디폴트 값인 null로 초기화되기 때문에 맨 처음 빈 문자열로 초기화 작업해줘야함
		for (int i = 0; i < 5; i++) {
			for (int j = 0; j < 15; j++) {
				input[i][j] = "";
			}
		}

		for (int i = 0; i < 5; i++) {
			String[] line = br.readLine().split("");
			for (int j = 0; j < line.length; j++) {
				input[i][j] = line[j];
			}
		}

		for (int j = 0; j < 15; j++) {
			for (int i = 0; i < 5; i++) {
				sb.append(input[i][j]);
			}
		}

		System.out.println(sb.toString().trim());
	}

}
