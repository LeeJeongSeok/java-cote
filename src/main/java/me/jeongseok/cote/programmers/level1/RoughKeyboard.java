package me.jeongseok.cote.programmers.level1;

/**
 * 프로그래머스 - 레벨1 - 대충 만든 자판
 */
public class RoughKeyboard {
	public int[] solution(String[] keymap, String[] targets) {
		int[] answer = new int[targets.length];

		// target의 원소를 하나씩 순회
		for (int i = 0; i < targets.length; i++) {
			int count = 0;

			// target[i] 번쨰의 원소를 하나씩 순회
			for (int j = 0; j < targets[i].length(); j++) {
				char c = targets[i].charAt(j);

				int min = Integer.MAX_VALUE;


				// keymap의 원소를 하나씩 순회
				for (int k = 0; k < keymap.length; k++) {

					// keymap[k]번째의 있는 원소와 변수 c의 대입된 문자가 있는 keymap을 찾는다.
					if (keymap[k].contains(String.valueOf(c))) {
						// 있다면 keymap[k] 번째의 원소를 하나씩 탐색하면서 변수 c의 대입된 문자의 위치를 찾는다.
						for (int l = 0; l < keymap[k].length(); l++) {
							if (keymap[k].charAt(l) == c) {
								if (l < min) {
									min = l;
								}
							}
						}
					}
				}

				if (min == Integer.MAX_VALUE) {
					count = -1;
					break;
				} else {
					count += min + 1;
				}

			}
			answer[i] = count;
		}
		return answer;
	}

	public static void main(String[] args) {
//		new RoughKeyboard().solution(new String[]{"ABACD", "BCEFD"}, new String[]{"AABB"});
//		new RoughKeyboard().solution(new String[]{"AA"}, new String[]{"B"});
		new RoughKeyboard().solution(new String[]{"ABCE"}, new String[]{"ABDE"});
	}
}
