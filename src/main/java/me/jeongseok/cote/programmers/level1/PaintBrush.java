package me.jeongseok.cote.programmers.level1;

public class PaintBrush {

	public int solution(int n, int m, int[] section) {
		int answer = 0;
		int rollerIdx = 0;

		for (int i = 0; i < section.length; i++) {
			if (section[i] > rollerIdx) {
				answer++;
				rollerIdx = section[i] + m - 1;
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
