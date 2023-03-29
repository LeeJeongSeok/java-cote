package me.jeongseok.cote.programmers.level1;

public class WatermelonIteration {

	public String solution(int n) {
		StringBuilder sb = new StringBuilder();

		for (int i = 1; i <= n; i++) {
			sb.append((i % 2 == 1) ? "수" : "박");
		}
		return sb.toString();
	}

	public static void main(String[] args) {
		System.out.println(new WatermelonIteration().solution(3));
		System.out.println(new WatermelonIteration().solution(4));
	}

}
