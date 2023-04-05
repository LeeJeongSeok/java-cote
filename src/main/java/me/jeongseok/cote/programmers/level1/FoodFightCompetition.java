package me.jeongseok.cote.programmers.level1;

/**
 * 프로그래머스 - 레벨1 - 푸드 파이트 대회
 */
public class FoodFightCompetition {

	public String solution(int[] food) {

		StringBuilder sb = new StringBuilder();

		for (int i = 1; i < food.length; i++) {
			sb.append(String.valueOf(i).repeat(food[i] / 2));
		}

		return sb.toString() + "0" + sb.reverse().toString();
	}

	public static void main(String[] args) {

	}

}
