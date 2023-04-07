package me.jeongseok.cote.programmers.level1;

/**
 * 프로그래머스 - 레벨1 - 2016년
 *
 * SUN,MON,TUE,WED,THU,FRI,SAT
 */
public class Calendar {
	public String solution(int a, int b) {

		int totalDay = 0;

		String[] weekday = {"FRI", "SAT", "SUN", "MON", "TUE", "WED", "THU"};
		int[] finalDays = {31, 29, 31, 30, 31, 30, 31, 31, 30, 31, 30, 31};

		// for문을 돌려 a-1까지 date 배열에 있는 값을 totalDay 변수에 더해준다.(7월이라면 6월까지는 다 더하는 것)
		for (int i = 0; i < a - 1; i++) {
			totalDay += finalDays[i];
		}

		// b-1를 해주는 이유는 해당 요일이 지난 일이 아니기 때문이다.
		// b-1을 해주지 않는다면 day[select]는 day [1]이 되어 버리고 그러면 1월 1일은 금요일인데 SAT가 나오게 된다.
		totalDay += (b - 1);

		return weekday[totalDay % 7];
	}

	public static void main(String[] args) {
		System.out.println(new Calendar().solution(5, 24));
		System.out.println(new Calendar().solution(1, 7));
		System.out.println(new Calendar().solution(2, 25));
	}
}
