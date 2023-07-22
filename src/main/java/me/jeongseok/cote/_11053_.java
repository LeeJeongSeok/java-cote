package me.jeongseok.cote;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class _11053_ {

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

		int N = Integer.parseInt(br.readLine());
		int[] nums = new int[N];

		StringTokenizer st = new StringTokenizer(br.readLine(), " ");

		// 여기까지가 입력
		for (int i = 0; i < N; i++) {
			nums[i] = Integer.parseInt(st.nextToken());
		}


		// result 배열이 dp 배열과 동일한 역할을 하는 듯 함
		int[] result = new int[N];

		// result 0번째 값을 초기값을 nums 0번째 값으로 초기화
		result[0] = nums[0];

		// 이로써 카운트 증가
		int size = 1;

		for (int i = 1; i < N; i++) {
			// 10 < 20
			if (result[size - 1] < nums[i]) {
				result[size++] = nums[i];
				continue;
			}

			// 중점은 '증가'와 '가장 길다'에 맞춰야함
			// 증가 로직은 단순 분기로 구현 가능
			int lIdx = 0;
			int rIdx = size - 1;

			while (lIdx < rIdx) {
				int mid = lIdx + (rIdx - lIdx) / 2;

				if (result[mid] < nums[i]) lIdx = mid + 1;
				else rIdx = mid;
			}
			result[rIdx] = nums[i];
		}

		System.out.println(size);
		br.close();
	}

}
