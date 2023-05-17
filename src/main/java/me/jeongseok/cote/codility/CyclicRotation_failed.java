package me.jeongseok.cote.codility;

public class CyclicRotation_failed {

	public static void main(String[] args) {
		int[] A = new int[]{3, 8, 9, 7, 6};
		int K = 3;
		// Implement your solution here
		int[] answer = new int[A.length];

		// 1. 배열을 탐색한다.
		for(int i = 0; i < A.length; i++) {
			// 2. 원소의 인덱스값과 K를 더한다.
			int newIdx = i + K;

			// 3. 2의 결과가 배열의 길이보다 작다면 새로운 배열의 newIdx 위치에 A의 원소를 넣는다.
			if (newIdx < A.length) {
				answer[newIdx] = A[i];
			} else {
				// 4. 2의 겨로가가 배열의 길이보다 크면 새로운 배열 newIdx에 A의 배열의 길이만큼 뺴준 후 A의 원소를 넣는다.
				answer[newIdx - A.length] = A[i];
			}
		}
	}
}
