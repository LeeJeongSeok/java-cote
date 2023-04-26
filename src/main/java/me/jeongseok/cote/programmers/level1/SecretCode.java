package me.jeongseok.cote.programmers.level1;

import java.util.Arrays;
import javax.management.StringValueExp;

public class SecretCode {

	public String solution(String s, String skip, int index) {
		String answer = "";

		for (int i = 0; i < s.length(); i++) {
			char c = s.charAt(i);
			int count = 1;

			while (count <= index) {
				c++;
				if (c > 'z') {
					c -= 26;
				}

				if (skip.contains(String.valueOf(c))) {
					continue;
				} else {
					count++;
				}
			}

			answer += c;
		}

		return answer;
	}

	public static void main(String[] args) {
		new SecretCode().solution("aukks", "wbqd", 5);
	}

}
