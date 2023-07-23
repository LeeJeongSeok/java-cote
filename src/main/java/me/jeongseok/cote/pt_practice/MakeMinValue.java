package me.jeongseok.cote.pt_practice;

import java.util.*;

public class MakeMinValue {

	public int solution(int []A, int []B) {
		Arrays.sort(A);
		Integer[] integerArray = Arrays.stream(B).boxed().toArray(Integer[]::new);
		Arrays.sort(integerArray, Collections.reverseOrder());

		int sum = 0;

		for (int i = 0; i < A.length; i++) {
			sum += A[i] * integerArray[i];
		}

		return sum;
	}

	public static void main(String[] args) {

	}

}
