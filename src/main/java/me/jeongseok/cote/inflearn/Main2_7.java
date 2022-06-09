package me.jeongseok.cote.inflearn;

import java.util.Scanner;

public class Main2_7 {

    public static int solution(int[] exam) {

        int answer = 0;
        int weight = 0;

        for (int i = 0; i < exam.length; i++) {
            if (exam[i] == 1) {
                weight++;
                answer = answer + weight;
            } else {
                weight = 0;
            }
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

        System.out.println(Main2_7.solution(exam));
    }
}
