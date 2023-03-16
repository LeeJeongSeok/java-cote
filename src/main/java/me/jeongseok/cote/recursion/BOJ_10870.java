package me.jeongseok.cote.recursion;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class BOJ_10870 {

	static StringBuilder sb = new StringBuilder();
	static int count = 0;

	static int isPalindrome(String word, int left, int right) {
		count++;
		if (left >= right) {
			return 1;
		} else if (word.charAt(left) != word.charAt(right)) {
			return 0;
		} else {
			return isPalindrome(word, left + 1, right - 1);
		}
	}

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int n = Integer.parseInt(br.readLine());

		for (int i = 0; i < n; i++) {
			String text = br.readLine();
			int palindrome = isPalindrome(text, 0, text.length() - 1);
			sb.append(palindrome).append(" ").append(count).append("\n");
			count = 0;
		}

		System.out.println(sb.toString());

	}

}
