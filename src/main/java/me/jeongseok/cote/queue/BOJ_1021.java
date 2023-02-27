package me.jeongseok.cote.queue;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.StringTokenizer;

public class BOJ_1021 {
    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        LinkedList<Integer> deque = new LinkedList<>();
        int count = 0;

        StringTokenizer st = new StringTokenizer(br.readLine(), " ");
        int N = Integer.parseInt(st.nextToken());
        int M = Integer.parseInt(st.nextToken());

        for (int i = 1; i <= N; i++) {
            deque.offer(i);
        }

        st = new StringTokenizer(br.readLine(), " ");
        int[] targetArr = new int[M];

        for (int i = 0; i < M; i++) {
            targetArr[i] = Integer.parseInt(st.nextToken());
        }

        for (int i = 0; i < M; i++) {
            int targetIdx = deque.indexOf(targetArr[i]);
            int halfIdx;

            if (deque.size() % 2 == 0) {
                halfIdx = deque.size() / 2 - 1;
            } else {
                halfIdx = deque.size() / 2;
            }

            if (targetIdx <= halfIdx) {
                for (int j = 0; j < targetIdx; j++) {
                    int temp = deque.pollFirst();
                    deque.offerLast(temp);
                    count++;
                }
            } else {
                for (int j = 0; j < deque.size() - targetIdx; j++) {
                    int temp = deque.pollLast();
                    deque.offerFirst(temp);
                    count++;
                }
            }
            deque.pollFirst();
        }

        System.out.println(count);

    }
}
