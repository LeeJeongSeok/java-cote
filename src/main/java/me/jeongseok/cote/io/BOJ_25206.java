package me.jeongseok.cote.io;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class BOJ_25206 {

	static String grades[] = {"A+", "A0", "B+", "B0", "C+", "C0", "D+", "D0", "F", "P"};
	static double scores[] = {4.5, 4.0, 3.5, 3.0, 2.5, 2.0, 1.5, 1.0, 0.0, 0.0};

	static double gradeSum = 0.0;
	static double scoreSum = 0.0;

	static double getGradeScore(String grade) {
		double gradeScore = 0.0;

		for (int i = 0; i < grades.length; i++) {
			if (grade.equals("P")) {
				break;
			}
			if (grade.equals(grades[i])) {
				gradeScore = scores[i];
			}
		}
		return gradeScore;
	}

	static double getScoreSum(String grade, Double score) {
		if (grade.equals("P")) {
			return 0.0;
		}
		return score;
	}
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));


		for (int i = 0; i < 20; i++) {
			StringTokenizer st = new StringTokenizer(br.readLine());
			String subject = st.nextToken();
			Double score = Double.parseDouble(st.nextToken());
			String grade = st.nextToken();

			gradeSum += score * getGradeScore(grade);
			scoreSum += getScoreSum(grade, score);
		}

		System.out.printf("%.6f\n", gradeSum / scoreSum);
	}

}
