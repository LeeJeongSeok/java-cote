package me.jeongseok.cote.boj;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

/**
 * 백준 24060 실버(4) 알고리즘 수업 - 병합 정렬1
 */

public class BOJ_24060 {
    public static void mergeSort(int[] arr, int left, int right) {
        int p = left;
        int r = right;

        if (p <  r) {
            int middle = (p + r) / 2;
            mergeSort(arr, p, middle);
            mergeSort(arr, middle + 1, r);
            merge(arr, left, middle, right);
        }

    }

    public static void merge(int[] arr, int p, int q, int r) {

    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine(), " ");

        int A = Integer.parseInt(st.nextToken());
        int K = Integer.parseInt(st.nextToken());
        int[] arr = new int[A];

        st = new StringTokenizer(br.readLine(), " ");
        for (int i = 0; i < A; i++) {
            arr[i] = Integer.parseInt(st.nextToken());
        }

        mergeSort(arr, 0, arr.length - 1);
    }
}
