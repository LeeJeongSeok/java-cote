package me.jeongseok.cote.programmers.level1;

import java.util.Arrays;
import java.util.List;
import java.util.Objects;

public class CardDeck {

	public String solution(String[] cards1, String[] cards2, String[] goal) {
		String answer = "YES";

		List<String> list1 = Arrays.asList(cards1);
		List<String> list2 = Arrays.asList(cards2);

		int list1Idx = 0;
		int list2Idx = 0;

		for (int i = 0; i < goal.length; i++) {
			if (list1.contains(goal[i])) {
				if (!Objects.equals(list1.get(list1Idx), goal[i])) {
					answer = "NO";
					break;
				} else {
					list1Idx++;
				}
			}

			if (list2.contains(goal[i])) {
				if (!Objects.equals(list2.get(list2Idx), goal[i])) {
					answer = "NO";
					break;
				} else {
					list2Idx++;
				}
			}
		}

		return answer;
	}

	public static void main(String[] args) {
		System.out.println(new CardDeck().solution(new String[]{"i", "drink", "water"}, new String[]{"want", "to"}, new String[]{"i", "want", "to", "drink", "water"}));
//		new CardDeck().solution(new String[]{"i", "water", "drink"}, new String[]{"want", "to"}, new String[]{"i", "want", "to", "drink", "water"});
	}

}
