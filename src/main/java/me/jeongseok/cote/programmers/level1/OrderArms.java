package me.jeongseok.cote.programmers.level1;

/**
 * 프로그래머스 - 레벨1 - 기사단원의 무기
 */
public class OrderArms {

	public int getDivisorCount(int number) {
		int count = 0;
		for (int i = 1; i * i <= number; i++) {
			if (i * i == number) {
				count++;
			} else if (number % i == 0) {
				count += 2;
			}
		}
		return count;
	}

	public int solution(int number, int limit, int power) {
		int answer = 0;

		for (int i = 1; i <= number; i++) {

			int count = getDivisorCount(i);

			if (count <= limit) {
				answer += count;
			} else {
				answer += power;
			}
		}

		return answer;
	}
	public static void main(String[] args) {
//		System.out.println(new OrderArms().solution(5, 3, 2));
		System.out.println(new OrderArms().solution(10, 3, 2));
	}

}
