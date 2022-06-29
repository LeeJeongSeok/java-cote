package me.jeongseok.cote.inflearn;

import java.util.Scanner;

public class Main2_10 {
    public static int solution(int N, int[][] arr) {

        int answer = 0;
        int[][] tempArr = new int[N][N];

        // 상, 하, 좌, 우 로직 비교
        for (int i = 1; i <= N; i++) {
            for (int j = 1; j <= N; j++) {
                // 상
                if (arr[i][j] > arr[i-1][j]) {
                    if (tempArr[i-1][j-1] == 1) {
                        break;
                    }
                    tempArr[i-1][j-1] = 1;
                }
                // 하
                if (arr[i][j] > arr[i+1][j]) {
                    if (tempArr[i-1][j-1] == 1) {
                        break;
                    }
                    tempArr[i-1][j-1] = 1;
                }
                // 좌
                if (arr[i][j] > arr[i][j-1]) {
                    if (tempArr[i-1][j-1] == 1) {
                        break;
                    }
                    tempArr[i-1][j-1] = 1;
                }
                // 우
                if (arr[i][j] > arr[i][j+1]) {
                    if (tempArr[i-1][j-1] == 1) {
                        break;
                    }
                    tempArr[i-1][j-1] = 1;
                }
            }
        }

        for (int i = 0; i < tempArr.length; i++) {
            for (int j = 0; j < tempArr.length; j++) {
                System.out.print(tempArr[i][j] + " ");
            }
            System.out.println(" ");
        }
        return answer;
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
