package me.jeongseok.cote.programmers.level1;

import java.util.HashMap;

/**
 * 프로그래머스 - 레벨1 - 가장 가까운 같은 글자
 */
public class ClosestMatchingChar {

	public int[] solution(String s) {
		int[] answer = new int[s.length()];

		HashMap<Character,Integer> map = new HashMap<>();
		for(int i=0; i<s.length();i++){
			char ch = s.charAt(i);
			// map에 마지막으로 저장된 위치값과 현재 i 값을 뺀 값을 answer에 대입
			answer[i] = i-map.getOrDefault(ch,i+1);

			// 마지막으로 만난 문자열의 인덱스 값을 map에 업데이트
			map.put(ch,i);
		}

		return answer;
	}

	public static void main(String[] args) {
		new ClosestMatchingChar().solution("banana");

	}
}
