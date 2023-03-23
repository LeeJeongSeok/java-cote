package me.jeongseok.cote.programmers.level2;

/**
 *     * X 가 O 보다 많을 경우
 *     * O 가 X 보다 2개 이상 많을 경우
 *     * O가 완성되었을 때 X가 O와 같은 경우
 *     * X가 완성되었을 때 O가 X보다 1개 많은 경우
 */
public class TicTacTo {

	static int OCount = 0;
	static int XCount = 0;

	static void getCount(String[] board) {
		for (int i = 0; i < board.length; i++) {
			for (int j = 0; j < board[i].length(); j++) {
				if (board[i].charAt(j) == 'O') {
					OCount++;
				} else if (board[i].charAt(j) == 'X') {
					XCount++;
				}
			}
		}
	}

	static boolean breakRuleOfCount() {

		if (XCount > OCount) {
			return false;
		}

		if (OCount - XCount >= 2) {
			return false;
		}

		return true;
	}

	static boolean breakRuleOfComplete(String[] board, char word) {
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


	static int solution(String[] board) {
		int answer = -1;

		// O, X의 갯수를 먼저 파악
		getCount(board);

		// 갯수를 기준으로 규칙을 어긴 케이스 판별
		if (breakRuleOfCount()) {
			answer = 1;
		} else {
			answer = 0;
		}

		// 완성된 경우 규칙을 어긴 케이스 판별
		if (breakRuleOfComplete(board, 'O')) {
			if (OCount == XCount) {
				answer = 0;
			}
		}

		if (breakRuleOfComplete(board, 'X')) {
			if (Math.abs(OCount - XCount) >= 1) {
				answer = 0;
			}
		}

		return answer;
	}

	public static void main(String[] args) {
		System.out.println(solution(new String[]{"O.X", ".O.", "..X"}));
		System.out.println(solution(new String[]{"OOO", "...", "XXX"}));
		System.out.println(solution(new String[]{"...", ".X.", "..."}));
		System.out.println(solution(new String[]{"...", "...", "..."}));
	}
}
