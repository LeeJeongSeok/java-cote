package me.jeongseok.cote.pt_practice;

import java.io.*;
import java.util.*;

public class _10816_ {

	static int N, M;
	static HashMap<Integer, Integer> map = new HashMap<>();
	static StringBuilder sb = new StringBuilder();

	public static void main(String[] args) throws Exception{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

		N = Integer.parseInt(br.readLine());

		StringTokenizer st = new StringTokenizer(br.readLine());
		for (int i = 0; i < N; i++) {
			int value = Integer.parseInt(st.nextToken());
			map.put(value, map.getOrDefault(value, 0) + 1);
		}

		M = Integer.parseInt(br.readLine());

		st = new StringTokenizer(br.readLine());
		for (int i = 0; i < M; i++) {
			int value = Integer.parseInt(st.nextToken());
			if (map.containsKey(value)) {
				sb.append(map.get(value)).append(" ");
			} else {
				sb.append(0).append(" ");
			}
		}

		System.out.println(sb);
	}

}
