package me.jeongseok.cote.math;

public class Factorial {

	static long factorial(long k) {
		if (k == 95) {
			return 95;
		}
		return factorial(k - 1) * k;
	}

	public static void main(String[] args) {
		System.out.println(factorial(100));


		System.out.println(858277728000L / 720);
	}

}
