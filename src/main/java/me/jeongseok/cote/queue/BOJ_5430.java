package me.jeongseok.cote.queue;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

/**
 * 다시 풀어봐야할 문제
 */
public class BOJ_5430 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();

        int testN = Integer.parseInt(br.readLine());

        while (testN-- > 0) {
            LinkedList<Integer> dq = new LinkedList<>();
            char[] func = br.readLine().toCharArray();
            int n = Integer.parseInt(br.readLine());
            boolean chk = true;

            StringTokenizer st = new StringTokenizer(br.readLine(), "[,]");
            for (int i = 0; i < n; i++) {
                dq.add(Integer.parseInt(st.nextToken()));
            }

            for(char c : func) {
                if(c == 'D' && dq.size() == 0) {
                    sb.append("error").append("\n");
                    chk = false;
                    break;
                }

                if(c == 'R') {
                    Collections.reverse(dq);
                }

                if(c == 'D') {
                    dq.remove(0);
                }
            }

            if(chk) {
                sb.append(dq).append("\n");
            }
        }

        System.out.println(sb);

    }
}
