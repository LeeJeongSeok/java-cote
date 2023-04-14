package me.jeongseok.cote.programmers.level1;

import java.util.HashMap;

/**
 * 프로그래머스 - 레벨1 - 추억 점수
 */

public class MemoryScore {

	public int[] solution(String[] name, int[] yearning, String[][] photo) {
		int[] answer = new int[photo.length];
		HashMap<String, Integer> map = new HashMap<>();

		for (int i = 0; i < name.length; i++) {
			map.put(name[i], yearning[i]);
		}

		for (int i = 0; i < photo.length; i++) {
			for (int j = 0; j < photo[i].length; j++) {
				if (map.containsKey(photo[i][j])) {
					answer[i] += map.get(photo[i][j]);
				}
			}
		}
		return answer;
	}

	public static void main(String[] args) {
//		new MemoryScore().solution(new String[]{"may", "kein", "kain", "radi"}, new int[]{5, 10, 1, 3}, new String[][]{{"may", "kein", "kain", "radi"}, {"may", "kein", "brin", "deny"}, {"kon", "kain", "may", "coni"}});
		new MemoryScore().solution(new String[]{"may", "kein", "kain", "radi"}, new int[]{5, 10, 1, 3}, new String[][]{{"may"}, {"kein", "deny", "may"}, {"kon", "coni"}});
	}

}
