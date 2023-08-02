package me.jeongseok.cote.pt_practice;

public class NumberRepresentation {

	static int arr[];
	static int sum;
	public int solution(int n) {
		int answer = 1;

		arr = new int[n + 1];

		for (int i = 1; i <= n; i++) {
			arr[i] = i;
		}

		for (int i = 1; i <= n; i++) {
			sum = i;
			for (int j = i + 1; j <= n; j++) {
				sum += j;

				if (sum < n) {
					continue;
				} else if (sum > n) {
					break;
				} else if (sum == n) {
					answer++;
					break;
				}
			}
		}

		return answer;
	}
	public static void main(String[] args) {
		System.out.println(new NumberRepresentation().solution(15));
		System.out.println(new NumberRepresentation().solution(4));
		System.out.println(new NumberRepresentation().solution(3));
	}

}
