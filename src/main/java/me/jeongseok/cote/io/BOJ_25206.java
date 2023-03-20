package me.jeongseok.cote.io;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class BOJ_25206 {

	static String grades[] = {"A+", "A0", "B+", "B0", "C+", "C0", "D+", "D0", "F", "P"};
	static double scores[] = {4.5, 4.0, 3.5, 3.0, 2.5, 2.0, 1.5, 1.0, 0.0, 0.0};
	static double total = 0.0;
	static double sumScore = 0.0;
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

		for (int i = 0; i < 20; i++) {
			StringTokenizer st = new StringTokenizer(br.readLine(), " ");
			String subject = st.nextToken();
			double score = Double.parseDouble(st.nextToken());
			String grade = st.nextToken();

			for (int j = 0; j < 10; j++) {
				if (grade.equals(grades[j])) {
					total += scores[1] * scores[j];
					if (j != 9) {
						sumScore += score;
					}
				}
			}
		}

		System.out.printf("%.6f\n", total / sumScore);
	}

}
