package me.jeongseok.cote.codility;

import java.util.ArrayList;

public class CompanyEmailsVar {

	static ArrayList<String> nameList = new ArrayList<>();

	/**
	 * @param employ
	 * 3. 사원의 이름의 총 길이를 판별
	 * First + Last -> 길이가 2
	 * First + Middle + Last -> 길이가 3
	 */
	static public String makeForEmailName(String employ) {

		String[] names = employ.split(" ");

		// 3-1. First, Middle, Last인 경우
		if (names.length > 2) {
			return changeLowerName(deleteMiddleName(names));
		}
		return changeLowerName(names);
	}

	/**
	 * @param name
	 * 4. 사원 이름의 길이가 3이면 Middle Name을 삭제시킨다.
	 */
	static public String[] deleteMiddleName(String[] name) {

		StringBuilder sb = new StringBuilder();

		for (int i = 0; i < name.length; i++) {
			if (i != 1) {
				sb.append(name[i]).append(" ");
			}
		}
		return sb.toString().split(" ");
	}


	/**
	 * @param name
	 * 5. 3, 4번 과정이 끝나면 이름을 소문자로 바꾸고, Last Name에 하이픈이 들어가있다면, 제거
	 * 마지막 이름을 바꿔준 후 언더바가 들어가는데, 이름 끝에 언더바는 필요 없기 떄문에 리턴문에서 언더바 삭제 (doe_john_ -> doe_john)
	 */
	static public String changeLowerName(String[] name) {

		StringBuilder sb = new StringBuilder();

		for (int i = name.length - 1; i >= 0; i--) {
			String nonHyphens = name[i].replace("-", "");
			sb.append(nonHyphens.toLowerCase()).append("_");
		}

		// doe_john_ -> doe_john
		String newName = sb.delete(sb.length() - 1, sb.length()).toString();
		nameList.add(newName);

		// 중복되는 이름에 번호 붙히기
		// 1은 중복없이 한번만 나왔다는 이야기
		int duplicateCount = findSameName(newName);
		if (duplicateCount == 1) {
			return newName;
		}
		return newName + duplicateCount;
	}

	/**
	 * 중복되는 이름을 검사한 후 카운팅
 	 */
	static public int findSameName(String name) {
		int duplicateCount = 0;

		for (int i = 0; i < nameList.size(); i++) {
			if (name.equals(nameList.get(i))) {
				duplicateCount++;
			}
		}

		return duplicateCount;
	}



	/**
	 * @param S
	 * @param C
	 * 1. 입력으로 들어온 S를 ;(공백) 기준으로 나눈다.
	 * 1-1. C를 소문자로 변환한다.
	 * 2. makeForEmailName 메소드를 호출하여 3 ~ 5 과정을 진행한 후
	 * 마지막으로 전체 이메일 주소를 완성시킨다.
	 */
	static public String solution(String S, String C) {
		// Implement your solution here
		StringBuilder sb = new StringBuilder();

		// 1. 문자열 S를 ; 기준으로 나눈다.
		String[] employees = S.split("; ");
		String lowerCompany = C.toLowerCase();

		sb.append("\"");
		for (String employ : employees) {
			// 이름을 완성시켰음
			sb.append(employ).append(" ").append("<").append(makeForEmailName(employ)).append("@").append(lowerCompany).append(".com").append(">; ");
		}

		// 전체 메일 주소의 끝 부분 ;  삭제 후 ". 추가
		sb.delete(sb.length() - 1, sb.length());
		sb.delete(sb.length() - 1, sb.length());
		sb.append("\".");

		return sb.toString();
	}

	public static void main(String[] args) {
		System.out.println(solution("John Doe; Peter Benjamin Parker; Mary Jane Watson-Parker; John Elvis Doe; John Evan Doe; Jane Doe; Peter Brian Parker", "Example"));
	}

}
