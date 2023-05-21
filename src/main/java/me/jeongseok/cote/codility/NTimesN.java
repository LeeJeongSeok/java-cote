package me.jeongseok.cote.codility;

import java.util.*;

public class NTimesN {

	static public int solution(int[] A) {
		// Implement your solution here

		HashMap<Integer, Integer> map = new HashMap();
		ArrayList<Integer> list = new ArrayList();

		// 빈도수 체크 후 map 삽입
		for (int i = 0; i < A.length; i++) {
			map.put(A[i], map.getOrDefault(A[i], 0) + 1);
		}

		// 정수 X와 빈도수와 동일한 값만 뽑는다.
		for (Integer key : map.keySet()) {
			if (key == map.get(key)) {
				list.add(key);
			}
		}

		Collections.sort(list);

		if (list.size() == 0) {
			return 0;
		}

		return list.get(list.size() - 1);
	}

	public static void main(String[] args) {
		System.out.println(solution(new int[]{3, 8, 2, 3, 3, 2}));
		System.out.println(solution(new int[]{7, 1, 2, 8, 2}));
		System.out.println(solution(new int[]{3, 1, 4, 1, 5}));
		System.out.println(solution(new int[]{5, 5, 5, 5, 5}));
		System.out.println(51 % 10);

		int a = 51;
		int answer = 0;

		while(a > 0){
			answer += a % 10;
			a /= 10;
		}
		System.out.println(answer);


	}

}
