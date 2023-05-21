package me.jeongseok.cote.codility;

import java.util.*;

public class AlternatingTree {

	static public boolean findUpAndDown(ArrayList<Integer> trees) {
		// true -> up, false -> down
		boolean status = false;

		int count = 0;

		for (int i = 0; i < trees.size() - 1; i++) {
			if (trees.get(i) < trees.get(i + 1) && !status) {
				count++;
				status = true;
			} else if (trees.get(i) > trees.get(i + 1) && status) {
				count--;
				status = false;
			} else {
				return false;
			}
		}

		// 미적으로 완성된 경우
		// 자른 배열의 갯수가 짝수 미적감각이 완성되면 1이 나오고, 홀수 갯수에선 0이 나온다.
		if (count == 1 || count == 0) {
			return true;
		} else {
			return false;
		}
	}

	static public int solution(int[] A) {
		// Implement your solution here

		ArrayList<Integer> list = new ArrayList();
		int cutCount = 0;

		for (int i = 0; i < A.length; i++) {
			list.add(A[i]);
		}

		// 나무가 4개인 경우는 별도로 자르지 않고 미적감각만 검사
		if (list.size() == 4) {
			for (int i = 0; i < list.size(); i++) {
				if (findUpAndDown(list)) {
					cutCount++;
				}
			}
		} else {
			for (int i = 0; i < list.size(); i++) {
				// 자르고
				int removeValue = list.remove(i);

				if (findUpAndDown(list)) {
					cutCount++;
				}

				// 원복
				list.add(i, removeValue);
			}
		}

		// 최종결과
		// cutCount가 0인 경우는 결국 findUpAndDown이 전부다 false
		// cutCount가 배열 A의 길이와 동일하다면 자르는 나무가 필요하지 않기 떄문에 0
		// 그 외는 잘라야 하는 경우의 수
		if (cutCount == 0) {
			return -1;
		} else if (cutCount == A.length) {
			return 0;
		} else {
			return cutCount;
		}
	}

	public static void main(String[] args) {
		System.out.println(solution(new int[]{3, 4, 5, 3, 7}));
		System.out.println(solution(new int[]{1, 2, 3, 4}));
		System.out.println(solution(new int[]{1, 3, 1, 2}));
	}

}
