package me.jeongseok.cote.programmers.level1;

/**
 * 프로그래머스 - 레벨1 - 달리기 경주
 */
public class RunningRace {

	public int findRunner(String[] players, String callName) {
		int idx = 0;

		for (int i = 0; i < players.length; i++) {
			if (callName.equals(players[i])) {
				idx = i;
			}
		}

		return idx;
	}

	public void swapRunner(String[] players, int idx) {
		String temp = players[idx - 1];
		players[idx - 1] = players[idx];
		players[idx] = temp;
	}

	public String[] solution(String[] players, String[] callings) {
		String[] answer = new String[players.length];

		System.arraycopy(players, 0, answer, 0, players.length);

		// calling의 배열 길이만큼 순회
		for (int i = 0; i < callings.length; i++) {
			int idx = findRunner(answer, callings[i]);
			swapRunner(answer, idx);
		}

		return answer;
	}
	public static void main(String[] args) {
		new RunningRace().solution(new String[]{"mumu", "soe", "poe", "kai", "mine"}, new String[]{"kai", "kai", "mine", "mine"});
	}

}
