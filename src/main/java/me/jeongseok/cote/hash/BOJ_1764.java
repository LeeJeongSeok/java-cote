package me.jeongseok.cote.hash;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.StringTokenizer;

public class BOJ_1764 {

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine(), " ");
		StringBuilder sb = new StringBuilder();

		int n = Integer.parseInt(st.nextToken());
		int m = Integer.parseInt(st.nextToken());

		int count = 0;

		Map<String, Integer> map = new HashMap<>();

		// 전체 입력
		for (int i = 0; i < n + m; i++) {
			String person = br.readLine();
			map.put(person, map.getOrDefault(person, 0) + 1);
		}


		for(String key : map.keySet()){
			if (map.get(key) == 2) {
				count++;
			}
		}
		sb.append(count).append("\n");

		List<String> keySet = new ArrayList<>(map.keySet());

		Collections.sort(keySet);

		for(String key : keySet){
			if (map.get(key) == 2) {
				sb.append(key).append("\n");
			}
		}

		System.out.println(sb.toString());
	}
}
