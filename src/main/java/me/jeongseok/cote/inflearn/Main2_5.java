package me.jeongseok.cote.inflearn;

import java.util.Scanner;

public class Main2_5 {
    public static int solution(int n) {
        int answer = 0;

        for (int i = 2; i <= n; i++) {
            for (int j = 1; j <= i; j++) {
                 if (i / j == i) {
                     continue;
                 }
                 if (j / i == 1) {
                     answer++;
                 }
            }
        }

        return answer;
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        System.out.println(Main2_5.solution(n));
    }
}
