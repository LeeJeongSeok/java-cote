package me.jeongseok.cote.cote;

public class Problem1 {

	public static int solution(int[] nums) {

		int firstMax = -1;
		int secondMax = -1;


		for (int i = 0; i < nums.length; i++) {
			int index = -1;
			if (i != index && nums[i] > firstMax) {
				firstMax = nums[i];
				index = i;
			} else if (i != index && nums[i] > secondMax) {
				secondMax = nums[i];
			}
		}

		return (firstMax - 1) * (secondMax - 1);
	}
	public static void main(String[] args) {
		System.out.println(solution(new int[]{3, 5, 7, 5}));
		System.out.println(solution(new int[]{1, 1, 1, 1, 1, 1, 3, 4, 4, 5, 2, 3, 4, 6, 6}));
		System.out.println(solution(new int[]{5}));
		System.out.println(solution(new int[]{2, 3}));
	}

}
