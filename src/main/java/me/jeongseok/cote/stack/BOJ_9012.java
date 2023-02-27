package me.jeongseok.cote.stack;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Stack;

public class BOJ_9012 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int T = Integer.parseInt(br.readLine());
        String[] arr = new String[T];


        for (int i = 0; i < T; i++) {
            arr[i] = br.readLine();
        }

        for (int i = 0; i < arr.length; i++) {
            Stack<Character> stack = new Stack<>();
            for (int j = 0; j < arr[i].length(); j++) {
                if (arr[i].charAt(j) == '(') {
                    stack.push('(');
                }

                if (arr[i].charAt(j) == ')') {
                    if (stack.isEmpty()) {
                        break;
                    } else {
                        stack.pop();
                    }
                }
            }

            if (stack.size() != 0) {
                System.out.println("NO");
            } else {
                System.out.println("YES");
            }
        }




    }
}
