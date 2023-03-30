package me.jeongseok.cote.programmers.level1;

/**
 * 프로그래머스 - 레벨1 - 최대공약수와 최소공배수
 */
public class GcdAndLcm {

	// 유클리드 호제법을 사용해서 재귀적으로 최대공약수를 구하는 메소드
	public int gcm(int a, int b) {
		if (a % b == 0) {
			return b;
		}

		return gcm(b, a % b);
	}

	public int[] solution(int n, int m) {
		int[] answer = new int[2];

		int gcm = gcm(n, m);

		answer[0] = gcm;
		answer[1] = gcm * (n / gcm) * (m / gcm);

		return answer;
	}

	public static void main(String[] args) {

	}

}
