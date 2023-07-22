package me.jeongseok.cote.recursion;

public class Recursion_Test2 {

	static StringBuilder sb = new StringBuilder();

	public static void dfs(int n) {
		if (n == 0) {
			return;
		} else {
			dfs(n / 2);
			System.out.print(n % 2);
		}
	}

	public static void main(String[] args) {
		dfs(11);
	}

}
