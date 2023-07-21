package me.jeongseok.cote.pt_practice;

public class JadenCase {

	static StringBuilder sb = new StringBuilder();

	public static void main(String[] args) {
		String s = " S        Ss ";
		// 연속해서 공백이 나올 경우 하나의 공백으로 치환
		String[] split = s.split(" ");

		for (int i = 0; i < split.length; i++) {
			if (split[i].length() == 0) {
				sb.append(" ");
			} else {
				sb.append(changeUpper(split[i])).append(" ");
			}

			// 마지막 단어만 공백을 제거한다.
			if (split[split.length - 1].equals(" ")) {
				System.out.println(sb);
			}

			sb.toString().substring(0, sb.toString().length() - 1);
		}

		System.out.println(sb);
	}

	private static String changeUpper(String str) {
		char[] charArray = str.toCharArray();
		char[] newCharArray = new char[charArray.length];

		if (Character.isDigit(charArray[0])) {
			newCharArray[0] = charArray[0];
		} else {
			newCharArray[0] = Character.toUpperCase(charArray[0]);
		}

		for (int i = 1; i < charArray.length; i++) {
			newCharArray[i] = Character.toLowerCase(charArray[i]);
		}

		return String.valueOf(newCharArray);
	}

}
