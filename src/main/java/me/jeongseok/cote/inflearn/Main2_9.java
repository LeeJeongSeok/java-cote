package me.jeongseok.cote.inflearn;

import java.util.Scanner;

public class Main2_9 {
    public static int solution(int n, int[][] arr) {
        int answer = 0;

        return answer;
    }
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int N = sc.nextInt();
        int[][] arr = new int[N][N];
        for (int i = 0; i < N; i++) {
            for (int j = 0; j < N; j++) {
                arr[i][j] = sc.nextInt();
            }
        }
        System.out.println(Main2_9.solution(N, arr));
    }
}