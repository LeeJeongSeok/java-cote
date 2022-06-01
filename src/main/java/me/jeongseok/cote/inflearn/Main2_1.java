package me.jeongseok.cote.inflearn;

import java.util.ArrayList;
import java.util.Scanner;

public class Main2_1 {
    public static ArrayList<Integer> solution(int n, int[] arr) {

        ArrayList<Integer> list = new ArrayList<>();

        for (int i = 0; i < arr.length; i++) {
            if (i == 0) {
                list.add(arr[i]);
                continue;
            }
            if (arr[i] > arr[i-1]) {
                list.add(arr[i]);
            }
        }

        return list;
    }
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int[] arr = new int[n];

        for (int i = 0; i < arr.length; i++) {
            arr[i] = sc.nextInt();
        }

        for (int i : Main2_1.solution(n, arr)){
            System.out.print(i + " ");
        }
    }
}
