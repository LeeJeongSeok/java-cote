package me.jeongseok.cote.programmers.level2;

import java.util.Arrays;
import java.util.Map;
import java.util.function.Function;
import java.util.stream.Collectors;

/**
 *     * X 가 O 보다 많을 경우
 *     * O 가 X 보다 2개 이상 많을 경우
 *     * O가 완성되었을 때 X가 O와 같은 경우
 *     * X가 완성되었을 때 O가 X보다 1개 많은 경우
 */
public class TicTacTo {

	int OCount = 0;
	int XCount = 0;

	// 스트림으로 처리하면 2중 for가 필요없다.
	private void getCount(String[] board) {
		Map<Character, Long> collect = Arrays.stream(board)
			.flatMap(row -> row.chars()
				.mapToObj(word -> (char) word))
			.collect(Collectors.groupingBy(Function.identity(), Collectors.counting()));

		OCount = collect.getOrDefault('O', 0L).intValue();
		XCount = collect.getOrDefault('X', 0L).intValue();
	}

	// 갯수를 기준으로 규칙을 어긴 케이스 판별
	private boolean breakRuleOfCount() {

		// X가 O보다 많은 경우 또는 O가 X보다 2개 이상 많은 경우
		if (XCount > OCount || OCount - XCount >= 2) {
			return false;
		}

		return true;
	}

	private boolean breakRuleOfComplete(String[] board, char word) {
		// 가로 완성
		for (int i = 0; i < 3; i++) {
			if (board[i].charAt(0) == word && board[i].charAt(1) == word && board[i].charAt(2) == word) {
				return true;
			}
		}

		// 세로 완성
		for (int i = 0; i < 3; i++) {
			if (board[0].charAt(i) == word && board[1].charAt(i) == word && board[2].charAt(i) == word) {
				return true;
			}
		}

		// 좌->우 대각선 완성
		if (board[0].charAt(0) == word && board[1].charAt(1) == word && board[2].charAt(2) == word) {
			return true;
		}

		// 우->좌 대각선 완성
		if (board[0].charAt(2) == word && board[1].charAt(1) == word && board[2].charAt(0) == word) {
			return true;
		}

		return false;
	}


	public int solution(String[] board) {
		int answer = 1;

		// O, X의 갯수를 먼저 파악
		getCount(board);

		// 갯수를 기준으로 규칙을 어긴 케이스 판별
		if (!breakRuleOfCount()) {
			answer = 0;
		}

		boolean oWin = breakRuleOfComplete(board, 'O');
		boolean xWin = breakRuleOfComplete(board, 'X');

		// 둘다 빙고면 문제 있음
		if (oWin && xWin) {
			answer = 0;
		}

		// 둘 중 하나가 완성된 경우 규칙을 어긴 케이스 판별
		if (oWin && OCount == XCount || xWin && OCount > XCount) {
			answer = 0;
		}

		return answer;
	}

	public static void main(String[] args) {
//		System.out.println(solution(new String[]{"O.X", ".O.", "..X"}));
//		System.out.println(solution(new String[]{"OOO", "...", "XXX"}));
//		System.out.println(solution(new String[]{"...", ".X.", "..."}));
//		System.out.println(solution(new String[]{"...", "...", "..."}));




	}
}
