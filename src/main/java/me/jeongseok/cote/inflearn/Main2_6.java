package me.jeongseok.cote.inflearn;

import java.util.*;

public class Main2_6 {
    public static ArrayList<Integer> solution(int[] arr) {

        ArrayList<Integer> resultList = new ArrayList<>();
        ArrayList<Integer> tempList = new ArrayList<>();

        // 숫자를 뒤집는다
        for (int i = 0; i < arr.length; i++) {
            int num = arr[i];
            int reverse = 0;

            while (num != 0) {
                int digit = num % 10;
                reverse = reverse * 10 + digit;
                num /= 10;
            }

            tempList.add(reverse);
        }

        // 소수인지 판별
        for (int i = 0; i < tempList.size(); i++) {
            for (int j = 2; j <= Math.sqrt(tempList.get(i)); j++) {
                if (tempList.get(i) % j == 0) {
                    break;
                }
                resultList.add(tempList.get(i));
            }
        }

        return resultList;
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int[] arr = new int[n];

        for (int i = 0; i < arr.length; i++) {
            arr[i] = sc.nextInt();
        }

        for (int i : Main2_6.solution(arr)) {
            System.out.print(i + " ");
        }
    }
}
