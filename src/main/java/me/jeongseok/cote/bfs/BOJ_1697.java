package me.jeongseok.cote.bfs;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class BOJ_1697 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine(), " ");

        int N = Integer.parseInt(st.nextToken());
        int K = Integer.parseInt(st.nextToken());

        if (N == K) {
            System.out.println(0);
            return;
        }

        int[] distance = new int[200001];
        Queue<Integer> queue = new LinkedList<>();

        for (int i = 1; i < distance.length; i++) {
            distance[i] = -1;
        }

        distance[N] = 0;
        queue.add(N);

        while (true) {
            int cur = queue.poll();

            int x1 = cur - 1;
            int x2 = cur + 1;
            int x3 = cur * 2;

            if (x1 == K || x2 == K || x3 == K) {
                System.out.println(distance[cur] + 1);
                return;
            }

            if (x1 > 0 && x1 < 200000 && distance[x1] == -1) {
                queue.offer(x1);
                distance[x1] = distance[cur] + 1;
            }

            if (x2 > 0 && x2 < 200000 && distance[x2] == -1) {
                queue.offer(x2);
                distance[x2] = distance[cur] + 1;
            }

            if (x3 > 0 && x3 < 200000 && distance[x3] == -1) {
                queue.offer(x3);
                distance[x3] = distance[cur] + 1;
            }
        }
    }
}
