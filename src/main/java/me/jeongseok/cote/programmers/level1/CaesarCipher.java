package me.jeongseok.cote.programmers.level1;

/**
 * 프로그래머스 - 레벨1 - 시저 암호
 */
public class CaesarCipher {

	char[] lowerAlpha = new char[26];
	char[] upperAlpha = new char[26];

	public void makeAlphabet() {
		for(int i = 0; i < upperAlpha.length; i++) {
			upperAlpha[i] = (char)(65+i);
		}

		for(int i = 0; i < lowerAlpha.length; i++) {
			lowerAlpha[i] = (char)(97+i);
		}
	}
	public String solution(String s, int n) {
		makeAlphabet();

		StringBuilder sb = new StringBuilder();

		for (int i = 0; i < s.length(); i++) {
			if (s.charAt(i) != ' ') {
				if (s.charAt(i) >= 65 && s.charAt(i) <= 90) {
					int idx = (s.charAt(i) - 65) + n;

					if (idx >= 26) {
						idx = idx - 26;
					}

					sb.append(upperAlpha[idx]);
				}

				if (s.charAt(i) >= 97 && s.charAt(i) <= 122) {
					int idx = (s.charAt(i) - 97) + n;

					if (idx >= 26) {
						idx = idx - 26;
					}

					sb.append(lowerAlpha[idx]);
				}
			} else {
				sb.append(" ");
			}
		}

		return sb.toString();

	}

	public static void main(String[] args) {
		System.out.println(new CaesarCipher().solution("AB", 1));
		System.out.println(new CaesarCipher().solution("z", 1));
		System.out.println(new CaesarCipher().solution("a B z", 4));
	}
}
