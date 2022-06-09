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

            // 1이면 소수판별할 필요가 없기 때문
            if (reverse != 1) {
                tempList.add(reverse);
            }
        }

        // 소수인지 판별
        for (int i = 0; i < tempList.size(); i++) {
            if (isPrimeNumber(tempList.get(i))) {
                resultList.add(tempList.get(i));
            }
        }

        return resultList;
    }

    public static boolean isPrimeNumber(int n) {

        for (int j = 2; j <= Math.sqrt(n); j++) {
            if (n % j == 0) {
                return false;
            }
        }
        return true;
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
