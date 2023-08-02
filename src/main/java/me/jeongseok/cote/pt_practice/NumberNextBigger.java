package me.jeongseok.cote.pt_practice;

public class NumberNextBigger {

	public int solution(int n) {
		int answer = n + 1;

		while (true) {
			if (Integer.bitCount(n) == Integer.bitCount(answer)) {
				break;
			}
			answer++;
		}

		return answer;
	}

	public static void main(String[] args) {
		System.out.println(new NumberNextBigger().solution(78));
		System.out.println(new NumberNextBigger().solution(15));
	}

}
