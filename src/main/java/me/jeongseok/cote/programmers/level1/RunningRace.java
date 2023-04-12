package me.jeongseok.cote.programmers.level1;

import java.util.HashMap;

/**
 * 프로그래머스 - 레벨1 - 달리기 경주
 */
public class RunningRace {

	public void swapRunner(HashMap<String, Integer> map, String calledPlayer) {

	}

	public String[] solution(String[] players, String[] callings) {
		String[] answer = new String[players.length];

		HashMap<String, Integer> mappedByPlayer = new HashMap<>();
		HashMap<Integer, String> mappedByRank = new HashMap<>();

		// 각각의 맵을 초기화
		for (int i = 0; i < players.length; i++) {
			mappedByPlayer.put(players[i], i);
			mappedByRank.put(i, players[i]);
		}

		for (int i = 0; i < callings.length; i++) {

			// 추월한 유저 순위
			// 추월한 유저 이름
			int currentRank = mappedByPlayer.get(callings[i]);
			String player = mappedByRank.get(currentRank);

			// 바로 앞 플레이어
			String frontPlayer = mappedByRank.get(currentRank - 1);

			// swap
			mappedByPlayer.put(player, currentRank - 1);
			mappedByPlayer.put(frontPlayer, currentRank);

			mappedByRank.put(currentRank - 1, player);
			mappedByRank.put(currentRank, frontPlayer);
		}

		for (int i = 0; i < players.length; i++) {
			answer[i] = mappedByRank.get(i);
		}

		return answer;
	}
	public static void main(String[] args) {
		new RunningRace().solution(new String[]{"mumu", "soe", "poe", "kai", "mine"}, new String[]{"kai", "kai", "mine", "mine"});
	}

}
