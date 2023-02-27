package me.jeongseok.cote.hash;

import java.util.HashMap;
import java.util.Map;
import java.util.Map.Entry;

/**
 * 프로그래머스 - 해시 - 위장
 */

public class Main {
	public static int solution(String[][] clothes) {
		Map<String, Integer> map = new HashMap<>();

		// 종류별 구분
		for (String[] clothe : clothes) {
			String category = clothe[1];
			map.put(category, map.getOrDefault(category, 0) + 1);
		}

		int answer = 1;
		// 모든 조합 계산하기
		for (Entry<String, Integer> cloth : map.entrySet()) {
			// 옷을 입는 경우 + 옷을 안입는 경우
			answer *= cloth.getValue() + 1;
		}

		// 하지만 무조건 아예 안입을 수 없음
		return answer - 1;
	}

	public static void main(String[] args) {
		System.out.println(solution(new String[][]{{"yellow_hat", "headgear"}, {"blue_sunglasses", "eyewear"}, {"green_turban", "headgear"}}));
	}

}
