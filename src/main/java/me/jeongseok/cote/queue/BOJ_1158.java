package me.jeongseok.cote.queue;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.StringTokenizer;

/**
 * 백준 1158 실버(4) 요세푸스 문제
 * 사용한 자료구조 : deque
 */

public class BOJ_1158 {
    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine(), " ");

        LinkedList<Integer> deque = new LinkedList<>();
        StringBuilder sb = new StringBuilder();

        int N = Integer.parseInt(st.nextToken());
        int K = Integer.parseInt(st.nextToken());

        // 1, 2, 3, 4, 5, 6, 7
        for (int i = 1; i <= N; i++) {
            deque.offer(i);
        }

        sb.append("<");
        while (deque.size() != 1) {
            for (int i = 0; i < K - 1; i++) {
                deque.offerLast(deque.pollFirst());
            }
            sb.append(deque.pollFirst() + ", ");
        }
        sb.append(deque.pollFirst());
        sb.append(">");

//        for (int i = 0; i < N; i++) {
//            if (i != K - 1) {
//                int temp = deque.pollFirst();
//                deque.offerLast(temp);
//            } else {
//                sb.append(deque.pollFirst() + ", ");
//                i = -1;
//            }
//
//            if (deque.size() == 1) {
//                sb.append(deque.pollFirst());
//                break;
//            }
//        }


        System.out.println(sb);

        Runtime.getRuntime().gc();
        long usedMemory = Runtime.getRuntime().totalMemory() - Runtime.getRuntime().freeMemory();
        System.out.print(usedMemory + " bytes");
    }
}
