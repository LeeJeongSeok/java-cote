package me.jeongseok.cote.math;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

/**
 * 6 = 1 + 2 + 3
 * 12 is NOT perfect.
 * 28 = 1 + 2 + 4 + 7 + 14
 */

/**
 * 약수구하는 코드가 2번 반복됨
 */
public class BOJ_9506 {

	static StringBuilder sb = new StringBuilder();

	// idx 변수를 추가한 이유는 count + 1만큼 배열이 생성이 되고
	// 1 ~ n까지 순회하면서 약수인지 판별할 때 순서에 맞게 배열에 집어넣기 위해 추가함
	// 그렇지 않으면 0이 들어감
	static int[] makeDivisorArray(int n, int count) {
		int[] array = new int[count + 1];
		int idx = 0;

		for (int i = 1; i < n; i++) {
			if (n % i == 0) {
				idx++;
				array[idx] = i;
			}
		}

		return array;
	}
	static boolean isPerfectNumber(int sum, int n) {
		return sum == n;
	}

	static void printDivisorArray(int[] array, int count, int sum) {
		sb.append(sum).append(" = ");

		for (int i = 1; i <= count; i++) {
			if (i < count) {
				sb.append(array[i]).append(" + ");
			} else {
				sb.append(array[i]);
			}
		}
		sb.append("\n");
	}
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

		while (true) {
			int n = Integer.parseInt(br.readLine());
			int sum = 0;

			if (n == -1) {
				System.out.println(sb.toString());
				break;
			}

			// 약수 구하기
			int count = 0;
			for (int i = 1; i < n; i++) {
				if (n % i == 0) {
					count++;
					sum += i;
				}
			}

			if (!isPerfectNumber(sum, n)) {
				sb.append(n + " is NOT perfect.").append("\n");
			} else {
				// 약수의 갯수 만큼 배열 생성한 후 배열에 insert
				int[] divisorArray = makeDivisorArray(n, count);
				printDivisorArray(divisorArray, count, sum);
			}

		}
	}
}
