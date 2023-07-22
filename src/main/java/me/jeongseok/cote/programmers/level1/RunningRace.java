package me.jeongseok.cote.programmers.level1;

import java.util.HashMap;

/**
 * 프로그래머스 - 레벨1 - 달리기 경주
 */
public class RunningRace {

	public String[] solution(String[] players, String[] callings) {
		String[] answer = new String[players.length];

		HashMap<String, Integer> map = new HashMap<>();

		// 맵에 데이터 초기화
		for (int i = 0; i < players.length; i++) {
			map.put(players[i], i);
		}

		for (int i = 0; i < callings.length; i++) {

		}


		return answer;
	}
	public static void main(String[] args) {
		new RunningRace().solution(new String[]{"mumu", "soe", "poe", "kai", "mine"}, new String[]{"kai", "kai", "mine", "mine"});
	}

}
