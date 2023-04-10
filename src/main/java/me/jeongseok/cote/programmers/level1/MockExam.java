package me.jeongseok.cote.programmers.level1;

import java.util.ArrayList;

public class MockExam {

	public int[] solution(int[] answers) {

		int[] first = {1,2,3,4,5}; // 5개씩 반복
		int[] second = {2,1,2,3,2,4,2,5}; // 8개씩 반복
		int[] third = {3,3,1,1,2,2,4,4,5,5}; // 10개 반복
		int[] answer = {0,0,0};

		for (int i = 0; i < answers.length; i++) {
			if (answers[i] == first[i % 5]) answer[0]++;
			if (answers[i] == second[i % 8]) answer[1]++;
			if (answers[i] == third[i % 10]) answer[2]++;
		}

		// 최대값 구하기
		int maxScore = Math.max(answer[0], Math.max(answer[1], answer[2]));

		// 최대 점수를 가지고 있는 학생들의 점수를 담기 위한 list
		// 만약 1명만이 최대 점수를 가지고 있다면 1명이 담기고, 그렇지않으면 여러개가 담긴다.
		ArrayList<Integer> list = new ArrayList<>();

		for (int i = 0; i < answer.length; i++) {
			// 최대값과 동일한 값이 있다면 list.add
			if (answer[i] == maxScore) {
				list.add(i + 1);
			}
		}

		return list.stream().mapToInt(i -> i).toArray();
	}

	public static void main(String[] args) {

		System.out.println(new MockExam().solution(new int[]{1, 2, 3, 4, 5}));
		System.out.println(new MockExam().solution(new int[]{1,3,2,4,2}));

	}

}
