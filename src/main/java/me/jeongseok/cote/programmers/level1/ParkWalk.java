package me.jeongseok.cote.programmers.level1;

/**
 * 프로그래머스 - 레벨1 - 공원 산책
 */
public class ParkWalk {

	public int[] solution(String[] park, String[] routes) {
		int[] answer = new int[2];

//		int[] dx = new int[]{1, 0, -1, 0};
//		int[] dy = new int[]{0, 1, 0, -1};

		int curX = 0;
		int curY = 0;

		String[][] parkMap = new String[park.length][park[0].length()];

		// 입력으로 들어온 park 배열을 2차원 맵으로 초기화
		// 동시에 시작점의 좌표를 기록함
		for (int i = 0; i < park.length; i++) {
			for (int j = 0; j < park[i].length(); j++) {
				parkMap[i][j] = String.valueOf(park[i].charAt(j));

				if (String.valueOf(park[i].charAt(j)).equals("S")) {
					curX = j;
					curY = i;
				}
			}
		}

		// rotate 배열을 읽는다.
		for (int i = 0; i < routes.length; i++) {
			String[] commands = routes[i].split(" ");

			if (commands[0].equals("E")) {
				// 공원 범위를 벗어나는지 체크, 장애물이 있는지 체크
				boolean isTrue = true;

				for (int j = 1; j <= Integer.parseInt(commands[1]); j++) {
					int nx = curX + j;

					if (nx < 0 || nx >= park[0].length() || parkMap[curY][nx].equals("X")) {
						isTrue = false;
						break;
					}
				}

				if (isTrue) {
					curX += Integer.parseInt(commands[1]);
				}



			} else if (commands[0].equals("W")) {

				boolean isTrue = true;

				for (int j = 1; j <= Integer.parseInt(commands[1]); j++) {
					int nx = curX - j;

					if (nx < 0 || nx >= park[0].length() || parkMap[curY][nx].equals("X")) {
						isTrue = false;
						break;
					}
				}

				if (isTrue) {
					curX -= Integer.parseInt(commands[1]);
				}

			} else if (commands[0].equals("N")) {

				boolean isTrue = true;

				for (int j = 1; j <= Integer.parseInt(commands[1]); j++) {
					int ny = curY - j;

					if (ny < 0 || ny >= park.length || parkMap[ny][curX].equals("X")) {
						isTrue = false;
						break;
					}
				}

				if (isTrue) {
					curY -= Integer.parseInt(commands[1]);
				}


			} else if (commands[0].equals("S")) {

				boolean isTrue = true;

				for (int j = 1; j <= Integer.parseInt(commands[1]); j++) {
					int ny = curY + j;

					if (ny < 0 || ny >= park.length || parkMap[ny][curX].equals("X")) {
						isTrue = false;
						break;
					}
				}

				if (isTrue) {
					curY += Integer.parseInt(commands[1]);
				}
			}
		}

		answer[0] = curY;
		answer[1] = curX;

		return answer;
	}

	public static void main(String[] args) {
//		new ParkWalk().solution(new String[]{"SOO","OOO","OOO"}, new String[]{"E 2","S 2","W 1"});
//		new ParkWalk().solution(new String[]{"SOO","OXX","OOO"}, new String[]{"E 2","S 2","W 1"});
		new ParkWalk().solution(new String[]{"OSO","OOO","OXO","OOO"}, new String[]{"E 2","S 3","W 1"});
	}

}
