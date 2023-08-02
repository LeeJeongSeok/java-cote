package me.jeongseok.cote.pt_practice;

public class BinaryConversionIteration {

	static int count, loopCount;
	public int[] solution(String s) {
		int[] answer = new int[2];


		while (true) {
			loopCount++;

			String str = "";
			// 1. 문자열에서 "0"을 제거하면서 카운트를 센다
			for (int i = 0; i < s.length(); i++) {
				if (s.charAt(i) == '0') {
					count++;
				} else {
					str += s.charAt(i);
				}
			}

			// 2. 1의 갯수를 카운팅
			String binaryString = Long.toBinaryString(str.length());

			if (Long.parseLong(binaryString) == 1) {
				answer[0] = loopCount;
				answer[1] = count;
				break;
			} else {
				s = binaryString;
			}
		}

		return answer;
	}

	public static void main(String[] args) {
//		int[] solution = new BinaryConversionIteration().solution("110010101001");
//		int[] solution = new BinaryConversionIteration().solution("01110");
//		int[] solution = new BinaryConversionIteration().solution("1111111");
		int[] solution = new BinaryConversionIteration().solution("1");

		System.out.println(solution[0]);
		System.out.println(solution[1]);
	}

}
