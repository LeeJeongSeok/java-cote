package me.jeongseok.cote.inflearn;

import java.util.Scanner;

public class Main2_10 {
    public static int solution(int N, int[][] arr) {

        int answer = 0;

        // 상, 하, 좌, 우 로직 비교
        for (int i = 1; i <= N; i++) {
            for (int j = 1; j <= N; j++) {
                // 상
                if (!isZero(arr[i-1][j])) {
                    if (arr[i][j] > arr[i-1][j]) {
                        arr[i][j] = 100;
                        arr[i-1][j] = 0;
                    } else {
                        arr[i][j] = 0;
                    }
                }
                // 하
                if (!isZero(arr[i+1][j])) {
                    if (arr[i][j] > arr[i+1][j]) {
                        arr[i][j] = 100;
                        arr[i-1][j] = 0;
                    } else {
                        arr[i][j] = 0;
                    }
                }
                // 좌
                if (!isZero(arr[i][j-1])) {
                    if (arr[i][j] > arr[i][j-1]) {
                        arr[i][j] = 100;
                        arr[i][j-1] = 0;
                    } else {
                        arr[i][j] = 0;
                    }
                }
                // 우
                if (!isZero(arr[i][j+1])) {
                    if (arr[i][j] > arr[i][j+1]) {
                        arr[i][j] = 100;
                        arr[i][j+1] = 0;
                    } else {
                        arr[i][j] = 0;
                    }
                }
            }
        }


        for (int i = 0; i < arr.length; i++) {
            for (int j = 0; j < arr.length; j++) {
                if (arr[i][j] == 100) {
                    answer++;
                }
            }
        }
        return answer;
    }

    private static boolean isZero(int n) {
        return n == 0;
    }


    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int N = sc.nextInt();
        int init = N + 2;
        int arr[][] = new int[init][init];

        for (int i = 1; i <= N; i++) {
            for (int j = 1; j <= N; j++) {
                arr[i][j] = sc.nextInt();
            }
        }

        System.out.println(Main2_10.solution(N, arr));
    }
}
