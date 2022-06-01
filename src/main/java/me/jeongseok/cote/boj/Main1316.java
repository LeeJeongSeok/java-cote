package me.jeongseok.cote.boj;

import java.util.Scanner;

/**
 * 1. 단어의 갯수, N개의 단어가 들어온다.
 * 2. 들어온 단어가 그룹 단어 인지 체크하기 위한 별도의 알파벳 배열을 선언해준다.
 * 3. 알파벳 배열을 전부다 0으로 초기화시킨다.
 * 4. 반복문을 돌면서 들어온 문자가 그룹 단어 인지 체크하는데, 알파벳 배열에 1를 넣어준다. 이때 aabb라 할 때 동일한 단어가 옆에 있으면 그룹 속성으로 인해 그룹단어로 칭함
 * 4-1. 즉, 조건에 이미 들어온 문자가 알파벳 배열에 1이 체크가 되어있다면, 여기서 바로 옆에 있는 문자인지, 혹은 떨어져 있는지를 비교한다.
 * 4-2. 그룹단어일 경우 count++
 * 5. 만약 그룹단어가 아니면 count--
 */

public class Main1316 {
    public static int solution(int count, String[] inputs) {

        int answer = count;

        int[] alphabet = new int[26];

        // 알파벳 배열 초기화
        for (int i = 0; i < alphabet.length; i++) {
            alphabet[i] = 0;
        }

        for (int i = 0; i < inputs.length; i++) {
            char[] chars = inputs[i].toCharArray();

            for (int j = 1; j < chars.length; j++) {
                if (alphabet[chars[j]-97] == 0) {
                    alphabet[chars[j]-97] = 1;
                } else {
                    if (chars[j-1] == chars[j]) {
                        continue;
                    } else {
                        answer--;
                    }
                }
            }
        }


        return answer;
    }


    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int count = Integer.parseInt(sc.nextLine());
        String[] inputs = new String[count];
        for (int i = 0; i < count; i++) {
            inputs[i] = sc.nextLine();
        }
        System.out.println(Main1316.solution(count, inputs));
    }
}
