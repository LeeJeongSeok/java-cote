package me.jeongseok.cote.inflearn;

import java.util.Scanner;

public class Main2_8Answer {
    public static int[] solution(int n, int[] arr) {
        int[] answer = new int[n];
        for (int i = 0; i < n; i++) {
            int cnt = 1;
            for (int j = 0; j < n; j++) {
                if (arr[j] > arr[i]) {
                    cnt++;
                }
                answer[i] = cnt;
            }
        }

        return answer;
    }
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int N = sc.nextInt();
        int arr[] = new int[N];

        for (int i = 0; i < arr.length; i++) {
            arr[i] = sc.nextInt();
        }

        for (int  i : Main2_8Answer.solution(N, arr)) {
            System.out.print(i + " ");
        }
    }
}
