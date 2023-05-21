package me.jeongseok.cote.codility;

import java.util.*;
public class SameDigitSum {

	static public int digitSum(int n) {
		int sum = 0;

		while (n > 0) {
			sum += n % 10;
			n /= 10;
		}

		return sum;
	}

	static public int solution(int[] A) {
		// Implement your solution here

		Arrays.sort(A);

		HashMap<Integer, Integer> resultMap = new HashMap();
		HashMap<Integer, Integer> countMap = new HashMap();
		int max = Integer.MIN_VALUE;


		for (int i = A.length - 1; i >= 0; i--) {
			int key = digitSum(A[i]);

			if (countMap.get(key) == null) {
				resultMap.put(key, resultMap.getOrDefault(key, 0) + A[i]);
				countMap.put(key, 1);
			} else {
				if (countMap.get(key) != 2) {
					resultMap.put(key, resultMap.getOrDefault(key, 0) + A[i]);
					countMap.put(key, countMap.get(key) + 1);
				}
			}
		}

		// 정수 X와 빈도수와 동일한 값만 뽑는다.
		for (Integer key : resultMap.keySet()) {
			if (resultMap.get(key) > max) {
				max = resultMap.get(key);
			}
		}

		if (resultMap.size() == A.length) {
			return -1;
		}

		return max;
	}

	public static void main(String[] args) {
		System.out.println(solution(new int[]{51, 17, 71, 42}));
		System.out.println(solution(new int[]{42, 33, 60}));
		System.out.println(solution(new int[]{51, 32, 43}));
	}

}
