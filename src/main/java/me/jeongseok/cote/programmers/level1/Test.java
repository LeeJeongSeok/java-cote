package me.jeongseok.cote.programmers.level1;

import java.util.Arrays;
import java.util.List;
import java.util.Objects;
import java.util.regex.Matcher;
import java.util.regex.Pattern;
import java.util.stream.IntStream;

public class Test {

	public static void main(String[] args) {
		//(int)n%10 부분을 (int)(n%10)
//		long test = 5000000000L;
//		System.out.println(test % 10);
//		System.out.println((int) test % 10);
//		System.out.println(((int) test) % 10);
//		System.out.println((int) (test % 10));

//		String s = "try hello world";
//		String answer = "";
//		int cnt = 0;
//		String[] array = s.split("");
//
//		for (String ss : array) {
//			cnt = ss.contains(" ") ? 0 : cnt + 1;
//			answer += cnt % 2 == 0 ? ss.toLowerCase() : ss.toUpperCase();
//		}

		// a % b --> 왼쪽 피연산자를 오른쪽 피연산자로 나눈 나머지 값을 구함
//		for (int i = 0; i < 10; i++) {
//			System.out.println("1번 수포자 : " + i % 5);
//			System.out.println("2번 수포자 : " + i % 8);
//			System.out.println("3번 수포자 : " + i % 10);
//			System.out.println("------------------------");
//		}

//		int[] arr = new int[26];
//
//		for (int i = 2; i <= 25; i++) {
//			 arr[i] = i;
//		}
//
//		for (int i = 2; i <= 25; i++) {
//			if (arr[i] == 0) continue;
//			for (int j = i + i; j <= 25; j += i) {
//				arr[j] = 0;
//			}
//		}
//
//		for (int i = 2; i <= 25 ; i++) {
//			System.out.println(arr[i]);
//		}

//		String test = "test";
//		String test2 = "test2222";
//
//		System.out.println(Objects.hash(test));
//		System.out.println("--------------------------------");
//		System.out.println(Objects.hashCode(test2));
////		System.out.println(Objects.hash(1));
//
//		System.out.println((int) 'a');
//
//		System.out.println((char) 97);
//		System.out.println(25 % 26 + 97);
//
//		String str = "abcdefghijklmnopqrstuvwxyz";
//		String[] strSplit = str.split("");
//
//		String skip = "wbqd";
//		String[] skipSplit = skip.split("");
//
//		for (int i = 0; i < skipSplit.length; i++) {
//			String word = skipSplit[i];
//
//			for (int j = 0; j < strSplit.length; j++) {
//				if (strSplit[j].equals(word)) {
//					skipSplit[j].replace(skipSplit[j], "");
//				}
//			}
//		}
//
//		String s = "happy";
//		int index = 5;
//		StringBuilder answer = new StringBuilder();
//
//		for (char letter : s.toCharArray()) {
//			char temp = letter;
//			int idx = 0;
//			while (idx < index) {
//
//				if (temp == 'z') {
//					temp = 'a';
//				} else {
//					temp = (char) (temp + 1);
//				}
//
//				if (!skip.contains(String.valueOf(temp))) {
//					idx += 1;
//				}
//			}
//			answer.append(temp);
//		}

		char a = 'a';
		char b = a++;

		System.out.println(a);
		System.out.println(b);

		int sum = IntStream.rangeClosed(1, 3).sum();

		StringBuilder sb = new StringBuilder();
		System.out.println(sb.equals(""));

		System.out.println(sum);

		System.out.println(1000000000 - 1);



	}

}
