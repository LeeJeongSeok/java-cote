package me.jeongseok.cote.math;

public class Test {

	public static void main(String[] args) {
		int max = Integer.MIN_VALUE;
		int count = 0;
		int oneCount = 0;
		boolean flag = false;

		// 10진수를 바이너리 값으로 변경
		String binaryString = Integer.toBinaryString(1041);

		for(int i = 0; i < binaryString.length() - 1; i++) {
			if (binaryString.charAt(i) != '0') {
				oneCount++;
			} else {
				count++;
			}

			if (oneCount == 2) {
				if (count > max) {
					max = count;
					count = 0;
					oneCount = 0;
					flag = true;
				}
			}
		}

		if (!flag) {
			System.out.println(0);
		}
		System.out.println(max);
	}

}
