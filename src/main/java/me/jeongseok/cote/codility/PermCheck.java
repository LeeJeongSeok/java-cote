package me.jeongseok.cote.codility;

import java.util.Arrays;

public class PermCheck {

	static public int solution(int[] A) {
		// Implement your solution here

		Arrays.sort(A);

		for (int i = 0; i < A.length; i++) {
			if (A[i] != i + 1) {
				return 0;
			}
		}

		return 1;
	}

	public static void main(String[] args) {
		System.out.println(solution(new int[]{4, 1, 3, 2}));
		System.out.println(solution(new int[]{4, 1, 3}));
	}

}
