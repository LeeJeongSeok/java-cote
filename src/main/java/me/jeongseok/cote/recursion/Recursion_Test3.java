package me.jeongseok.cote.recursion;

public class Recursion_Test3 {

	public static int factorial(int n) {
		if (n == 1) {
			return 1;
		} else {
			return n * factorial(n - 1);
		}
	}

	public static void main(String[] args) {

	}

}
