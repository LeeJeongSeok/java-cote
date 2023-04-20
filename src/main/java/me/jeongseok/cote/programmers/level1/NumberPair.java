package me.jeongseok.cote.programmers.level1;

/**
 * 프로그래머스 - 레벨1 - 숫자 짝궁
 */
public class NumberPair {

	public String solution(String X, String Y) {
		StringBuilder sb = new StringBuilder();

		int[] xArr = new int[10];
		int[] yArr = new int[10];

		for (int i = 0; i < X.length(); i++) {
			int element = Integer.parseInt(String.valueOf(X.charAt(i)));
			xArr[element] += 1;
		}

		for (int i = 0; i < Y.length(); i++) {
			int element = Integer.parseInt(String.valueOf(Y.charAt(i)));
			yArr[element] += 1;
		}

		for (int i = 0; i < 10; i++) {
			while (true) {
				if ((xArr[i] == 0 && yArr[i] == 0) || (xArr[i] == 0 && yArr[i] >= 1) || (xArr[i] >= 1 && yArr[i] == 0)) {
					break;
				}
				sb.append(i);
				xArr[i] -= 1;
				yArr[i] -= 1;
			}
		}

		if (sb.toString().equals("")) {
			return "-1";
		} else {
			String answer = sb.reverse().toString();

			if (answer.startsWith("0")) {
				return "0";
			} else {
				return answer;
			}
		}
	}

	public static void main(String[] args) {
		System.out.println(new NumberPair().solution("3403", "13203"));
		System.out.println(new NumberPair().solution("5525", "1255"));
		System.out.println(new NumberPair().solution("100", "2345"));
		System.out.println(new NumberPair().solution("100", "203045"));
	}
}
