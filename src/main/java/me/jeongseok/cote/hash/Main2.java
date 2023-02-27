package me.jeongseok.cote.hash;

import java.util.ArrayList;
import java.util.HashMap;

/**
 * 프로그래머스 - 해시 - 베스트 앨범
 */
public class Main2 {


	/**
	 * genre : new int[2]
	 * classic 장르만 먼저 구해보자
	 * classic[500, 150, 800] -> 가장 큰 값을 먼저 찾고, 인덱스 번호를 가진다
	 * 그 다음 큰 값을 찾고, 인덱스 번호를 가진다. -> 이때 클래식 장르의 대응되는 크기가 2인 1차원 배열을 선언한다.
	 */

	public static int[] solution(String[] genres, int[] plays) {
		HashMap<String, Integer> map = new HashMap<>();
		for (int i = 0; i < genres.length; i++) {
			map.put(genres[i], map.getOrDefault(genres[i], 0) + plays[i]);
		}

		// 장르 선별
		ArrayList<Integer> list = new ArrayList<>();
		int max = Integer.MIN_VALUE;
		for (String key : map.keySet()) {
			if (map.get(key) > max) {

			}
		}

		return new int[4];
	}

	public static void main(String[] args) {
		System.out.println(solution(new String[]{"classic", "pop", "classic", "classic", "pop"}, new int[]{500, 600, 150, 800, 2500}));
	}

}
