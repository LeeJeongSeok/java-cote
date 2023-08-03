package me.jeongseok.cote.pt_practice;

public class RemovePairs {

	public int solution(String s) {
		int answer = 0;

		int i = 0;
		int j = 1;

		while (true) {
			if (s.length() == 0) {
				answer = 1;
				break;
			} else if (j == s.length()) {
				break;
			}

			if (s.charAt(i) != s.charAt(j)) {
				i++;
				j++;
			} else if (s.charAt(i) == s.charAt(j)) {
				s = s.substring(0, i) + s.substring(j + 1, s.length());
				i = 0;
				j = 1;
			}

		}

		return answer;
	}

	public static void main(String[] args) {
//		System.out.println(new RemovePairs().solution("baabaa"));
		System.out.println(new RemovePairs().solution("cdcd"));

//		String str = "String";
//		System.out.println(str.substring(3, str.length()));
	}

}
