package me.jeongseok.cote.codility;

public class FrogJmp {

	public static void main(String[] args) {
		int X = 10;
		int Y = 10;
		int D = 30;

		if (X == Y) {
			System.out.println(0);
		}

		System.out.println((Y % D > X) ? (Y / D) + 1 : Y / D);
	}

}
