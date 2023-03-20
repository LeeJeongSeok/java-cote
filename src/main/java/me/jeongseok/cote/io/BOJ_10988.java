package me.jeongseok.cote.io;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class BOJ_10988 {

	static boolean isTrue = true;

	static void isPalindrome(String input, int left, int right) {
		if (left > right) {
			return;
		} else {
			if (input.charAt(left) != input.charAt(right)) {
				isTrue = false;
			}
			isPalindrome(input, left + 1, right - 1);
		}
	}

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		String text = br.readLine();

		isPalindrome(text, 0, text.length() - 1);

		if (isTrue) {
			System.out.println(1);
		} else {
			System.out.println(0);
		}
	}

}
