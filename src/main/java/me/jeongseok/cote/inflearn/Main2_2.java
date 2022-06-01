package me.jeongseok.cote.inflearn;

import java.util.Scanner;

public class Main2_2 {
    public static int solution(int n, int[] arr) {
        int answer = 1;
        int max = arr[0];

        for (int i = 1; i < arr.length; i++) {
            if (arr[i] > max) {
                max = arr[i];
                answer++;
            }
        }
        return answer;
    }
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int[] arr = new int[n];

        for (int i = 0; i < arr.length; i++) {
            arr[i] = sc.nextInt();
        }

        System.out.println(Main2_2.solution(n, arr));
    }
}
