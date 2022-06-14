package me.jeongseok.cote.inflearn;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Scanner;

public class Main2_9 {
    public static int solution(int n, int[][] arr) {

        ArrayList<Integer> list = new ArrayList<>();

        int rowMax = 0;
        int columnMax = 0;
        int leftMax = 0;
        int rightMax = 0;

        // 각 row별 최대값 구하기
        rowMax = getRowMax(n, arr, rowMax);

        // 각 column별 최대값 구하기
        columnMax = getColumnMax(n, arr, columnMax);

        // 왼쪽에서 오른쪽으로 가는 cross 값 구하기
        leftMax = getLeftMax(n, arr, leftMax);

        // 오른쪽에서 왼쪽으로 가는 cross 값 구하기
        rightMax = getRightMax(n, arr, rightMax);

        // rowMax, columnMax, crossMax 값 중 최대값 뽑아내기
        list.add(rowMax);
        list.add(columnMax);
        list.add(leftMax);
        list.add(rightMax);

        return Collections.max(list);
    }

    private static int getRowMax(int n, int[][] arr, int rowMax) {
        for (int i = 0; i < n; i++) {
            int rowTotal = 0;
            for (int j = 0; j < n; j++) {
                rowTotal += arr[i][j];
            }
            if (rowMax < rowTotal) {
                rowMax = rowTotal;
            }
        }
        return rowMax;
    }

    private static int getColumnMax(int n, int[][] arr, int columnMax) {
        for (int i = 0; i < n; i++) {
            int columnTotal = 0;
            for (int j = 0; j < n; j++) {
                columnTotal += arr[j][i];
            }
            if (columnMax < columnTotal) {
                columnMax = columnTotal;
            }
        }
        return columnMax;
    }

    private static int getLeftMax(int n, int[][] arr, int leftMax) {
        for (int i = 0; i < n; i++) {
            leftMax += arr[i][i];
        }
        return leftMax;
    }

    private static int getRightMax(int n, int[][] arr, int rightMax) {
        for (int i = 0; i < n; i++) {
            int rightTotal = 0;
            for (int j = n -1; j >= 0; j--) {
                rightTotal += arr[i][j];
            }
            if (rightMax < rightTotal) {
                rightMax = rightTotal;
            }
        }
        return rightMax;
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