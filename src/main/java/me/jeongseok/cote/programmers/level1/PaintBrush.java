package me.jeongseok.cote.programmers.level1;

public class PaintBrush {

	public int solution(int n, int m, int[] section) {
		int answer = 0;
		int[] wall = new int[n + 1];
		int roller = 0;

		for (int i = 0; i < section.length; i++) {
			wall[section[i]] = 1;
		}

		for (int i = 1; i <= n; i++) {
			// 덧칠해야하는 경우
			if (wall[i] == 1) {
				// 벽을 벗어나는 경우
				if (i + m > n) {
					for (int j = i; j > i - m; j--) {
						wall[j] = 0;
					}
					answer++;
				} else {
					for (int j = i; j < i + m; j++) {
						wall[j] = 0;
					}
					answer++;
				}
			}
		}
		return answer;
	}

	public static void main(String[] args) {
		System.out.println(new PaintBrush().solution(8, 4, new int[]{2, 3, 6}));
		System.out.println(new PaintBrush().solution(5, 4, new int[]{1, 3}));
		System.out.println(new PaintBrush().solution(4, 1, new int[]{1, 2, 3, 4}));
//		System.out.println(202 % 8);
	}

}
