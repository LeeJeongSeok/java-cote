package me.jeongseok.cote.programmers.level1;

/**
 * 프로그래머스 - 레벨1 - 가장 가까운 글자
 */
public class ClosestMatchingChar {

	public int[] solution(String s) {
		int[] answer = new int[s.length()];

		// 맨 끝 문자부터 순차적으로 탐색
		for (int i = s.length() - 1; i >= 0; i--) {

			// 동일한 문자가 나올 경우 위치값을 반환
			int idx = Integer.MAX_VALUE;

			// 현재 몇번째 진행중인지 저장하는 변수
			int count = 0;

			// 2중 for문을 만들어 i번째 문자부터 순차적으로 전체 탐색을 진행한다.
			for (int j = i - 1; j >= 0; j--) {
				// 루프를 돌때마다 카운트 증가
				count++;

				// 만약 동일한 문자가 나올 경우 idx와 count 값 중 작은 값으로 idx를 치환
				// 동일한 문자가 여러번 나온 경우에도 마찬가지로 idx와 count 값 중 작은 값으로 idx를 치환
				if (s.charAt(i) == s.charAt(j)) {
					idx = Math.min(idx, count);
				}
			}


			// 안쪽 for문을 다 돌았음에도 MAX_VALUE와 동일하다면 동일한 문자가 없기 때문에 -1
			if (idx == Integer.MAX_VALUE) {
				answer[i] = -1;
			} else {
				answer[i] = idx;
			}
		}
		return answer;
	}

	public static void main(String[] args) {

	}
}
