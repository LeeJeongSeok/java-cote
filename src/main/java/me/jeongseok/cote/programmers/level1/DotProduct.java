package me.jeongseok.cote.programmers.level1;

public class DotProduct {

	public int solution(int[] a, int[] b) {
		int answer = 0;
		for (int i = 0; i < a.length; i++) {
			int multi = a[i] * b[i];
			answer += multi;
		}
		return answer;
	}
	public static void main(String[] args) {
		//System.out.println(new DotProduct().solution(new int));
	}

}
