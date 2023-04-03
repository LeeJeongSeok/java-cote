package me.jeongseok.cote.programmers.level1;

public class MinimumRectangle {

	public int solution(int[][] sizes) {
		int answer = 0;

		int[][] temp = new int[sizes.length][sizes[0].length];

		for (int i = 0; i < sizes.length; i++) {
			temp[i][0] = Math.max(sizes[i][0], sizes[i][1]);
			temp[i][1] = Math.min(sizes[i][0], sizes[i][1]);
		}

		// i에 최대값과 j의 최대값을 구한다.
		int w = Integer.MIN_VALUE;
		int h = Integer.MIN_VALUE;
		for (int i = 0; i < temp.length; i++) {
			if (temp[i][0] > w) {
				w = temp[i][0];
			}
		}

		for (int i = 0; i < temp.length; i++) {
			if (temp[i][1] > h) {
				h = temp[i][1];
			}
		}
		return w * h;
	}

	public static void main(String[] args) {

	}

}
