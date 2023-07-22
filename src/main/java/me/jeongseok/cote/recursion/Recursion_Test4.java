package me.jeongseok.cote.recursion;

public class Recursion_Test4 {

	public static int dfs(int n) {
		if (n == 1 || n == 2) {
			return 1;
		} else {
			return dfs(n - 2) + dfs(n - 1);
		}

	}

	public static void main(String[] args) {

		for (int i = 1; i <= 5; i++) {
			System.out.print(dfs(i) + " ");
		}

	}

}
