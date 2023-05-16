package me.jeongseok.cote.codility;

public class BinarayGap {

	public static void main(String[] args) {

		// Integer.MIN_VALUE를 사용해도 상관없지만 2진수는 1, 0로 표현되기 때문에 -1로 초기값을 잡아도 문제가 없다고 판단
		int max = -1;
		int zeroCount = 0;
		int oneCount = 0;

		// 10진수를 바이너리 값으로 변경
		String binaryString = Integer.toBinaryString(1041);

		/**
		 * 2진수의 시작은 결국 1부터 시작이 된다
		 * 10000010001, 100000
		 * 그 말은 맨 앞부터 0은 들어올 수 없다라는 이야기와 동일하다.
		 */
		for(int i = 0; i < binaryString.length(); i++) {
			if (binaryString.charAt(i) == '0') {
				zeroCount++;
			}

			if (binaryString.charAt(i) == '1') {
				oneCount++;

				/**
				 * 맨 처음 만나는 1은 해당 분기문 조건에 맞지 않기 때문에 패스
				 * 두번째 만나는 1부터 유효함
				 */
				if (zeroCount > max) {
					max = zeroCount;
				}

				// 분기문에 넣지 않은 이유는 zeroCount는 항상 1를 만날때마다 초기화를 해줘야하는데
				// if 분기문에 넣었다면 만약 제로 카운트값이 맥스값보다 적은 경우에는 초기화를 할 수 없기 때문에 오류날 확률 증가
				zeroCount = 0;
			}
		}

		/**
		 * 1의 갯수가 2개 미만인 경우는 1이 0개 혹은 1개인 걸 의미하고 이 뜻은 짝이 되는 1을 찾지 못했다라는 뜻
 		 */
		if (oneCount < 2) {
			System.out.println(0);
		}
		System.out.println(max);
	}

}
