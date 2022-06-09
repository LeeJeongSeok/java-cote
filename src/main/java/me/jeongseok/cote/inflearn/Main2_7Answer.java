package me.jeongseok.cote.inflearn;

import java.util.Scanner;

public class Main2_7Answer {
    public static int solution(int n, int[] arr) {
        int answer = 0, cnt = 0;
        for (int i = 0; i < n; i++) {
            if (arr[i] == 1) {
                cnt++;
                answer += cnt;
            } else cnt = 0;
        }
        return answer;
    }
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int[] exam = new int[n];

        for (int i = 0; i < n; i++) {
            exam[i] = sc.nextInt();
        }

        System.out.println(Main2_7Answer.solution(n, exam));
    }
}
