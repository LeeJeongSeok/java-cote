package me.jeongseok.cote.inflearn;

import java.util.ArrayList;
import java.util.Scanner;

public class Main2_3 {
    public static ArrayList<String> solution(int n, int[] A, int[] B) {
        ArrayList<String> answer = new ArrayList<>();


        for (int i = 0; i < n; i++) {
            switch (A[i]) {
                // A가 가위
                case 1:
                    // 1. 가위
                    if (B[i] == 1) {
                        answer.add("D");
                    }
                    // 2. 바위
                    if (B[i] == 2) {
                        answer.add("B");
                    }
                    // 3. 보
                    if (B[i] == 3) {
                        answer.add("A");
                    }
                    break;
                // 바위
                case 2:
                    // 1. 가위
                    if (B[i] == 1) {
                        answer.add("A");
                    }
                    // 2. 바위
                    if (B[i] == 2) {
                        answer.add("D");
                    }
                    // 3. 보
                    if (B[i] == 3) {
                        answer.add("B");
                    }
                    break;
                // 보
                case 3:
                    // 1. 가위
                    if (B[i] == 1) {
                        answer.add("B");
                    }
                    // 2. 바위
                    if (B[i] == 2) {
                        answer.add("A");
                    }
                    // 3. 보
                    if (B[i] == 3) {
                        answer.add("D");
                    }
                    break;
            }
        }

        return answer;

//        ArrayList<String> answer = new ArrayList<>();
//        for (int i = 0; i < n; i++) {
//            if (A[i] == B[i]) answer.add("D");
//            else if (A[i] == 1 && B[i] == 3) answer.add("A");
//            else if (A[i] == 2 && B[i] == 1) answer.add("A");
//            else if (A[i] == 3 && B[i] == 2) answer.add("A");
//            else answer.add("B");
//        }
//      return answer;
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int[] A = new int[n];
        int[] B = new int[n];

        for (int i = 0; i < A.length; i++) {
            A[i] = sc.nextInt();
        }

        for (int i = 0; i < B.length; i++) {
            B[i] = sc.nextInt();
        }

        for (String s : Main2_3.solution(n, A, B)) {
            System.out.println(s);
        }
    }
}
