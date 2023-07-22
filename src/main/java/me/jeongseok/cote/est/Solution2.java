package me.jeongseok.cote.est;

import java.util.Deque;
import java.util.LinkedList;

public class Solution2 {

	int oneCount = 0;
	int twoCount = 0;
	int threeCount = 0;

	int addOne = 0;
	int addTwo = 0;
	int addThree = 0;
	public int[] solution(int[] queue) {
		int[] answer = new int[3];

		// 1. 3의 배수이기 떄문에 모든 원소는 3으로 나눈 몫의 갯수만큼 존재해야함 그 중 하나라도 값을 벗어나면 안됌
		int elementSize = queue.length / 3;

		Deque<Integer> numberQueue = new LinkedList<>();

		for (int i = 0; i < queue.length; i++) {
			numberQueue.offer(queue[i]);
		}

		// 5. 큐가 빌때까지 삽입 삭제를 반복해서 원소들의 갯수를 맞춘다.
		while (!numberQueue.isEmpty()) {

			oneCount = 0;
			twoCount = 0;
			threeCount = 0;

			// 6. 큐를 한번 순회하고 나서 다시 각 원소들의 갯수를 카운팅
			// --여기서 시간초과나는 느낌이 난다,,n^2..인데,,
			// 그럼 전체 원소 갯수는 언제파악하냐,,
			for (Integer element : numberQueue) {
				if (element == 1) {
					oneCount++;
				} else if (element == 2) {
					twoCount++;
				} else {
					threeCount++;
				}
			}

			// 7. 각 원소의 갯수가 동일하다면 결과를 리턴 (탈출 조건)
			if (oneCount == elementSize && twoCount == elementSize && threeCount == elementSize) {
				answer[0] = addOne;
				answer[1] = addTwo;
				answer[2] = addThree;
				break;
			}

			// 8. 맨 앞 원소 삭제
			numberQueue.pollFirst();

			// 9. 맨 뒤 원소를 가져온다.
			int last = numberQueue.getLast();

			// 10. 3보다 크면 다시 1부터 넣어야함
			if (last == 1) {
				if (twoCount > elementSize) {
					addThree++;
					last = 3;
				} else {
					addTwo++;
					last = 2;
				}
			} else if (last == 2) {
				if (threeCount > elementSize) {
					addOne++;
					last = 1;
				} else {
					addThree++;
					last = 3;
				}

			} else  if (last == 3){
				if (oneCount > elementSize) {
					addTwo++;
					last = 2;
				} else {
					addOne++;
					last = 1;
				}
			}

			numberQueue.offerLast(last);
		}
		return answer;
	}

	public static void main(String[] args) {
		Solution2 test = new Solution2();

//		int[] solution = test.solution(new int[]{2, 1, 3, 1, 2, 1});
//		for (int i = 0; i < solution.length; i++) {
//			System.out.print(solution[i] + " ");
//		}
//		System.out.println();
//
//		int[] solution1 = test.solution(new int[]{3, 3, 3, 3, 3, 3});
//		for (int i = 0; i < solution1.length; i++) {
//			System.out.print(solution1[i] + " ");
//		}
//		System.out.println();

//		int[] solution2 = test.solution(new int[]{1, 2, 3});
//		for (int i = 0; i < solution2.length; i++) {
//			System.out.print(solution2[i] + " ");
//		}
//		System.out.println();

		int[] solution3 = test.solution(new int[]{1, 1, 1, 1, 1, 1});
		for (int i = 0; i < solution3.length; i++) {
			System.out.print(solution3[i] + " ");
		}
		System.out.println();

	}

}
