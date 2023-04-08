package me.jeongseok.cote.programmers.level1;

import java.util.HashSet;

public class Pokemon {

	public int solution(int[] nums) {
		int answer = nums.length / 2;

		HashSet<Integer> set = new HashSet<>();

		for (int num : nums) {
			set.add(num);
		}

		return set.size() > answer ? answer : set.size();
	}

	public static void main(String[] args) {
		System.out.println(new Pokemon().solution(new int[]{3, 1, 2, 3}));
		System.out.println(new Pokemon().solution(new int[]{3, 3, 3, 2, 2, 4}));
		System.out.println(new Pokemon().solution(new int[]{3, 3, 3, 2, 2, 2}));
		System.out.println(new Pokemon().solution(new int[]{3, 3, 3, 3, 2, 2, 2, 2}));
	}

}
