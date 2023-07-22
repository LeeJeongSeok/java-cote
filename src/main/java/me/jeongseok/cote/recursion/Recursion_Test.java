package me.jeongseok.cote.recursion;

public class Recursion_Test {

	public static void dfs(int n) {
		if (n == 0) {
			return;
		} else {
			dfs(n - 1);
			System.out.println(n);
		}
	}

	public static void main(String[] args) {
		dfs(3);
	}

}
