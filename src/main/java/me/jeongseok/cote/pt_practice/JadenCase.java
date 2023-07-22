package me.jeongseok.cote.pt_practice;

/**
 * 모든 단어의 첫 문자는 대문자고, 그 외의 알파벳은 소문자인 문자열이 JadenCase
 * 만약 첫 문자가 알파벳이 아닌 경우 이어지는 알파벳은 모두 소문자로 쓰면 된다.
 *
 * 조건
 * 1. 입력으로 주어지는 문자열의 길이는 1이상 200이하
 * 2. 입력으로 주어지는 문자열은 알파벳과 숫자, 공백으로 이루어져 있다.
 * 3. 숫자는 단어의 첫 문자로만 나온다.
 * 4. 숫자로만 이루어진 단어는 없다.
 * 5. 공백문자가 연속해서 나올 수 있다.
 *
 * 1. 첫 문자가 알파벳이 아닌 경우 이어지는 알파벳은 소문자로 작성한다 예제
 * "3people unFollowed me" -> "3people Unfollowed Me"
 *
 * 2. 알파벳만 입력으로 주어지는 경우
 * "for the last week" -> "For The Last Week"
 *
 * 3. 공백문자가 연속해서 나타나는 경우
 * "s   Ss   s" -> "S   Ss   S"
 *
 * 4. 앞 뒤에 공백 문자가 존재하고 하는 경우 -- 이 경우가 테스트 케이스 8번인 것 같음
 * " for the last week " -> " For The Last Week "
 *
 *
 *
 * 1. 일단 문자열을 입력받고, 공백을 기준으로 문자열을 분리한다.
 *
 * 2. 만약 공백 문자인 경우는 그대로 다시 바꾼 문자열에 집어넣어준다.
 *
 * 3. 공백 문자가 아닌 경우는 대/소문자 치환 작업을 실시한다.
 *
 * 4. 3번 과정에서 첫번째 문자가 알파벳이 아닌 경우는 들어온 숫자 그대로 새로운 문자에 넣어주고 나머지 문자는 소문자로 치환시킨다.
 *
 * 5. 만약 알파벳인 경우 첫번째 문자만 치환시키고, 나머지 문자는 전부다 소문자로 치환시킨다.
 */

public class JadenCase {

	static StringBuilder sb = new StringBuilder();

	public static String solution(String s) {
		String[] split = s.split(" ");

		for (int i = 0; i < split.length; i++) {
			if (split[i].length() == 0) {
				sb.append(" ");
			} else {
				sb.append(changeLowerToUpper(split[i])).append(" ");
			}
		}

		return sb.toString().substring(0, sb.length() - 1);
	}

	public static String changeLowerToUpper(String s) {
		char[] oldCharArray = s.toCharArray();
		char[] newCharArray = new char[oldCharArray.length];

		if (Character.isDigit(oldCharArray[0])) {
			newCharArray[0] = oldCharArray[0];
		} else {
			newCharArray[0] = Character.toUpperCase(oldCharArray[0]);
		}

		for (int i = 1; i < oldCharArray.length; i++) {
			newCharArray[i] = Character.toLowerCase(oldCharArray[i]);
		}

		return String.valueOf(newCharArray);
	}

	public static void main(String[] args) {
//		System.out.println(JadenCase.solution("3people unFollowed me"));
//		System.out.println(JadenCase.solution("for the last week"));
//		System.out.println(JadenCase.solution("s   Ss   s"));
		System.out.println(JadenCase.solution(" for the last week "));
	}

}
