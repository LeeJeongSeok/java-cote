package me.jeongseok.cote.codility;

import java.util.HashMap;

public class OddOccurrencesInArray {

	public static void main(String[] args) {
		int[] A = new int[]{9, 3, 9, 3, 9, 7, 9};

		int result = 0;
		HashMap<Integer, Integer> map = new HashMap<>();

		// 빈도수 체크
		for (int i = 0; i < A.length; i++) {
			map.put(A[i], map.getOrDefault(A[i], 0) + 1);
		}

		// 빈도수가 홀수인 경우에 key값을 바로 찾고 break;
		// 문제에서 A의 값 중 하나를 제외한 모든 값이 짝수로 발생합니다. 라고 나와있기 때문
		for (Integer key : map.keySet()) {
			if (map.get(key) % 2 == 1) {
				result = key;
				break;
			}
		}

		System.out.println(result);
	}
}
