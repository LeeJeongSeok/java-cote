package me.jeongseok.cote.pt_practice;

import java.util.StringTokenizer;

public class MaxAndMin {

	static int min = Integer.MAX_VALUE;
	static int max = Integer.MIN_VALUE;
	static int arr[];
	static StringBuilder sb = new StringBuilder();
	public static void main(String[] args) {
		String s = "1 2 3 4";
		String[] str = s.split(" ");

		arr = new int[s.length()];

		for (int i = 0; i < str.length; i++) {
			arr[i] = Integer.parseInt(str[i]);
			max = Math.max(max, arr[i]);
			min = Math.min(min, arr[i]);
		}

		sb.append(min).append(" ").append(max);

		System.out.println(sb);
	}

}
