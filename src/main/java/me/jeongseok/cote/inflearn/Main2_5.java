package me.jeongseok.cote.inflearn;

import java.util.Scanner;

public class Main2_5 {
    public static int solution(int n) {
        int answer = 0;
        int[] arr = new int[n+1];

        for (int i = 2; i <= n; i++) {
            if (arr[i] == 0) {
                answer++;
                for (int j = i; j <= n; j=j+i) {
                    arr[j] = 1;
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
