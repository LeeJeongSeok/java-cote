package me.jeongseok.cote.codility;

public class CyclicRotation {

	public static void main(String[] args) {

		// input
		int[] A = new int[]{1, 2, 3};
		int K = 5;


		// business login
		int[] answer = new int[A.length];

		// 원소가 하나만 있는 경우는 아무리 K번 돌려도 결국 원래 원소의 값을 찾게됨
		if (A.length == 1) {
			System.out.println(A[0]);
			return;
		}

		for (int i = 0; i < A.length; i++) {
			int newIdx = i + K;

			if (newIdx < A.length) {
				answer[newIdx] = A[i];
			} else {
				answer[newIdx % A.length] = A[i];
			}
		}

		for (int i = 0; i < answer.length; i++) {
			System.out.print(answer[i] + " ");
		}
	}

}
