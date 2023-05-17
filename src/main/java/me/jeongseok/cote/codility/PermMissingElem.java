package me.jeongseok.cote.codility;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;

public class PermMissingElem {

	public static void main(String[] args) {

		int[] A = new int[]{1};

		int result = 0;
		List<Integer> list = new ArrayList();

		if (A.length == 0) {
			System.out.println(1);
		}

		for (int i = 0; i < A.length; i++) {
			list.add(A[i]);
		}

		Collections.sort(list);

		for (int i = 0; i <= list.size() - 1; i++) {
			// 중간에 숫자가 누락되는 경우
			if (list.get(i) != list.get(i + 1) - 1) {
				result = list.get(i) + 1;
				break;
			} else {
				result = list.get(i) + 1;
			}
		}

		System.out.println(result);
	}

}
