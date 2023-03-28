package me.jeongseok.cote.programmers.level1;

/**
 * 프로그래머스 레벨1 - 월간 코드 첼린지 시즌3 -> 나머지가 1이 되는 수 찾기
 */
public class FindOne {

	public int solution(int n) {
		int answer = 0;
		for (int i = 2; i <= n; i++) {
			if (n % i == 1) {
				answer = i;
				break;
			}
		}

		return answer;
	}

	public static void main(String[] args) {
		FindOne findOne = new FindOne();
		System.out.println(findOne.solution(3));
		System.out.println(findOne.solution(10));
		System.out.println(findOne.solution(12));
		System.out.println(findOne.solution(15)); // 2
		System.out.println(findOne.solution(50)); // 7
	}

}
